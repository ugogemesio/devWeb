<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="fontesBoostrap/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilo.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="login.html">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Comentários</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.html">Login</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="table-responsive">
            <h1>Área restrita</h1>
            <h2>Lista de usuários</h2>
            <a href="registro" class="btn btn-primary">Incluir</a>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Nome</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Usuario> flau = (ArrayList<Usuario>) request.getAttribute("listinha");
                        for (Usuario usuario : flau) {
                    %>
                    <tr>
                        <td><%= usuario.getId() %></td>
                        <td><%= usuario.getNome() %></td>
                        <td>
                            <a href="altera-usuario?id=<%= usuario.getId() %>" class="btn btn-danger">Editar</a>
                            <a href="javascript:confirmar('<%= usuario.getId() %>')" class="btn btn-warning">Excluir</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
    <script src="scripts/confirmador.js"></script>
    <script src="fontesBoostrap/bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>
