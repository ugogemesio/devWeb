package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    ConexaoDAO conexao = new ConexaoDAO();

    public void NewUser(Usuario user) {
        String newUser = "INSERT INTO usuarios(nome,cpf,senha,endereco,aprovado)"
                + " VALUES (?,?,?,?,?)";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(newUser);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getCpf());
            pst.setString(3, user.getSenha());
            pst.setString(4, user.getEndereco());
            pst.setString(5, user.getAprovado());
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void SwitchStatusUser(String nome, String status) {
        String updCat = "UPDATE usuarios SET aprovado=? WHERE nome=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(updCat);
            pst.setString(2, nome);
            pst.setString(1, status);
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void DeleteUser(String nome) {
        String delUser = "DELETE FROM usuarios WHERE nome=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(delUser);
            pst.setString(1, nome);
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Usuario> ListUsers() {
        String selUsers = "SELECT * FROM usuarios";
        ArrayList<Usuario> users = new ArrayList<>();
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(selUsers);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int iduser = rs.getInt(1);
                String username = rs.getString(2);
                String senha = rs.getString(4);
                String endereco = rs.getString(5);
                String cpf = rs.getString(3);
                String aprovado = rs.getString(6);
                users.add(new Usuario(iduser, username, endereco, cpf, senha, aprovado));
            }
            con.getConexao().close();
            pst.close();
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean isCpfRegistrado(String cpf) {
        String query = "SELECT cpf FROM usuarios WHERE cpf = ?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(query);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            boolean cpfRegistrado = rs.next(); // true se o CPF já estiver registrado, false caso contrário
            con.getConexao().close();
            pst.close();
            return cpfRegistrado;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean isUsernameRegistrado(String username) {
        String query = "SELECT nome FROM usuarios WHERE nome = ?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            boolean cpfRegistrado = rs.next(); // true se o CPF já estiver registrado, false caso contrário
            con.getConexao().close();
            pst.close();
            return cpfRegistrado;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Usuario buscarUsuarioPorId(int id) {
        String query = "SELECT * FROM usuarios WHERE id= ?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int iduser = rs.getInt(1);
                String username = rs.getString(2);
                String senha = rs.getString(4);
                String endereco = rs.getString(5);
                String cpf = rs.getString(3);
                String aprovado = rs.getString(6);
                Usuario usuario = new Usuario(iduser, username, endereco, cpf, senha, aprovado);
                con.getConexao().close();
                pst.close();
                return usuario;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        String query = "SELECT * FROM usuarios WHERE nome = ?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(query);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String senha = rs.getString(4);
                String endereco = rs.getString(5);
                String cpf = rs.getString(3);
                String aprovado = rs.getString(6);
                Usuario usuario = new Usuario(id, username, endereco, cpf, senha, aprovado);
                con.getConexao().close();
                pst.close();
                return usuario;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void NewCategory(Categorias cat) {
        String newCat = "INSERT INTO categorias(descricao)"
                + " VALUES (?)";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(newCat);
            pst.setString(1, cat.getDescricao());
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void UpdateCategory(int descId, String descNova) {
        String updCat = "UPDATE categorias SET descricao=? WHERE id=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(updCat);
            pst.setInt(2, descId);
            pst.setString(1, descNova);
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void DeleteCategory(String desc) {
        String delCat = "DELETE FROM categorias WHERE descricao=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(delCat);
            pst.setString(1, desc);
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Categorias> ListCategory() {
        String selCat = "SELECT * FROM categorias";
        ArrayList<Categorias> cat = new ArrayList<>();
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(selCat);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String descricao = rs.getString(2);
                cat.add(new Categorias(id, descricao));
            }
            con.getConexao().close();
            pst.close();
            return cat;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Categorias buscaCategoryPorId(int id) {
        String selCat = "SELECT * FROM categorias WHERE id=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(selCat);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            Categorias result = new Categorias();
            while (rs.next()) {
                int idcat = rs.getInt(1);
                String descricao = rs.getString(2);
                result.setDescricao(descricao);
                result.setId(idcat);
            }
            con.getConexao().close();
            pst.close();
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Categorias buscaCategoryPorDesc(String desc) {
        String selCat = "SELECT * FROM categorias WHERE descricao=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(selCat);
            pst.setString(1, desc);
            ResultSet rs = pst.executeQuery();
            Categorias result = new Categorias();
            while (rs.next()) {
                int id = rs.getInt(1);
                String descricao = rs.getString(2);
                result.setDescricao(descricao);
                result.setId(id);
            }
            con.getConexao().close();
            pst.close();
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void NewComent(String coment, Date data, int descId, String username) {
        String newComent = "INSERT INTO comentarios(comentario, data, idcategoria, idusuario)"
                + " VALUES (?,?,?,?)";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(newComent);
            pst.setString(1, coment);
            pst.setDate(2, data);
            pst.setInt(3, buscaCategoryPorId(descId).getId());
            pst.setInt(4, buscarUsuarioPorNome(username).getId());
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Comentarios> ListComent() {
        String selCat = "SELECT * FROM comentarios";
        ArrayList<Comentarios> coment = new ArrayList<>();
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(selCat);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String comentario = rs.getString(2);
                Date data = rs.getDate(3);
                int idcategoria = rs.getInt(4);
                int idusuario = rs.getInt(5);
                coment.add(new Comentarios(id, comentario, data, idcategoria, idusuario));
            }
            con.getConexao().close();
            pst.close();
            return coment;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Comentarios buscaComent(int id) {
        String selComent = "SELECT * FROM comentarios WHERE id=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(selComent);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            Comentarios result = new Comentarios();
            while (rs.next()) {
                result.setId(rs.getInt(1));
                result.setComentario(rs.getString(2));
                result.setData(rs.getDate(3));
                result.setIdcategoria(rs.getInt(4));
                result.setIdusuario(rs.getInt(5));
            }
            con.getConexao().close();
            pst.close();
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void DeleteComent(Comentarios coment) {
        String delComent = "DELETE FROM comentarios WHERE id=?";
        try {
            ConexaoDAO con = new ConexaoDAO();
            PreparedStatement pst = con.getConexao().prepareStatement(delComent);
            pst.setInt(1, coment.getId());
            pst.executeUpdate();
            con.getConexao().close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
//

/*
    public void testeConexao() {

        try {

            Connection con = conectar();
            con.close();

        } catch (SQLException e) {

        }
    }
//

    public void inserirUsuario(Usuario usuario) {
        String create = "INSERT INTO minha_tabela3(nome, endereco, cpf, senha) VALUES (?, ?, ?, ?)";
        String updateSequence = "ALTER TABLE minha_tabela3 AUTO_INCREMENT = 1";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEndereco());
            pst.setString(3, usuario.getCpf());
            pst.setString(4, usuario.getSenha());
            pst.executeUpdate();
            pst.close();

            // Atualizar a sequência da chave primária
            PreparedStatement updatePst = con.prepareStatement(updateSequence);
            updatePst.executeUpdate();

            con.close();

            updatePst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;

        }
    }
//

    public ArrayList<Usuario> listarContatos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String read = "SELECT * FROM minha_tabela3";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idcon = rs.getInt(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String cpf = rs.getString(4);
                String senha = rs.getString(5);
                String aprovado = rs.getString( 6);
                usuarios.add(new Usuario(idcon, nome, endereco, cpf, senha, aprovado));
            }
            con.close();
            return usuarios;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
//

    public void deletaUsuario(Usuario user) {
        String delete = "DELETE FROM minha_tabela3 WHERE idcon=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, user.getId());
            pst.executeUpdate();

            // Atualizar a sequência da chave primária
            PreparedStatement updatePst = con.prepareStatement("ALTER TABLE minha_tabela3 AUTO_INCREMENT = 1");
            updatePst.executeUpdate();

            // Obter a lista atualizada de usuários
            ArrayList<Usuario> usuarios = listarContatos();

            // Limpar a tabela
            PreparedStatement truncatePst = con.prepareStatement("TRUNCATE TABLE minha_tabela3");
            truncatePst.executeUpdate();

            // Inserir os usuários novamente na ordem correta
            for (Usuario u : usuarios) {
                inserirUsuario(u);
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//

    public Usuario buscarUsuarioPorId(String id) {
        String query = "SELECT * FROM minha_tabela3 WHERE idcon = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String idcon = rs.getString(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String cpf = rs.getString(4);
                String senha = rs.getString(5);
                Usuario usuario = new Usuario(idcon, nome, endereco, cpf, senha);
                pst.close();
                con.close();
                return usuario;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
//

    public void atualizaUsuario(Usuario usuario) {
        String update = "UPDATE minha_tabela3 SET nome=?, endereco=?, cpf=?, senha=? WHERE idcon=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEndereco());
            pst.setString(3, usuario.getCpf());
            pst.setString(4, usuario.getSenha());
            pst.setString(5, usuario.getId());
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
//

    public Usuario buscarUsuarioPorNomeSenha(String nome, String senha) {
        String query = "SELECT * FROM minha_tabela3 WHERE nome = ? AND senha = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, nome);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String idcon = rs.getString(1);
                String endereco = rs.getString(3);
                String cpf = rs.getString(4);
                Usuario usuario = new Usuario(idcon, nome, endereco, cpf, senha);
                pst.close();
                con.close();
                return usuario;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
 */
