package gigi.exe.dao;

import gigi.exe.conexao.Database;
import gigi.exe.maquina.Servidor;
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
