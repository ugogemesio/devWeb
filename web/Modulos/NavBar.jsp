<%-- 
    Document   : NavBar
    Created on : Jun 1, 2023, 7:29:25 PM
    Author     : ratto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
              <a class="navbar-brand" href="/Trabalho/Nav?page=comentarios">Comentários</a>
              <!--<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button> -->
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <% 
                    if(session.getAttribute("nome") != null){
                  %>
                  <li class="nav-item">
                      <a class="nav-link" href="/Trabalho/Nav?page=alt_cat">Alterar Categorias</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/Trabalho/Nav?page=privado">Área Restrita</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="/Trabalho/ControllerLogin?logout=true">Logout</a>
                  </li>
                  <% } else { %>
                  <li class="nav-item">
                    <a class="nav-link" href="/Trabalho/Nav?page=login">Login</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/Trabalho/Nav?page=registrar">Registro</a>
                  </li>
                  <% } %>
                </ul>
                <!-- <form class="d-flex" role="search">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Search</button>
                </form> -->
              </div>
            </div>
          </nav>  

