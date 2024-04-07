package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Titular")
public class Titular {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titularID")
    private Long titularID;

    @Column(name = "cpf", nullable = false, length = 10)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 10)
    private String email;

    @Column(name = "telefoneID")
    private Long telefoneID;

    @Column(name = "Profissao", nullable = false, length = 50)
    private String Profissao;

    @Override
    public String toString() {
        return "Titular [titularID=" + titularID + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email
                + ", telefoneID=" + telefoneID + ", Profissao=" + Profissao + "]";
    }

    public Long getTitularID() {
        return titularID;
    }

    public void setTitularID(Long titularID) {
        this.titularID = titularID;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getProfissao() {
        return Profissao;
    }

    public void setProfissao(String profissao) {
        Profissao = profissao;
    }


}
