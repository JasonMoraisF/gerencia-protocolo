package br.com.gerenciaprotocolo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Protocolo")
public class Protocolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocolo_id")
    private Long protocoloID;
    
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @Column(name = "tipo_protocolo", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoProtocolo tipoProtocolo;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @JsonIgnore //Por enquanto
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore//POr enquanto
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "canal_id")
    private Canal canal;

    @JsonIgnore
    @Column(name = "data_Abertura", nullable = false)
    private Date dataAbertura;
    
    @JsonIgnore
    @Column(name = "data_Prazo", nullable = false)
    private Date dataPrazo;

    @JsonIgnore
    @Column(name = "data_UltimaAcao", nullable = false)
    private Date dataUltimaAcao;

    @JsonIgnore
    @Column(name = "data_Recebimento", nullable = false)
    private Date dataRecebimento;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = true)
    private Departamento departamento;
    
    @JsonIgnore
    @Column(name = "propensão_Bacen", nullable = false)
    private Boolean propensãoBacen;

    @JsonIgnore
    @Column(name = "agilizar", nullable = false)
    private Boolean agilizar;
    
    @JsonIgnore
    @Column(name = "devido", nullable = false)
    private Boolean devido;
    
    @JsonIgnore
    @Column(name = "procedente", nullable = false)
    private Boolean procedente;
    
    @JsonIgnore
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "situacaoProtocolo_id")
    private SituacaoProtocolo situacaoProtocolo;
    

    public Long getProtocoloID() {
        return protocoloID;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(Date dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public Date getDataUltimaAcao() {
        return dataUltimaAcao;
    }

    public void setDataUltimaAcao(Date dataUltimaAcao) {
        this.dataUltimaAcao = dataUltimaAcao;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProtocolo getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(TipoProtocolo tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Boolean getPropensãoBacen() {
        return propensãoBacen;
    }

    public void setPropensãoBacen(Boolean propensãoBacen) {
        this.propensãoBacen = propensãoBacen;
    }

    public Boolean getAgilizar() {
        return agilizar;
    }

    public void setAgilizar(Boolean agilizar) {
        this.agilizar = agilizar;
    }

    public Boolean getDevido() {
        return devido;
    }

    public void setDevido(Boolean devido) {
        this.devido = devido;
    }

    public Boolean getProcedente() {
        return procedente;
    }

    public void setProcedente(Boolean procedente) {
        this.procedente = procedente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SituacaoProtocolo getSituacaoProtocolo() {
        return situacaoProtocolo;
    }

    public void setSituacaoProtocolo(SituacaoProtocolo situacaoProtocolo) {
        this.situacaoProtocolo = situacaoProtocolo;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
