package Classes;

import java.util.Date;

public class Negociacao {
    private int idNegociacao;
    private char status;
    private Date dataAbertura;
    private Date dataEfetivacao;
    private String tipo;
    private float valor;
    private String descricao;

    //construtor vazio
    public Negociacao() {}

    //gets e sets
    public int getIdNegociacao() {
        return idNegociacao;
    }

    public void setIdNegociacao(int idNegociacao) {
        this.idNegociacao = idNegociacao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEfetivacao() {
        return dataEfetivacao;
    }

    public void setDataEfetivacao(Date dataEfetivacao) {
        this.dataEfetivacao = dataEfetivacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
