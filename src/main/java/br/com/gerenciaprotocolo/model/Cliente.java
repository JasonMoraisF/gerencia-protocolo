package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteID;

    @Column(name = "nome", nullable = true, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = true, length = 100)
    private String cpf;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "tipo_cliente_id")
    private TipoCliente tipoCliente;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;

    @JsonManagedReference
    @OneToOne(mappedBy = "cliente")
    private Protocolo protocolo;
}
