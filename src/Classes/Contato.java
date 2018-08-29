package Classes;

import java.sql.Date;

public class Contato {

    // atributos da classe de acordo com o diagrama de classe a nivel de projeto
    private String cpfCnpj;
    private String nomeRazao;
    private String categoria;
    private Date dataNasc;
    private String canalCaptacao;
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
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCanalCaptacao() {
        return canalCaptacao;
    }

    public void setCanalCaptacao(String canalCaptacao) {
        this.canalCaptacao = canalCaptacao;
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