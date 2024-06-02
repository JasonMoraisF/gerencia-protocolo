package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoTelefone {
    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    CELULAR("Celular");

    private String descricao;

    TipoTelefone(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }


    @JsonCreator
    public static TipoTelefone fromDescricao(String descricao){
        for (TipoTelefone tipo : TipoTelefone.values()){
            if(tipo.getDescricao().equals(descricao)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de telefone invalido: " + descricao);
    }

    @Override
    @JsonValue
    public String toString(){
        return descricao;
    }

}
