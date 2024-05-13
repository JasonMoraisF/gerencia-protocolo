package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Telefone")
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telefone_id")
    private Long telefoneID;

    @Column(name = "numero", nullable = false, length = 9)
    private String numero;

    @Column(name = "DDD", nullable = false, length = 3)
    private String ddd;

  
    @Column(name = "tipo_telefone", nullable = false, length = 11)
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;


    @JsonIgnore
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "titular_id")
    private Titular titular;

    public Long getTelefoneID() {
        return telefoneID;
    }

    public void setTelefoneID(Long telefoneID) {
        this.telefoneID = telefoneID;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    
}
