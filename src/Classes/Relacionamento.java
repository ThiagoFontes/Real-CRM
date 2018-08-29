package Classes;

import java.util.Date;

public class Relacionamento {
    private int id_relacionamento;
    private char status;
    private Date data_reg;
    private String desc_reg;
    private String tipo;

    // classe tem controle, construtor vazio
    public Relacionamento() {}

    //gets e sets

    public int getId_relacionamento() {
        return id_relacionamento;
    }

    public void setId_relacionamento(int id_relacionamento) {
        this.id_relacionamento = id_relacionamento;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getData_reg() {
        return data_reg;
    }

    public void setData_reg(Date data_reg) {
        this.data_reg = data_reg;
    }

    public String getDesc_reg() {
        return desc_reg;
    }

    public void setDesc_reg(String desc_reg) {
        this.desc_reg = desc_reg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
