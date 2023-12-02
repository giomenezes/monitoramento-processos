package exe.gigi.dao;

import exe.gigi.conexao.Database;
import exe.gigi.maquina.Servidor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServidorDao {
    private static Database conexao = new Database();
    private static JdbcTemplate con = conexao.getConexao();

    public static List<Servidor> listar() {
        return con.query("SELECT id_servidor, nome, codigo, descricao, localizacao, status FROM servidor;", new BeanPropertyRowMapper<>(Servidor.class));
    }
}
