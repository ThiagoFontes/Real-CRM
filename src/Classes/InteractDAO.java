package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        String sql = "INSERT INTO Usuario VALUES('"+ novo.getCpf() +"','"+ novo.getNome() +
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

       String sql = "UPDATE Usuario SET cpf = '"+ edit.getCpf() +"', nome = '"+ edit.getNome() +
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

        String sql = "DELETE FROM Usuario WHERE cpf = '"+ delete.getCpf()+"', nome = '"+ delete.getNome() +
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
        String sql = "SELECT * FROM Usuario WHERE cpf = '"+ cpf +"', email = '"+ email +"';";
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
        String sql = "SELECT * FROM Contato WHERE cpfCnpj = '"+ cpf_cnpj +";";
        Statement statement;
        try{
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                resultado.setCpfCnpj(rs.getString("cpfCnpj"));
                resultado.setEmail(rs.getString("email"));
                resultado.setTelefone(rs.getString("telefone"));
                resultado.setNomeRazao(rs.getString("Nome"));
                resultado.setCategoria(rs.getString("categoria"));
                resultado.setDataNasc(rs.getDate("dataNasc"));
                resultado.setCanalCaptacao(rs.getString("canalCaptacao"));
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

        String sql = "INSERT INTO Contato VALUES('"+ novo.getCpfCnpj() +"','"+ novo.getNomeRazao() +
                "','"+ novo.getCategoria() +"','"+ novo.getDataNasc() +",'"+ novo.getCanalCaptacao() +"'," +
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

        String sql = "UPDATE Contato SET cpfCnpj = '"+ edit.getCpfCnpj() +"', Nome = '"+ edit.getNomeRazao() +
                "', categoria = '"+ edit.getCategoria() +"', email = '"+ edit.getEmail() +"', dataNasc ='"+
                edit.getDataNasc() +"', canalCaptacao = '"+ edit.getCanalCaptacao()
                +"', telefone = '"+ edit.getTelefone() +"', facebook = '"+ edit.getFacebook()
                +"', twitter = '"+ edit.getTwitter() +"', instagram = '"+ edit.getInstagram()
                +"', linkedin = '"+ edit.getLinkedIn() +"' WHERE cpfCnpj = '"+ edit.getCpfCnpj() +"'";

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

    public boolean deleteContato(String cpfCnpj){
        connect();

        String sql = "DELETE FROM Contato WHERE cpfCnpj = '"+ cpfCnpj +"';";
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

    public List<Contato> listarContatos(){
        List<Contato> lista = new ArrayList<>();
        connect();
        String sql = "SELECT * FROM Contato ;";
        //while(){
        // incompleto , nao sei como listar
        //}
        disconnect();
        return lista;
    }

    //metodos para crud de Endereço
    public Endereco buscarEndereco(String cpfCnpj){
        Endereco local = null;
        connect();
        String sql = "SELECT * FROM Contato WHERE cpfCnpj = '"+ cpfCnpj +";";
        Statement statement;
        try{
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                local.setLogradouro(rs.getString("logradouro"));
                local.setBairro(rs.getString("bairro"));
                local.setCep(rs.getString("cep"));
                local.setCidade(rs.getString("cidade"));
                local.setEstado(rs.getString("estado"));
                local.setNumero(rs.getInt("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return local;
    }


    //metodos para Crud de PerfilContato


}
