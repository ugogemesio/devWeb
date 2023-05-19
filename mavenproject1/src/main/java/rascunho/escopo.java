//package rascunho;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//// Classe de modelo para representar um objeto no banco de dados
//
//
//// Classe para gerenciar a conexão com o banco de dados
//class DatabaseConnector {
//    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
//    private static final String USER = "username";
//    private static final String PASS = "password";
//
//    public static Connection getConnection() throws SQLException {
//        try {
//            Class.forName(JDBC_DRIVER);
//            return DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (ClassNotFoundException e) {
//            throw new SQLException("Failed to initialize database driver", e);
//        }
//    }
//}
//
//// Classe que implementa o serviço RESTful
//@Path("/items")
//public class ItemService {
//    // Método para obter todos os itens
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Item> getItems() {
//        // Obter conexão com o banco de dados
//        try (Connection conn = DatabaseConnector.getConnection()) {
//            // Implemente o código para recuperar os itens do banco de dados
//            // e retornar uma lista de objetos Item
//            // Exemplo de código fictício:
//            // List<Item> items = new ArrayList<>();
//            // ...
//            // return items;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Método para obter um item pelo ID
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Item getItem(@PathParam("id") int id) {
//        // Obter conexão com o banco de dados
//        try (Connection conn = DatabaseConnector.getConnection()) {
//            // Implemente o código para recuperar o item do banco de dados com o ID fornecido
//            // e retornar um objeto Item
//            // Exemplo de código fictício:
//            // Item item = ...;
//            // return item;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Método para adicionar um novo item
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addItem(Item item) {
//        // Obter conexão com o banco de dados
//        try (Connection conn = DatabaseConnector.getConnection()) {
//            // Implemente o código para adicionar o item ao banco de dados
//            // Exemplo de código fictício:
//            // ...
//            // return Response.created(...).build();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Método para atualizar um item existente
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateItem(@PathParam("id") int id, Item item) {
//        // Obter conexão com
