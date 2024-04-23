package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Canal")
public class Canal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "canal_id")
    private Long canalID;
  
    @Column(name = "tipo_canal", nullable = false, length = 30)
    private String TipoCanal;

    @JsonManagedReference
    @OneToMany(mappedBy = "canal")
    private List<Protocolo> protocolos;

    

}
