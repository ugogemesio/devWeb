<%-- 
    Document   : comentarios
    Created on : Jun 1, 2023, 7:47:53 PM
    Author     : ratto
--%>

<%@page import="model.Categorias"%>
<%@page import="model.DAO"%>
<%@page import="model.Comentarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h2>Área Pública</h2>
                <h3 class="mt-3 mb-3">Lista de Comentários</h3>
                <%
                    DAO dao = new DAO();
                    ArrayList<Comentarios> flau = (ArrayList<Comentarios>) request.getAttribute("Comentarios");
                    for (Comentarios coment : flau) {
                %>
                <div class="card mt-2">
                    <div class="card-body">
                        <h5 class="card-title"><%= coment.getData()%> - <%= dao.buscarUsuarioPorId(coment.getIdusuario()).getNome()%></h5>
                        <h6 class="card-subtitle mt-2 text-muted">Categoria: <%= dao.buscaCategoryPorId(coment.getIdcategoria()).getDescricao()%></h6>
                        <p class="card-text mt-3"><%= coment.getComentario()%></p>
                    </div>
                    <%
                        if (session.getAttribute("nome") != null) {
                    %>
                    <form class="d-flex flex-row align-items-center mx-2 my-2" action="ControllerComentario" method="GET">
                        <button type="submit" name="exc" value="<%= coment.getId()%>" class="btn btn-warning">Excluir</button>
                        <span class="ms-1">verificação:</span>
                        <input class="form-check-input mx-1" type="checkbox" name="v" id="exampleCheckbox">
                    </form>
                    <% } %>
                </div>
                <%
                    }
                %>
                <%
                    if (session.getAttribute("nome") != null) {
                %>
                <form class="card my-2 p-3" action="ControllerComentario" method="POST">
                    <h1>Adicionar Comentário</h1>
                    <div class="form-group">
                        <label for="selectOption">Selecione uma categoria:</label>
                        <select class="form-control" id="selectOption" name="categoria">
                            <%
                                ArrayList<Categorias> temp = (ArrayList<Categorias>) request.getAttribute("Categorias");
                                for (Categorias cat : temp) {
                            %>
                            <option value="<%= cat.getId() %>"><%= cat.getDescricao() %></option>
                            <% }%>
                            <!-- Adicione mais opções, se necessário -->
                        </select>
                    </div>
                    <div class="form-group mt-2">
                        <label for="textareaInput">Digite um texto:</label>
                        <textarea name="comentario" class="form-control" id="textareaInput" rows="5"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary mt-2">Enviar</button>
                </form>
                <% }%>
            </div>
        </div>
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>