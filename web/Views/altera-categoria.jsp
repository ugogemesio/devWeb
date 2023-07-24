<%-- 
    Document   : area-restrita.jsp
    Created on : Jun 1, 2023, 8:25:22 PM
    Author     : ratto
--%>

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
                            ArrayList<Categorias> flau = (ArrayList<Categorias>) request.getAttribute("Categorias");
                            for (Categorias cat : flau) {
                        %>
                        <tr>
                            <td><%= cat.getDescricao()%></td>
                            <td>
                                <div class="d-flex flex-row align-items-center w-25">
                                    <form class="d-flex flex-row align-items-center mx-2" action="ControllerCategoria" method="POST">
                                        <input type="hidden" name="desc" value="<%= cat.getId() %>">
                                        <input style="width: 200px" type="text" name="updcat" class="form-control">
                                        <button style="margin-left: 15px" type="submit" value="alt" name="type" class="btn btn-warning">Alterar</button>
                                    </form>
                                </div>                              
                            </td>
                            <td>
                                <div class="d-flex flex-row align-items-center w-25">
                                    <form class="d-flex flex-row align-items-center mx-2" action="ControllerCategoria" method="GET">
                                        <button type="submit" name="exc" value="<%= cat.getDescricao()%>" class="btn btn-danger">Excluir</button>
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
            <div>
                <form class="d-flex flex-row align-items-center" action="ControllerCategoria" method="POST">
                    <input style="width:10%" type="text" name="newcat" class="form-control">
                    <button style="width:5%; margin-left: 15px" value="new" name="type" type="submit" class="btn btn-primary">+</button>
                </form>
            </div>
        </div>
    </body>
</html>