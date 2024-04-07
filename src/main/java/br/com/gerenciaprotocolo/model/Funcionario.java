package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoFuncionarioID")
    private Long codigoFuncionarioID;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "departamentoID")
    private Long departamentoID;

    @Column(name = "cargosID")
    private Long cargosID;

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

    public Long getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(Long departamentoID) {
        this.departamentoID = departamentoID;
    }

    public Long getCargosID() {
        return cargosID;
    }

    public void setCargosID(Long cargosID) {
        this.cargosID = cargosID;
    }

    @Override
    public String toString() {
        return "Funcionario [codigoFuncionarioID=" + codigoFuncionarioID + ", nome=" + nome + ", email=" + email
                + ", departamentoID=" + departamentoID + ", cargosID=" + cargosID + "]";
    }

}
