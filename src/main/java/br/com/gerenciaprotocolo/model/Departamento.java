package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

  @JsonBackReference
  @OneToMany(mappedBy = "departamento")
  private List<Funcionario> funcionarios;

  public Long getDepartamentoId() {
    return departamentoId;
  }

  public void setDepartamentoId(Long departamentoId) {
    this.departamentoId = departamentoId;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
  }

}
