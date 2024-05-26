package br.com.gerenciaprotocolo.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Protocolo")
@EntityListeners(AuditingEntityListener.class)
public class Protocolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocolo_id")
    private Long protocoloID;
    
    @JsonIgnore
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente clienteId;

    @Column(name = "tipo_protocolo", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoProtocolo tipoProtocolo;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "agilizar")
    private Boolean agilizar;
    
    @Column(name = "data_Abertura", nullable = false)
    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataAbertura;
    
    @PrePersist
    protected void onCreate(){
        this.dataAbertura = LocalDateTime.now();
    }
    
    @Column(name = "data_Prazo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataPrazo;

    @JsonIgnore
    @Column(name = "data_UltimaAcao")
    private Date dataUltimaAcao;

    @JsonIgnore
    @Column(name = "data_Recebimento")
    private Date dataRecebimento;

    @JsonIgnore//POr enquanto
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "canal_id")
    private Canal canal;
    
    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = true)
    private Departamento departamento;
    
    @JsonIgnore
    @Column(name = "propensão_Bacen")
    private Boolean propensãoBacen;
    
    @JsonIgnore
    @Column(name = "devido")
    private Boolean devido;
    
    @JsonIgnore
    @Column(name = "procedente")
    private Boolean procedente;
    
    @JsonIgnore
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "situacaoProtocolo_id")
    private SituacaoProtocolo situacaoProtocolo;

    public void calcularDataPrazo(Protocolo protocolo){
        switch(protocolo.getTipoProtocolo()){
            case RECLAMACAO:
                protocolo.setDataPrazo(protocolo.getDataAbertura().plusDays(5));
                break;
            case ELOGIO:
                protocolo.setDataPrazo(protocolo.getDataAbertura().plusDays(10)); 
                break;
            case INFORMACAO:
                protocolo.setDataPrazo(protocolo.getDataAbertura().plusDays(7)); 
                break;
            case SOLICITACAO:
                protocolo.setDataPrazo(protocolo.getDataAbertura().plusDays(7)); 
                break;
            case CONSULTA:
                protocolo.setDataPrazo(protocolo.getDataAbertura().plusDays(7)); 
                break;
            case DENUNCIA:
                protocolo.setDataPrazo(protocolo.getDataAbertura().plusDays(3)); 
                break;
            case CANCELAMENTO:
                protocolo.setDataPrazo(protocolo.getDataAbertura().plusDays(2)); 
                break;
        }
    }

    
    public Long getProtocoloID() {
        return protocoloID;
    }
    
    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }
    
    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    
    public LocalDateTime getDataPrazo() {
        return dataPrazo;
    }
    
    public void setDataPrazo(LocalDateTime dataPrazo) {
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

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente cliente) {
        this.clienteId = cliente;
    }

    
}
