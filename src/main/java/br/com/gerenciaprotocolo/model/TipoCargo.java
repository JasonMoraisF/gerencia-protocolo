package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoCargo {
    OPERADOR_DE_ATENDIMENTO("operador"),
    GERENTE("gerente"),
    ANALISTA("analista");

    private String descricao;

    TipoCargo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    @JsonCreator
    public static TipoCargo fromDescricao(String descricao){
        for(TipoCargo tipo : TipoCargo.values()){
            if(tipo.getDescricao().equals(descricao)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo Cargo invalido: " + descricao);
    }

    @Override
    @JsonValue
    public String toString(){
        return descricao;
    }
}
