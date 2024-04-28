package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "departamento_id")
  private Long departamentoID;

  @Column(name = "nome", nullable = false, length = 50)
  private String nome;
  
  @JsonManagedReference
  @OneToMany(mappedBy = "departamento")
  private List<Funcionario> funcionarios;

  public Long getDepartamentoID() {
    return departamentoID;
  }

  public String getNome() {
    return nome;
  }

  public void setDepartamentoID(Long departamentoID) {
    this.departamentoID = departamentoID;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  
  
}


