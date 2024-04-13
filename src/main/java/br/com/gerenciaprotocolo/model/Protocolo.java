package br.com.gerenciaprotocolo.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Protocolo")
public class Protocolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocolo_id")
    private Long protocoloId;

    @Column(name = "nome_do_protocolo", nullable = false)
    private String nomeDoProtocolo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_abertura", nullable = false)
    private Date dataAbertura;

    @Column(name = "data_prazo", nullable = false)
    private Date dataPrazo;

    @Column(name = "data_alteracao", nullable = false)
    private Date dataAlteracao;

    @Column(name = "data_recebimento", nullable = false)
    private Date dataRecebimento;

    @Column(name = "tipo_protocolo", nullable = false)
    private String tipoProtocolo;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "resposta", nullable = false)
    private String resposta;

    @Column(name = "PropensãoBacen", nullable = false)
    private boolean PropensãoBacen;

    @Column(name = "Agilizar", nullable = false)
    private boolean Agilizar;

    @Column(name = "Devido", nullable = false)
    private boolean Devido;

    @Column(name = "Procedente", nullable = false)
    private boolean Procedente;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "canal_id")
    private Canal canal;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}
