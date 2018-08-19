package com.company;

import java.util.Date;

/**
 * Created by Thiago Fontes on 18/08/2018.
 */
public class Contato {
    private String cpf_cnpj;
    private String nome_razao;
    private Date data_nasc;
    private String canal_captacao;
    private String e_mail;
    private String telefone;
    private String facebook;
    private String instagram;
    private String twitter;
    private String linkedin;

    //Construtor com todas as variáveis
    public Contato (String cpf_cnpj, String nome_razao, Date data_nasc, String canal_captacao, String e_mail, String telefone, String facebook, String instagram, String twitter, String linkedin) {
        this.cpf_cnpj = cpf_cnpj;
        this.nome_razao = nome_razao;
        this.data_nasc = data_nasc;
        this.canal_captacao = canal_captacao;
        this.e_mail = e_mail;
        this.telefone = telefone;
        this.facebook = facebook;
        this.instagram = instagram;
        this.twitter = twitter;
        this.linkedin = linkedin;
    }


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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
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

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
