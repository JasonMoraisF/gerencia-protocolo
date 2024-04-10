package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteID")
    private Long clienteID;

    @Column(name = "nome", nullable = true, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 10)
    private String email;

    @Column(name = "telefoneID")
    private Long telefoneID;

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefoneID() {
        return telefoneID;
    }

    public void setTelefoneID(Long telefoneID) {
        this.telefoneID = telefoneID;
    }

    @Override
    public String toString() {
        return "Cliente [clienteID=" + clienteID + ", nome=" + nome + ", email=" + email + ", telefoneID=" + telefoneID
                + "]";
    }

}
