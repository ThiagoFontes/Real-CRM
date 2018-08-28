package Classes;

import java.sql.*;

public class InteractDAO {
    Connection conn;
    PreparedStatement ps;
    String user = "root"; //nome do usuário do MySQL local
    String password = "m18e3278"; //senha do MySQL local

    public InteractDAO() {}

    // metodos de conexão ao banco de dados

    public void connect() {
        this.conn = null;
        try {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/mydb";
            // create a connection to the database
            this.conn = DriverManager.getConnection(url, user, password);
            System.out.println("conexão sucedida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void disconnect(){
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Metodos de pesquisa do banco de dados, inserir tabela p/ cada uma das classes ,
    public String buscarEmailTabela(String email){
        String emps = null;
        connect();
        String sql = "SELECT senha FROM Usuario WHERE email = "+ email +";";
        Statement statement = null;
        try {
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
            emps = statement.executeQuery(sql).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emps;
    }


}
