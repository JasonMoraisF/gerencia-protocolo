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

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "cargos")
    private List<Funcionario> funcionarios;

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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    
}
