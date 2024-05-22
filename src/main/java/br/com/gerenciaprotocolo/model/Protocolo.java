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

    @Column(name = "data_Abertura", nullable = false)
    private Date dataAbertura;

    @Column(name = "data_Prazo", nullable = false)
    private Date dataPrazo;

    @Column(name = "data_UltimaAcao", nullable = false)
    private Date dataUltimaAcao;

    @Column(name = "data_Recebimento", nullable = false)
    private Date dataRecebimento;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "tipo_protocolo", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoProtocolo tipoProtocolo;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = true)
    private Departamento departamento;

    @Column(name = "propensão_Bacen", nullable = false)
    private Boolean propensãoBacen;

    @Column(name = "agilizar", nullable = false)
    private Boolean agilizar;

    @Column(name = "devido", nullable = false)
    private Boolean devido;

    @Column(name = "procedente", nullable = false)
    private Boolean procedente;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "situacaoProtocolo_id")
    private SituacaoProtocolo situacaoProtocolo;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "canal_id")
    private Canal canal;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
}
