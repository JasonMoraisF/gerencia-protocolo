package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_funcionario_id")
    private Long codigoFuncionarioID;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @JsonIgnore
    @JsonManagedReference 
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cargos_id")
    private Cargos cargos;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "situacaoProtocolo_id")
    private SituacaoProtocolo situacaoProtocolo;

    public Long getCodigoFuncionarioID() {
        return codigoFuncionarioID;
    }

    public void setCodigoFuncionarioID(Long codigoFuncionarioID) {
        this.codigoFuncionarioID = codigoFuncionarioID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cargos getCargos() {
        return cargos;
    }

    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
    }

    public SituacaoProtocolo getSituacaoProtocolo() {
        return situacaoProtocolo;
    }

    public void setSituacaoProtocolo(SituacaoProtocolo situacaoProtocolo) {
        this.situacaoProtocolo = situacaoProtocolo;
    }

    

}
