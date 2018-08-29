package Classes;

import java.util.Date;

public class Relacionamento {
    private int idRelacionamento;
    private char status;
    private Date dataReg;
    private String descReg;
    private String tipo;

    // classe tem controle, construtor vazio
    public Relacionamento() {}

    //gets e sets

    public int getIdRelacionamento() {
        return idRelacionamento;
    }

    public void setIdRelacionamento(int idRelacionamento) {
        this.idRelacionamento = idRelacionamento;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getDataReg() {
        return dataReg;
    }

    public void setDataReg(Date dataReg) {
        this.dataReg = dataReg;
    }

    public String getDescReg() {
        return descReg;
    }

    public void setDescReg(String descReg) {
        this.descReg = descReg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
