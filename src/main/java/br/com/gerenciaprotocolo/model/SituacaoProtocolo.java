package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SituacaoProtocolo")
public class SituacaoProtocolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "situacaoProtocoloID")
    private Long situacaoProtocoloID;

    @Column(name = "tipoProtocolo", nullable = false, length = 30)
    private String tipoProtocolo;

    @Column(name = "resposta", nullable = false, length = 50)
    private String resposta;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "codigoFuncionarioID")
    private Long codigoFuncionarioID;

    public Long getSituacaoProtocoloID() {
        return situacaoProtocoloID;
    }

    public void setSituacaoProtocoloID(Long situacaoProtocoloID) {
        this.situacaoProtocoloID = situacaoProtocoloID;
    }

    public String getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(String tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCodigoFuncionarioID() {
        return codigoFuncionarioID;
    }

    public void setCodigoFuncionarioID(Long codigoFuncionarioID) {
        this.codigoFuncionarioID = codigoFuncionarioID;
    }

    @Override
    public String toString() {
        return "SituacaoProtocolo [situacaoProtocoloID=" + situacaoProtocoloID + ", tipoProtocolo=" + tipoProtocolo
                + ", resposta=" + resposta + ", status=" + status + ", codigoFuncionarioID=" + codigoFuncionarioID
                + "]";
    }
}
