package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Canal")
public class Canal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "canal_id")
    private Long canalID;
  
    @Column(name = "tipo_canal", nullable = false, length = 50)
    private String TipoCanal;

    @JsonManagedReference
    @OneToMany(mappedBy = "canal")
    private List<Protocolo> protocolos;
    
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

    public List<Protocolo> getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(List<Protocolo> protocolos) {
        this.protocolos = protocolos;
    }

    

}
