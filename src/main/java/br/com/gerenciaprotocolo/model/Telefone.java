package br.com.gerenciaprotocolo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Telefone")
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telefoneID")
    private Long telefoneID;

    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @Column(name = "ddd", nullable = false, length = 2)
    private String ddd;

    public Long getTelefoneID() {
        return telefoneID;
    }

    public void setTelefoneID(Long telefoneID) {
        this.telefoneID = telefoneID;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "Telefone [telefoneID=" + telefoneID + ", numero=" + numero + ", ddd=" + ddd + "]";
    }

}
