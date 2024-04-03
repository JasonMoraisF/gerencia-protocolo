package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaId;

    @Column(name = "funcionario_id", nullable = false)
    private Integer funcionarioId;

    @Column(name = "agencia", nullable = false, length = 4)
    private String agencia;

    @Column(name = "numero_conta", nullable = false, length = 10)
    private String numeroConta;

    @Column(name = "tipo_cliente", nullable = false, length = 50)
    private String tipoCliente;

    @Column(name = "status_conta", nullable = false, length = 50)
    private String statusConta;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;


  public Long getContaId() {
    return this.contaId;
  }

  public void setContaId(Long contaId) {
    this.contaId = contaId;
  }

  public Integer getFuncionarioId() {
    return this.funcionarioId;
  }

  public void setFuncionarioId(Integer funcionarioId) {
    this.funcionarioId = funcionarioId;
  }

  public String getAgencia() {
    return this.agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public String getNumeroConta() {
    return this.numeroConta;
  }

  public void setNumeroConta(String numeroConta) {
    this.numeroConta = numeroConta;
  }

  public String getTipoCliente() {
    return this.tipoCliente;
  }

  public void setTipoCliente(String tipoCliente) {
    this.tipoCliente = tipoCliente;
  }

  public String getStatusConta() {
    return this.statusConta;
  }

  public void setStatusConta(String statusConta) {
    this.statusConta = statusConta;
  }

  public Funcionario getFuncionario() {
    return this.funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }
    
}
