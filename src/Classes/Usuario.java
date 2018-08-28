package Classes;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


public class Usuario {

    private String cpf;                    //
    private String nome;                   //  Atributos pertencentes a classe Usuario
    private String email;                  //
    private String senha;                  //
    private String telefone;               //

    //construtor
    public Usuario(String cpf, String nome, String email, String senha, String telefone) {
        setCpf(cpf);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setTelefone(telefone);
    }

    //Metodos de interação com outras classes
    public Boolean validar(String email,String senha) throws RuntimeException {
        Boolean autenticado = Boolean.FALSE;

        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:src/com/company/database/local.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        ResultSet check = null;

        String sql = "SELECT * FROM mydb.Usuario WHERE email = '"+ email +"';";

            try{
                PreparedStatement ps;

                ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, senha);

                check = ps.executeQuery();

                if (check.next()) {
                    String loginBanco = check.getString("email");
                    String senhaBanco = check.getString("senha");
                    autenticado = true;
                }

                ps.close();


                return autenticado;

            } catch (SQLException ex) {
                System.out.println("Erro ao recuperar cliente/ senha.");
                throw new RuntimeException();
            }


    }


    // Gets e Sets
    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
