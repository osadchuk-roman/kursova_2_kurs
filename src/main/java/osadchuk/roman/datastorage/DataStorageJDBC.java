package osadchuk.roman.datastorage;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
@Component
public class DataStorageJDBC {
    /*private static final String url = "jdbc:mysql://localhost:3306/information system of sports organizations";
    private static final String login = "root";
    private static final String password = "12345678";

    Connection con;
    Statement statement;

    @PostConstruct
    public void init() throws SQLException {
        con = DriverManager.getConnection(url,login,password);
        statement = con.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException{
        return  statement.executeUpdate(query);
    }

    public DataStorageJDBC() throws SQLException {
    }*/
}
