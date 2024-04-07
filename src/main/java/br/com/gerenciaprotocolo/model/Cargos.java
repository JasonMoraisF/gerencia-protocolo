package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cargos")
public class Cargos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargosID")
    private Long cargosID;
  
    @Column(name = "TipoCargos", nullable = false, length = 30)
    private String TipoCargos;

    public Long getCargosID() {
        return cargosID;
    }

    public void setCargosID(Long cargosID) {
        this.cargosID = cargosID;
    }

    public String getTipoCargos() {
        return TipoCargos;
    }

    public void setTipoCargos(String tipoCargos) {
        TipoCargos = tipoCargos;
    }

    @Override
    public String toString() {
        return "Cargos [cargosID=" + cargosID + ", TipoCargos=" + TipoCargos + "]";
    }

}
