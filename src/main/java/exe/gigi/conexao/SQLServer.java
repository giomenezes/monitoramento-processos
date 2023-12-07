package exe.gigi.conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQLServer {
    private JdbcTemplate conexao;

    public SQLServer() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://44.218.55.108:1433;databaseName=scriptgct;encrypt=false;user=sa;password=urubu100");
        dataSource.setUsername("sa");
        dataSource.setPassword("urubu100");

        this.conexao = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexao() {
        return conexao;
    }
}
