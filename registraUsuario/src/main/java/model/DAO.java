package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class DAO {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url
            = "jdbc:mysql://127.0.0.1:3306/users?useTimezone=true&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "123456";

    private Connection conectar() {
//        Connection con = null;
        try {
            Class.forName(driver);
            Connection con;
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void testeConexao() {

        try {

            Connection con = conectar();
            System.out.println(con);
            System.out.println("");
            System.out.println("foi");
            System.out.println("");
            con.close();

        } catch (SQLException e) {
            System.out.println("");
            System.out.println("NÃO FOI");
            System.out.println("");

            System.out.println(e);

        }
    }

    public void inserirUsuario(Usuario usuario) {
        String create = "insert into minha_tabela3(nome, endereco, cpf, senha)values(?,?,?,?)";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEndereco());
            pst.setString(3, usuario.getCpf());
            pst.setString(4, usuario.getSenha());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public PreparedStatement listaUsuario() throws SQLException {
        Connection con = conectar();
        String procuraTudo = "SELECT * minha_tabela3";
        PreparedStatement pst;
        pst = con.prepareStatement(procuraTudo);
        
        PreparedStatement x = (PreparedStatement) pst.getResultSet();
        ResultSet y;
        y = x.executeQuery();
        y = (ResultSet) (PreparedStatement) y;
//        System.out.println(x);
//        return x;
//    }
        return x;

    }
}
