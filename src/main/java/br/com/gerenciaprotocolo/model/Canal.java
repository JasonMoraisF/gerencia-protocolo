// package br.com.gerenciaprotocolo.model;

// import jakarta.persistence.*;

// @Entity

// public class Canal {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String nome;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     @Column(nullable = false, unique = true)
//     public String getNome() {
//         return nome;
//     }

//     public void setNome(String nome) throws IllegalArgumentException{
//         if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("O campo 'Nome' não pode ser null");
        
// }}
