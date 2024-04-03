package br.com.gerenciaprotocolo.model;
import jakarta.persistence.*;


@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String departamentoResponsavel;
    private boolean propensaoBacen;
    private boolean agilizar;
    private String devido;
    private String procedente;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamentoResponsavel() {
        return this.departamentoResponsavel;
    }

    public void setDepartamentoResponsavel(String departamentoResponsavel) {
        this.departamentoResponsavel = departamentoResponsavel;
    }

    public boolean isPropensaoBacen() {
        return this.propensaoBacen;
    }

    public boolean getPropensaoBacen() {
        return this.propensaoBacen;
    }

    public void setPropensaoBacen(boolean propensaoBacen) {
        this.propensaoBacen = propensaoBacen;
    }

    public boolean isAgilizar() {
        return this.agilizar;
    }

    public boolean getAgilizar() {
        return this.agilizar;
    }

    public void setAgilizar(boolean agilizar) {
        this.agilizar = agilizar;
    }

    public String getDevido() {
        return this.devido;
    }

    public void setDevido(String devido) {
        this.devido = devido;
    }

    public String getProcedente() {
        return this.procedente;
    }

    public void setProcedente(String procedente) {
        this.procedente = procedente;
    }
    


}
