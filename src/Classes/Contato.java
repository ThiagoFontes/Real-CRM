package Classes;

import java.sql.Date;

public class Contato {

    // atributos da classe de acordo com o diagrama de classe a nivel de projeto
    private String cpf_cnpj;
    private String nome_razao;
    private String categoria;
    private Date data_nasc;
    private String canal_captacao;
    private String email;
    private String telefone;
    private String facebook;
    private String instagram;
    private String twitter;
    private String linkedIn;

    //CONSTRUTOR VAZIO
    public Contato() {}

    //Metodos listados no diagrama são apenas os gets e sets segundo professor

    //gets and sets dos atributos da classe
    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome_razao() {
        return nome_razao;
    }

    public void setNome_razao(String nome_razao) {
        this.nome_razao = nome_razao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getCanal_captacao() {
        return canal_captacao;
    }

    public void setCanal_captacao(String canal_captacao) {
        this.canal_captacao = canal_captacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instragram) {
        this.instagram = instragram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
}