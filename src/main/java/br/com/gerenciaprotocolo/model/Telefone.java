package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telefoneId;

    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @Column(name = "ddd", nullable = false, length = 2)
    private String ddd;

    @Column(name = "tipo_telefone", nullable = false, length = 50)
    private String tipoTelefone;


  public Long getTelefoneId() {
    return this.telefoneId;
  }

  public void setTelefoneId(Long telefoneId) {
    this.telefoneId = telefoneId;
  }

  public String getNumero() {
    return this.numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getDdd() {
    return this.ddd;
  }

  public void setDdd(String ddd) {
    this.ddd = ddd;
  }

  public String getTipoTelefone() {
    return this.tipoTelefone;
  }

  public void setTipoTelefone(String tipoTelefone) {
    this.tipoTelefone = tipoTelefone;
  }
    
}
