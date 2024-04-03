package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
public class StatusProtocolo {

    public static boolean isAlphanumeric(String str) {
        return str.matches("^[a-zA-Z0-9]+$");
    }
    public static final String NOVO = null;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public StatusProtocolo() {
    }

    public StatusProtocolo(String nome) {
        this.nome = nome;
    }

    @ManyToOne
    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    private Protocolo protocolo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length=20,nullable=false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException{
        
        this.nome = nome;
    }
}
    
