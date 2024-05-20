package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum StatusProtocolo {
    REDIRECIONADO("redirecionado"),
    ANALISE("analise"),
    RESPONDIDO("respondido"),
    NOVO("novo"),
    DEVOLVIDO("devolvido");

    private String descricao;

    StatusProtocolo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    @JsonCreator
    public static StatusProtocolo fromDescricao(String descricao){
        for(StatusProtocolo status : StatusProtocolo.values()){
            if(status.getDescricao().equals(descricao)){
                return status;
            }
        }
        throw new IllegalArgumentException("Status Invalido: " + descricao);
    }

    @Override
    @JsonValue
    public String toString(){
        return descricao;
    }


}
