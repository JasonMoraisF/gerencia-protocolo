package br.com.gerenciaprotocolo.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Protocolo")
public class Protocolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocoloID")
    private Long protocoloID;

    @Column(name = "dataAbertura", nullable = false)
    private Date dataAbertura;

    @Column(name = "dataPrazo", nullable = false)
    private Date dataPrazo;

    @Column(name = "dataUltimaAcao", nullable = false)
    private Date dataUltimaAcao;

    @Column(name = "dataRecebimento", nullable = false)
    private Date dataRecebimento;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "tipoProtocolo", nullable = false, length = 50)
    private String tipoProtocolo;

    @Column(name = "propensãoBacen", nullable = false)
    private Boolean propensãoBacen;

    @Column(name = "agilizar", nullable = false)
    private Boolean agilizar;

    @Column(name = "devido", nullable = false)
    private Boolean devido;

    @Column(name = "procedente", nullable = false)
    private Boolean procedente;

    @Lob
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "clienteID")
    private Long clienteID;

    @Column(name = "canalID")
    private Long canalID;

    @Column(name = "departamentoID")
    private Long departamentoID;

    @Column(name = "situacaoProtocoloID")
    private Long situacaoProtocoloID;

    public Long getProtocoloID() {
        return protocoloID;
    }

    public void setProtocoloID(Long protocoloID) {
        this.protocoloID = protocoloID;
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

    public String getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(String tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
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

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public Long getCanalID() {
        return canalID;
    }

    public void setCanalID(Long canalID) {
        this.canalID = canalID;
    }

    public Long getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(Long departamentoID) {
        this.departamentoID = departamentoID;
    }

    public Long getSituacaoProtocoloID() {
        return situacaoProtocoloID;
    }

    public void setSituacaoProtocoloID(Long situacaoProtocoloID) {
        this.situacaoProtocoloID = situacaoProtocoloID;
    }

    @Override
    public String toString() {
        return "Protocolo [protocoloID=" + protocoloID + ", dataAbertura=" + dataAbertura + ", dataPrazo=" + dataPrazo
                + ", dataUltimaAcao=" + dataUltimaAcao + ", dataRecebimento=" + dataRecebimento + ", nome=" + nome
                + ", tipoProtocolo=" + tipoProtocolo + ", propensãoBacen=" + propensãoBacen + ", agilizar=" + agilizar
                + ", devido=" + devido + ", procedente=" + procedente + ", descricao=" + descricao + ", clienteID="
                + clienteID + ", canalID=" + canalID + ", departamentoID=" + departamentoID + ", situacaoProtocoloID="
                + situacaoProtocoloID + "]";
    }

    
}
