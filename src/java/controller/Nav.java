/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import model.DAO;

/**
 *
 * @author ratto
 */
@WebServlet(name = "Nav", urlPatterns = {"/Nav"})
public class Nav extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DAO dao = new DAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if("comentarios".equals(request.getParameter("page"))){
            request.setAttribute("Categorias", dao.ListCategory());
            request.setAttribute("Comentarios", dao.ListComent());
            RequestDispatcher rd = request.getRequestDispatcher("Views/comentarios.jsp");
            rd.forward(request,response);
        }else if("login".equals(request.getParameter("page"))){
            String error = request.getParameter("erro");
            request.setAttribute("erro", error);
            RequestDispatcher rd = request.getRequestDispatcher("Views/login.jsp");
            rd.forward(request,response);
        }else if("alt_cat".equals(request.getParameter("page"))){
            request.setAttribute("Categorias", dao.ListCategory());
            RequestDispatcher rd = request.getRequestDispatcher("Views/altera-categoria.jsp");
            rd.forward(request,response);
        }else if("privado".equals(request.getParameter("page"))){
            request.setAttribute("Usuarios", dao.ListUsers());
            RequestDispatcher rd = request.getRequestDispatcher("Views/area-restrita.jsp");
            rd.forward(request,response);
        }else if("principal".equals(request.getParameter("page"))){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }else if("registrar".equals(request.getParameter("page"))){
            String error = request.getParameter("erro");
            request.setAttribute("erro", error);
            RequestDispatcher rd = request.getRequestDispatcher("Views/registro.jsp");
            rd.forward(request,response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
