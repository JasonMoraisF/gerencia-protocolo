package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contaID")
    private Long contaID;
    
    @Column(name = "titularID")
    private Long titularID;

    @Column(name = "agencia", nullable = false, length = 4)
    private String agencia;

    @Column(name = "numeroConta", nullable = false, length = 10)
    private String numeroConta;

    @Column(name = "tipoClienteID")
    private Long tipoClienteID;

    public Long getContaID() {
        return contaID;
    }

    public void setContaID(Long contaID) {
        this.contaID = contaID;
    }

    public Long getTitularID() {
        return titularID;
    }

    public void setTitularID(Long titularID) {
        this.titularID = titularID;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Long getTipoClienteID() {
        return tipoClienteID;
    }

    public void setTipoClienteID(Long tipoClienteID) {
        this.tipoClienteID = tipoClienteID;
    }

    @Override
    public String toString() {
        return "Conta [contaID=" + contaID + ", titularID=" + titularID + ", agencia=" + agencia + ", numeroConta="
                + numeroConta + ", tipoClienteID=" + tipoClienteID + "]";
    }
}
