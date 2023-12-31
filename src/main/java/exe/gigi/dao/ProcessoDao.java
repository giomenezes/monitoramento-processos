package exe.gigi.dao;

import com.github.britooo.looca.api.group.processos.Processo;
import exe.gigi.conexao.MySQL;
import exe.gigi.conexao.SQLServer;
import exe.gigi.maquina.CapturaProcesso;
import exe.gigi.utils.Conversor;
import exe.gigi.maquina.Servidor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProcessoDao {
    private static MySQL conexaoMySQL = new MySQL();
    private static SQLServer conexaoSQL= new SQLServer();
    private static JdbcTemplate conMySQL = conexaoMySQL.getConexao();
    private static JdbcTemplate conSQL = conexaoSQL.getConexao();
    private static Servidor servidor = null;
    public static List<CapturaProcesso> listar(Servidor s) {
        return conSQL.query("""
                SELECT pid, nome, uso_cpu, uso_memoria, bytes_utilizados, swap_utilizada, data_registro FROM processo WHERE fk_servidor = %d;
                """.formatted(s.getIdServidor()), new BeanPropertyRowMapper<>(CapturaProcesso.class));
    }
    public static void inserirProcesso() {
        for (Processo processoAtual: CapturaProcesso.getProcessos()) {
            Integer pid = processoAtual.getPid();
            String nome = processoAtual.getNome();
            double uso_cpu = processoAtual.getUsoCpu();
            double uso_memoria = processoAtual.getUsoMemoria();
            double bytes_utilizados = Conversor.converterGB(processoAtual.getBytesUtilizados());
            double swap_utilizada = Conversor.converterGB(processoAtual.getMemoriaVirtualUtilizada());

//        data MySQL = NOW()
//        data SQL = GETDATE()

            conSQL.update("""
            INSERT INTO processo (pid, nome, uso_cpu, uso_memoria, bytes_utilizados, swap_utilizada, data_registro, fk_servidor) VALUES (%d, '%s',%f, %f, %f, %f, GETDATE(), %d);
            """.formatted(pid, nome, uso_cpu, uso_memoria, bytes_utilizados, swap_utilizada, servidor.getIdServidor()));
        }
    }

    public static void setServidor(Servidor servidor) {
        ProcessoDao.servidor = servidor;
    }
}
