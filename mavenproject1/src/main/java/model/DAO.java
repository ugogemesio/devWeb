package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DAO {
    
    
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url
            = "jdbc:mysql://127.0.0.1:3306/users?useTimezone=true&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "123456";

    private Connection conectar() {
        return null;
    }
    
    
    
}
