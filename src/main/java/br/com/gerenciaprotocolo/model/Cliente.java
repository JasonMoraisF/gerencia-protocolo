package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteID;

    @Column(name = "nome", nullable = true, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = true, length = 100)
    private String cpf;

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "tipo_cliente_id", nullable = true)
    private TipoCliente tipoCliente;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;

    @JsonIgnore
    @JsonBackReference
    @OneToOne(mappedBy = "cliente")
    private Protocolo protocolo;

    public Long getClienteID() {
        return clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }
}
