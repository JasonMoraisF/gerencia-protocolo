package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Titular")
public class Titular {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titular_id")
    private Long titularID;

    @Column(name = "cpf", nullable = false, length = 10)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 10)
    private String email;

    @Column(name = "profissao", nullable = false, length = 50)
    private String Profissao;

    @JsonManagedReference
    @OneToMany(mappedBy = "titular")
    private List<Telefone> telefones;

    @JsonManagedReference
    @OneToOne(mappedBy = "titular")
    private Conta conta;

    public Long getTitularID() {
        return titularID;
    }

    public void setTitularID(Long titularID) {
        this.titularID = titularID;
    }

    

}
