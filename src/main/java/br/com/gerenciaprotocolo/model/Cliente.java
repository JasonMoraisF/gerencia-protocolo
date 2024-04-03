package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String tipoCliente;

    @ManyToOne
    @JoinColumn(name = "telefone_id", referencedColumnName = "telefone_id")
    private Telefone telefone;

    @ManyToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "conta_id")
    private Conta conta;


  public Long getClienteId() {
    return this.clienteId;
  }

  public void setClienteId(Long clienteId) {
    this.clienteId = clienteId;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTipoCliente() {
    return this.tipoCliente;
  }

  public void setTipoCliente(String tipoCliente) {
    this.tipoCliente = tipoCliente;
  }

  public Telefone getTelefone() {
    return this.telefone;
  }

  public void setTelefone(Telefone telefone) {
    this.telefone = telefone;
  }

  public Conta getConta() {
    return this.conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }
    
}
