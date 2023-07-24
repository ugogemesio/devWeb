<%-- 
    Document   : area-restrita.jsp
    Created on : Jun 1, 2023, 8:25:22 PM
    Author     : ratto
--%>

<%@page import="model.Usuario"%>
<%@page import="model.Categorias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="Views/bootstrap/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <jsp:include page="../Modulos/NavBar.jsp"/>
            <div class="mt-2">
                <h2>Alterar Categoria</h2>
            </div>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <td><h1>Descrição</h1></td>
                            <td><h1>Alterar</h1></td>
                            <td><h1>Excluir</h1></td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Usuario> flau = (ArrayList<Usuario>) request.getAttribute("Usuarios");
                            for (Usuario user : flau) {
                        %>
                        <tr>
                            <td><%= user.getNome()%></td>
                            <td>
                                <div class="d-flex flex-row align-items-center w-25">
                                    <form class="d-flex flex-row align-items-center mx-2" action="ControllerUsers" method="POST">
                                        <% if (user.getAprovado().equals("S")) {%>
                                        <button type="submit" name="rep" value="<%= user.getNome()%>" class="btn btn-warning">Reprovar</button>
                                        <% } else { %>
                                        <button type="submit" class="btn btn btn-secondary" disabled>Reprovar</button>
                                        <% } %>
                                    </form>
                                    <form class="d-flex flex-row align-items-center mx-2" action="ControllerUsers" method="POST">
                                        <% if (user.getAprovado().equals("N")) {%>
                                        <button type="submit" name="apv" value="<%= user.getNome()%>" class="btn btn-success">Aprovar</button>
                                        <% } else { %>
                                        <button type="submit" class="btn btn btn-secondary" disabled>Aprovar</button>
                                        <% }%>
                                        
                                    </form>
                                </div>                              
                            </td>
                            <td>
                                <div class="d-flex flex-row align-items-center w-25">
                                    <form class="d-flex flex-row align-items-center mx-2" action="ControllerUsers" method="GET">
                                        <button type="submit" name="exc" value="<%= user.getNome()%>" class="btn btn-danger">Excluir</button>
                                        <span class="ms-1">verificação:</span>
                                        <input class="form-check-input mx-1" type="checkbox" name="v" id="exampleCheckbox">
                                    </form>
                                </div> 
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>