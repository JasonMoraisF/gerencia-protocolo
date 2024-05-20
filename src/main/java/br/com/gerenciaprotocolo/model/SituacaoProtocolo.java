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

    @JsonManagedReference
    @OneToMany(mappedBy = "situacaoProtocolo")
    private List<Funcionario> funcionarios;

    @JsonManagedReference
    @OneToMany(mappedBy = "situacaoProtocolo")
    private Protocolo protocolo;

}
