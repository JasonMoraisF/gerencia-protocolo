package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "SituacaoProtocolo")
public class SituacaoProtocolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "situacaoProtocolo_id")
    private Long situacaoProtocoloID;
    
    @Column(name = "resposta", nullable = false, length = 500)
    private String resposta;

    @Column(name = "status", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private StatusProtocolo status;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "situacaoProtocolo")
    private List<Funcionario> funcionarios;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "protocolo_id", nullable = true)
    private Protocolo protocolo;


    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public StatusProtocolo getStatus() {
        return status;
    }

    public void setStatus(StatusProtocolo status) {
        this.status = status;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Protocolo getProtocolos() {
        return protocolo;
    }

    public void setProtocolos(Protocolo protocolos) {
        this.protocolo = protocolos;
    }

    public Long getSituacaoProtocoloID() {
        return situacaoProtocoloID;
    }

}
