package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonBackReference; (não ta sendo usado)
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco_de_dados", unique = true, updatable = false)
    private long codigoFuncionarioID;
    
    
    @Column(name = "codigo_funcionario_id_personalizado", unique = true, updatable = false)
    private String codigoFuncionarioIDPersonalizado; 

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @Column(name = "departamento_id", nullable = false)
    @Enumerated
    private Departamentos departamentos;
    
    @Column(name = "cargo", nullable = false)
    @Enumerated
    private TipoCargo cargo;
    
    @OneToOne(mappedBy = "funcionario")
    @JsonBackReference
    @JoinColumn(name = "situacaoProtocolo_id")
    private SituacaoProtocolo situacaoProtocolo;
     // Construtor para gerar o ID formatado
     public Funcionario() {
        this.codigoFuncionarioIDPersonalizado = generateFormattedId(); // Gera o ID personalizado
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

    public long getCodigoFuncionarioID() {
        return codigoFuncionarioID;
    }
    public Funcionario(long codigoFuncionarioID) {
        this.codigoFuncionarioID = codigoFuncionarioID;
    }


    public String getcodigoFuncionarioIDPersonalizado(){
        return codigoFuncionarioIDPersonalizado;
    }
    public void setCodigoFuncionarioID(long codigoFuncionarioID) {
        this.codigoFuncionarioID = codigoFuncionarioID;
    }
    public void setcodigoFuncionarioIDPersonalizado(String codigoFuncionarioIDPersonalizado) {
        this.codigoFuncionarioIDPersonalizado = codigoFuncionarioIDPersonalizado;
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

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamento) {
        this.departamentos = departamento;
    }

    public TipoCargo getCargo() {
        return cargo;
    }

    public void setCargo(TipoCargo cargo) {
        this.cargo = cargo;
    }

    public SituacaoProtocolo getSituacaoProtocolo() {
        return situacaoProtocolo;
    }

    public void setSituacaoProtocolo(SituacaoProtocolo situacaoProtocolo) {
        this.situacaoProtocolo = situacaoProtocolo;
    }
}