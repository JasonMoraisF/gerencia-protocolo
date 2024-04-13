package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Canal")
public class Canal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "canal_id")
    private Long canalId;

    @Column(name = "nome", nullable = false)
    private String nome;

}
