package br.com.gerenciaprotocolo.model;

//import com.fasterxml.jackson.annotation.JsonBackReference; (não ta sendo usado)
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.util.Random;
//import java.util.UUID; (não ta sendo usado)

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @Column(name = "codigo_funcionario_id", unique = true, updatable = false)
    private String codigoFuncionarioID;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "departamento_id")
    private Departamento departamento;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cargos_id", referencedColumnName = "cargos_id")
    private Cargos cargos;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "situacaoProtocolo_id", referencedColumnName = "situacaoProtocolo_id")
    private SituacaoProtocolo situacaoProtocolo;

    // Construtor para gerar o ID formatado
    public Funcionario() {
        this.codigoFuncionarioID = generateFormattedId();
    }

     // Método para gerar o ID formatado
     private String generateFormattedId() {
        Random random = new Random();
        int numeroAleatorio;
        do {
            numeroAleatorio = random.nextInt(900000) + 1; // Gera um número aleatório entre 1 e 899999
        } while (numeroAleatorio < 100000 || numeroAleatorio >= 900000); // Garante que o primeiro dígito não seja zero
        return "i" + String.format("%06d", numeroAleatorio);
    }
    

    // Getters e Setters

    public String getCodigoFuncionarioID() {
        return codigoFuncionarioID;
    }

    public void setCodigoFuncionarioID(String codigoFuncionarioID) {
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
