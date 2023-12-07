package exe.gigi.dao;

import exe.gigi.conexao.MySQL;
import exe.gigi.conexao.SQLServer;
import exe.gigi.maquina.Servidor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServidorDao {
    private static MySQL conexaoMySQL = new MySQL();
    private static SQLServer conexaoSQL = new SQLServer();

    private static JdbcTemplate conMySQL = conexaoMySQL.getConexao();
    private static JdbcTemplate conSQL = conexaoSQL.getConexao();

    public static List<Servidor> listar() {
        return conSQL.query("SELECT id_servidor, nome, codigo, descricao, localizacao, status FROM servidor;", new BeanPropertyRowMapper<>(Servidor.class));
    }
}
