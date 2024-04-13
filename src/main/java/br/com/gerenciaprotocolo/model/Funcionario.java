package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private Long funcionarioId;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cargo", nullable = false)
    private String cargo;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

}
