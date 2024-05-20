package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoProtocolo {
    RECLAMACAO("reclamacao"),
    ELOGIO("elogio"),
    INFORMACAO("informacao"),
    SOLICITACAO("solicitacao"),
    CONSULTA("consulta"),
    DENUNCIA("denuncia"),
    CANCELAMENTO("cancelamento");

    private String descricao;

    TipoProtocolo(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    @JsonCreator
    public static TipoProtocolo fromDescricao(String descricao){
        for(TipoProtocolo tipo : TipoProtocolo.values()){
            if(tipo.getDescricao().equals(descricao)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo Invalido: " + descricao);
    }


    @Override
    @JsonValue
    public String toString(){
        return descricao;
    }


}
