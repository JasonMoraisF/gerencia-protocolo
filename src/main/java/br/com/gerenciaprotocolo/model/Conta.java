package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Long contaID;

    @Column(name = "agencia", nullable = false, length = 4)
    private String agencia;

    @Column(name = "numero_Conta", nullable = false, length = 10)
    private String numeroConta;

    @Column(name = "tipo_cliente")
    @Enumerated
    private TipoCliente tipoCliente;

    @Column(name= "status_conta")
    private Boolean statusConta;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "titular_id")
    private Titular titular;

    public Long getContaID() {
        return contaID;
    }

    public void setContaID(Long contaID) {
        this.contaID = contaID;
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

    public Boolean getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(Boolean statusConta) {
        this.statusConta = statusConta;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }



    
}
