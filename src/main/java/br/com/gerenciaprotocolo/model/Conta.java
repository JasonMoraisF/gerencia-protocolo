package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Long contaID;

    @Column(name = "agencia", nullable = false, length = 4)
    private String agencia;

    @Column(name = "numero_Conta", nullable = false, length = 10)
    private String numeroConta;

    @Column(name = "tipo_cliente_id")
    private Long tipoClienteID;

    @Column(name= "status_conta")
    private Boolean statusConta;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "titular_id")
    private Titular titular;
}
