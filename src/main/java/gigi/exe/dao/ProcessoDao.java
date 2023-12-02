package gigi.exe.dao;

import com.github.britooo.looca.api.group.processos.Processo;
import gigi.exe.conexao.Database;
import gigi.exe.maquina.CapturaProcesso;
import gigi.exe.maquina.Servidor;
import gigi.exe.menu.Output;
import gigi.exe.utils.Conversor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProcessoDao {
    private static Database conexao = new Database();
    private static JdbcTemplate con = conexao.getConexao();
    public static List<CapturaProcesso> listar() {
        return con.query("""
                SELECT pid, nome, uso_cpu, uso_memoria, bytes_utilizados, swap_utilizada, data_registro FROM processo WHERE fk_servidor = %d;
                """.formatted(Servidor.getIdServidor()), new BeanPropertyRowMapper<>(CapturaProcesso.class));
    }
    public static void inserirProcesso() {
        for (Processo processoAtual: CapturaProcesso.getProcessos()) {
            Integer pid = processoAtual.getPid();
            String nome = processoAtual.getNome();
            double uso_cpu = processoAtual.getUsoCpu();
            double uso_memoria = processoAtual.getUsoMemoria();
            double bytes_utilizados = Conversor.converterGB(processoAtual.getBytesUtilizados());
            double swap_utilizada = Conversor.converterGB(processoAtual.getMemoriaVirtualUtilizada());

            con.update("""
            INSERT INTO processo (pid, nome, uso_cpu, uso_memoria, bytes_utilizados, swap_utilizada, data_registro, fk_servidor) VALUES (%d, '%s',%f, %f, %f, %f, now(), %d);
            """.formatted(pid, nome, uso_cpu, uso_memoria, bytes_utilizados, swap_utilizada, Servidor.getIdServidor()));
        }
    }
}
