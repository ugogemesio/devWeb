<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Views/bootstrap/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
    </head>
<body>

    <div class="container">
        <jsp:include page="../Modulos/NavBar.jsp"/>
        <% if(request.getAttribute("erro") != null){ if (request.getAttribute("erro").equals("true")) { %>
            <p style="color: red">Username já utilizado, as Senhas não conferem ou o CPF já foi cadastrado!</p>
        <% }} %>
        <h2>Registro</h2>
        <div class="mb-3">
            <form id="frmContato" action="ControllerRegister" method="POST" >
                <label for="nome">Nome:</label><br>
                <input type="text" name="nome" class="form-control"method="post">
                </div>
                <div class="mb-3">
                    <label for="endereco">Endereço</label><br>
                    <input type="text" name="endereco" class="form-control"method="post">
                </div>
                <div class="mb-3">
                    <label for="cpf">CPF</label><br>
                    <input type="text" name="cpf" class="form-control"method="post">
                </div>
                <div class="mb-3">
                    <label for="senha">Senha</label><br>
                    <input type="password" name="senha" class="form-control"method="post" >
                </div>
                <div class="mb-3">
                    <label for="senha">Redigite a senha</label><br>
                    <input type="password" name="senha2" class="form-control" method="post">
                </div>
                <div>
                    <input type="submit" value="Enviar" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
</body>
</html>