/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class ConexaoDAO {
    private Connection conexao;
    
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/trab?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=123456";
    private final String user = "root";
    private final String password = "123456";
//

    public ConexaoDAO() {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
    
    public void closeConexao() {
        try {
            this.conexao.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
