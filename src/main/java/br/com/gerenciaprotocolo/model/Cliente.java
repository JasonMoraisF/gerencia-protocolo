package br.com.gerenciaprotocolo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;

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

    @OneToOne(mappedBy = "cliente")
    private Conta conta;
    
    @OneToMany(mappedBy = "cliente")
    private List<Protocolo> protocolos;
}
