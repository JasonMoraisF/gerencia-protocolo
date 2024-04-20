package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoCliente")
public class TipoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_cliente_id", nullable = false)
    private Long tipoClienteID;

    @Column(name = "Tipo_do_cliente", nullable = false, length = 10)
    private String tipoDoCliente;
 
    @JsonManagedReference
    @OneToMany(mappedBy = "tipoCliente")
    private List<Cliente> Clientes;

    
}
