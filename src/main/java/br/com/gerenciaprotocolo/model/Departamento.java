package br.com.gerenciaprotocolo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "departamento_id")
  private Long departamentoId;

  @Column(name = "nome", nullable = false)
  private String nome;

  @OneToMany(mappedBy = "departamento")
  private List<Funcionario> funcionarios;

}
