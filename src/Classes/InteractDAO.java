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
            disconnect();
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
            disconnect();
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
            disconnect();
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


    //Metodos de Crud para Contato

    public Contato buscarContato(String cpf_cnpj){
        Contato resultado = null;

        connect();
        String sql = "SELECT * FROM mydb.Contato WHERE CPF_CNPJ = '"+ cpf_cnpj +";";
        Statement statement;
        try{
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                resultado.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                resultado.setEmail(rs.getString("email"));
                resultado.setTelefone(rs.getString("telefone"));
                resultado.setNome_razao(rs.getString("Nome"));
                resultado.setCategoria(rs.getString("categoria"));
                resultado.setData_nasc(rs.getDate("data_nasc"));
                resultado.setCanal_captacao(rs.getString("canal_captacao"));
                resultado.setFacebook(rs.getString("facebook"));
                resultado.setInstagram(rs.getString("instagram"));
                resultado.setTwitter(rs.getString("twitter"));
                resultado.setLinkedIn(rs.getString("linkedin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return resultado;
    }

    public boolean createContato(Contato novo){
        connect();

        String sql = "INSERT INTO mydb.Contato VALUES('"+ novo.getCpf_cnpj() +"','"+ novo.getNome_razao() +
                "','"+ novo.getCategoria() +"','"+ novo.getData_nasc() +",'"+ novo.getCanal_captacao() +"'," +
                " '"+ novo.getEmail() +"','"+novo.getTelefone()+"','"+ novo.getFacebook() +"','"+ novo.getTwitter() +
                "', '"+ novo.getInstagram() +"', '"+ novo.getLinkedIn() +"');";

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            disconnect();
            return false;
        }

        disconnect();
        return true;
    }

    public boolean updateContato(Contato edit){
        connect();

        String sql = "UPDATE mydb.Contato SET CPF_CNPJ = '"+ edit.getCpf_cnpj() +"', Nome = '"+ edit.getNome_razao() +
                "', categoria = '"+ edit.getCategoria() +"', email = '"+ edit.getEmail() +"', data_nasc ='"+
                edit.getData_nasc() +"', canal_captacao = '"+ edit.getCanal_captacao()
                +"', telefone = '"+ edit.getTelefone() +"', facebook = '"+ edit.getFacebook()
                +"', twitter = '"+ edit.getTwitter() +"', instagram = '"+ edit.getInstagram()
                +"', linkedin = '"+ edit.getLinkedIn() +"' WHERE CPF_CNPJ = '"+ edit.getCpf_cnpj() +"'";

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            disconnect();
            return false;
        }

        disconnect();
        return true;
    }

    public boolean deleteContato(String cpf_cnpj){
        connect();

        String sql = "DELETE FROM mydb.Contato WHERE CPF_CNPJ = '"+ cpf_cnpj +"';";
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            disconnect();
            return false;
        }

        disconnect();

        return false;
    }



}
