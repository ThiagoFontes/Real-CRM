package Classes;

import java.sql.*;

public class InteractDAO {
    private Connection conn;
    private String user = "root"; //nome do usuário do MySQL local
    private String password = "m18e3278"; //senha do MySQL local

    public InteractDAO() {}

    // metodos de conexão ao banco de dados

    private void connect() {
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
    private void disconnect(){
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Metodos de Crud para Usuario
    public String loginUsuario(String email){
        String emps = null;
        connect();
        String sql = "SELECT senha FROM Usuario WHERE email = "+ email +";";
        Statement statement;
        try {
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
            emps = statement.executeQuery(sql).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return emps;
    }

    public boolean createUsuario(Usuario novo){
        connect();

        String sql = "INSERT INTO mydb.Usuario VALUES('"+ novo.getCpf() +"','"+ novo.getNome() +
                "','"+ novo.getSenha() +"','"+ novo.getEmail() +"')";

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        disconnect();
        return true;
    }

    public boolean updateUsuario(Usuario edit){
       connect();

       String sql = "UPDATE mydb.Usuario SET cpf = '"+ edit.getCpf() +"', nome = '"+ edit.getNome() +
               "', senha = '"+ edit.getSenha() +"', email = '"+ edit.getEmail() +"' WHERE cpf = '"+ edit.getCpf() +"'";

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

       disconnect();
       return true;
    }

    public boolean deleteUsuario(Usuario delete){
        connect();

        String sql = "DELETE FROM mydb.Usuario WHERE cpf = '"+ delete.getCpf()+"', nome = '"+ delete.getNome() +
                "', senha = '"+ delete.getSenha() +"', email = '"+ delete.getEmail() +"' WHERE cpf = '"+ delete.getCpf() +"'";
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        disconnect();
        return false;
    }

    public Usuario buscarUsuario(String cpf, String email){
        Usuario user = null;
        connect();
        String sql = "SELECT * FROM mydb.Usuario WHERE cpf = '"+ cpf +"', email = '"+ email +"';";
        Statement statement;
        try{
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                user.setCpf(cpf);
                user.setEmail(rs.getString("email"));
                user.setTelefone(rs.getString("telefone"));
                user.setSenha(rs.getString("senha"));
                user.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return user;
    }



}
