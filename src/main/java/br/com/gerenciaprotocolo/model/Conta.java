package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Long contaId;

    @Column(name = "agencia", nullable = false)
    private String agencia;

    @Column(name = "numero_conta", nullable = false)
    private String numeroConta;

    @Column(name = "status_conta", nullable = false)
    private String statusConta;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "tipo_cliente", nullable = false)
    private String tipoCliente;

    @Column(name = "telefone", nullable = true)
    private String telefone;

    @Column(name = "ddd", nullable = true)
    private String ddd;

    @Column(name = "tipo_telefone", nullable = true)
    private String tipoTelefone;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

