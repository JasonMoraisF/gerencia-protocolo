package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoCliente")
public class TipoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipoClienteID", nullable = false)
    private Long tipoClienteID;

    @Column(name = "tipoDoCliente", nullable = false, length = 10)
    private String tipoDoCliente;

    public Long getTipoClienteID() {
        return tipoClienteID;
    }

    @Override
    public String toString() {
        return "TipoCliente [tipoClienteID=" + tipoClienteID + ", tipoDoCliente=" + tipoDoCliente + "]";
    }

    public void setTipoClienteID(Long tipoClienteID) {
        this.tipoClienteID = tipoClienteID;
    }

    public String getTipoDoCliente() {
        return tipoDoCliente;
    }

    public void setTipoDoCliente(String tipoDoCliente) {
        this.tipoDoCliente = tipoDoCliente;
    }
}
