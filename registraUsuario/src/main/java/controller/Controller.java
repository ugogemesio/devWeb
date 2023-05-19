package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import model.DAO;
import model.Usuario;

@WebServlet(urlPatterns = {"/Controller", "/altera-categoria", "/area-restrita",
    "/login", "/registro", "/insert", "/lista-usuario"})
public class Controller extends HttpServlet {

    DAO dao = new DAO();
    Usuario usuario = new Usuario();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/altera-categoria")) {
            alteraCategoria(request, response);
        }
        if (action.equals("/area-restrita")) {
            areaRestrita(request, response);
        }
        if (action.equals("/login")) {
            login(request, response);
        }
        if (action.equals("/registro")) {
            registro(request, response);
        }
        if (action.equals("/insert")) {
            novoUsuario(request, response);
        }
        if (action.equals("/lista-usuario")) {
            try {
                listaUsuario(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            processRequest(request, response);
        }
    }

    protected void alteraCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("altera-categoria.html");
    }

    private void areaRestrita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("area-restrita.html");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    private void registro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registro.html");

    }

    private void listaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PreparedStatement x;
        x = dao.listaUsuario();

        try ( PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + x + "</h1>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        usuario.setNome(request.getParameter("nome"));
        usuario.setEndereco(request.getParameter("endereco"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSenha(request.getParameter("senha"));
        dao.inserirUsuario(usuario);
        response.sendRedirect("/login.html");

    }

    //como criar tabulação dinamica com números de usuários  
//        for (int i = 0; i < numUsuarios; i++) {
//            tabelaHTML.append("<tr>");
//            tabelaHTML.append("<td>Usuário " + (i + 1) + "</td>");
//            tabelaHTML.append("<td>Dados adicionais</td>");
//            tabelaHTML.append("</tr>");
//        }
//        tabelaHTML.append("</table>");
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        }
    }

//
//
//
//
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
