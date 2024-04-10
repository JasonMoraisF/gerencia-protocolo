package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Canal")
public class Canal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "canalID")
    private Long canalID;
  
    @Column(name = "TipoCanal", nullable = false, length = 30)
    private String TipoCanal;

    public Long getCanalID() {
        return canalID;
    }

    public void setCanalID(Long canalID) {
        this.canalID = canalID;
    }

    public String getTipoCanal() {
        return TipoCanal;
    }

    public void setTipoCanal(String tipoCanal) {
        TipoCanal = tipoCanal;
    }

    @Override
    public String toString() {
        return "Canal [canalID=" + canalID + ", TipoCanal=" + TipoCanal + "]";
    }
}
