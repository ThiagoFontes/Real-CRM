package Classes;

import java.util.Date;

public class PerfilContato {
    private Date ultimaAlteracao;
    private String potencial;
    private String acoesFuturas;
    private String padraoComportamento;
    private String principalInteresse;

    // Constrututor vazio
    public PerfilContato() {}

    //gets e sets
    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public String getPotencial() {
        return potencial;
    }

    public void setPotencial(String potencial) {
        this.potencial = potencial;
    }

    public String getAcoesFuturas() {
        return acoesFuturas;
    }

    public void setAcoesFuturas(String acoesFuturas) {
        this.acoesFuturas = acoesFuturas;
    }

    public String getPadraoComportamento() {
        return padraoComportamento;
    }

    public void setPadrao_comportamento(String padraoComportamento) {
        this.padraoComportamento = padraoComportamento;
    }

    public String getPrincipal_interesse() {
        return principalInteresse;
    }

    public void setPrincipal_interesse(String principalInteresse) {
        this.principalInteresse = principalInteresse;
    }
}
