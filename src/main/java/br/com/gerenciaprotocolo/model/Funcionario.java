package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_funcionario_id")
    private Long codigoFuncionarioID;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cargos_id")
    private Cargos cargos;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "situacaoProtocolo_id")
    private SituacaoProtocolo situacaoProtocolo;

}
