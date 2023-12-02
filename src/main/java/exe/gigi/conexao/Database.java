package exe.gigi.conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Database {
    private JdbcTemplate conexao;

    public Database() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gct_individual");
        dataSource.setUsername("aluno");
        dataSource.setPassword("sptech");

        this.conexao = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexao() {
        return conexao;
    }
}
