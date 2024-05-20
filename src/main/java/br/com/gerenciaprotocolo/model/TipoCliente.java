package br.com.gerenciaprotocolo.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoCliente {
    FISICO("fisico"),
    JURIDICO("juridico");
    
    private String descricao;

    TipoCliente(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }

    @JsonCreator
    public static TipoCliente fromDescricao(String descricao){
        for(TipoCliente tipo : TipoCliente.values()){
            if(tipo.getDescricao().equals(descricao)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo do Cliente invalido: " + descricao);
    }

    @Override
    @JsonValue
    public String toString(){
        return descricao;
    }
}
