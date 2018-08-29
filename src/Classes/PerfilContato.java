package Classes;

import java.util.Date;

public class PerfilContato {
    private Date ultima_alteracao;
    private String potencial;
    private String acoes_futuras;
    private String padrao_comportamento;
    private String temp_md_compra;
    private String principal_interesse;

    // Constrututor vazio
    public PerfilContato() {}

    //gets e sets
    public Date getUltima_alteracao() {
        return ultima_alteracao;
    }

    public void setUltima_alteracao(Date ultima_alteracao) {
        this.ultima_alteracao = ultima_alteracao;
    }

    public String getPotencial() {
        return potencial;
    }

    public void setPotencial(String potencial) {
        this.potencial = potencial;
    }

    public String getAcoes_futuras() {
        return acoes_futuras;
    }

    public void setAcoes_futuras(String acoes_futuras) {
        this.acoes_futuras = acoes_futuras;
    }

    public String getPadrao_comportamento() {
        return padrao_comportamento;
    }

    public void setPadrao_comportamento(String padrao_comportamento) {
        this.padrao_comportamento = padrao_comportamento;
    }

    public String getTemp_md_compra() {
        return temp_md_compra;
    }

    public void setTemp_md_compra(String temp_md_compra) {
        this.temp_md_compra = temp_md_compra;
    }

    public String getPrincipal_interesse() {
        return principal_interesse;
    }

    public void setPrincipal_interesse(String principal_interesse) {
        this.principal_interesse = principal_interesse;
    }
}
