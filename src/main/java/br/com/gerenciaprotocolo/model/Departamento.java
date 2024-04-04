package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departamentoID;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

  public Departamento(long departamentoID, String nome) {
    this.departamentoID = departamentoID;
    this.nome = nome;
  }
  public Departamento(){
  }

  public Long getdepartamentoId() {
    return this.departamentoID;
  }

  public void setdepartamentoId(Long departamentoId) {
    this.departamentoID = departamentoId;
  }

  public String getnome() {
    return this.nome;
  }

  public void setnome(String nome) {
    this.nome = nome;
  }
    
}
