package br.com.gerenciaprotocolo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Cargos")
public class Cargos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargos_id")
    private Long cargosID;
  
    @Column(name = "tipo_cargos", nullable = false, length = 30)
    private String TipoCargos;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "cargos")
    private List<Funcionario> funcionarios;

}
