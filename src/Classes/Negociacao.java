package Classes;

import java.util.Date;

public class Negociacao {
    private int id_negociacao;
    private char status;
    private Date data_abertura;
    private Date data_efetivacao;
    private String tipo;
    private float valor;
    private String descricao;

    //construtor vazio
    public Negociacao() {}

    //gets e sets
    public int getId_negociacao() {
        return id_negociacao;
    }

    public void setId_negociacao(int id_negociacao) {
        this.id_negociacao = id_negociacao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_efetivacao() {
        return data_efetivacao;
    }

    public void setData_efetivacao(Date data_efetivacao) {
        this.data_efetivacao = data_efetivacao;
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
