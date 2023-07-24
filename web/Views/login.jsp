<%-- 
    Document   : login
    Created on : Jun 1, 2023, 7:45:49 PM
    Author     : ratto
--%>

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
        <jsp:include page="../Modulos/NavBar.jsp" />
        <div class="row justify-content-center mt-3">
            <h2 class="text-center">Login</h2>
            <div class="card p-3" style="width: 40%;">
                <% if(request.getAttribute("erro") != null){ if (request.getAttribute("erro").equals("true")) { %>
                <p style="color: red">Login Incorreto</p>
                <% } else if(request.getAttribute("erro").equals("rep")){ %>
                <p style="color: red">Usuário ainda não aprovado</p>  
                <% }} %>
                <form action="ControllerLogin" method="POST">
                    <div class="mb-2">
                        <label for="usuario" class="form-label">Usuario:</label>
                        <input type="text" name="usuario" class="form-control">
                    </div>
                    <div class="mb-2">
                        <label for="pass" class="form-label">Senha:</label>
                        <input type="password" name="senha" class="form-control">
                    </div>
                    <div>
                        <input type="submit" value="Enviar" class="btn btn-secondary" style="width: 100%">
                    </div>
                </form>
            </div>    
        </div>  
    </div>
    <script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>