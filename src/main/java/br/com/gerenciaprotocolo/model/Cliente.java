package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteID;
    
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "protocolo_id", nullable = true)
    private Protocolo protocolo;

    @Column(name = "nome", nullable = true, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = true, length = 11)
    private String cpf;

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @Column(name = "tipo_cliente", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;


    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

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
