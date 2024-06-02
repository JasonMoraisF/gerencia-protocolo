package br.com.gerenciaprotocolo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Departamentos {
    DPB("dpb"),
    DEF("def"),
    DC("dc"),
    AGENCIA("agencia"),
    TI("ti");

    private String descricao;

    Departamentos(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    @JsonCreator
    public static Departamentos fromDescricao(String descricao){
        for(Departamentos departamento : Departamentos.values()){
            if(departamento.getDescricao().equals(descricao)){
                return departamento;
            }
        }
        throw new IllegalArgumentException("Departamento inexistente: " + descricao);
    }
    @Override
    @JsonValue
    public String toString(){
        return descricao;
    }

}
