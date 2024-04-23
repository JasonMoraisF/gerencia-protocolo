package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Telefone")
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telefone_id")
    private Long telefoneID;

    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @Column(name = "DDD", nullable = false, length = 3)
    private String ddd;

    @Column(name = "tipo_telefone", nullable = false, length = 10)
    private String tipoTelefone;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "titular_id")
    private Titular titular;

    
}
