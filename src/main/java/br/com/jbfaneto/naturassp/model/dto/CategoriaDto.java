package br.com.jbfaneto.naturassp.model.dto;

import br.com.jbfaneto.naturassp.model.Categoria;

public record CategoriaDto(Integer id, String nome) {
    public  Categoria fromDto(CategoriaDto dto){
        return new Categoria(id, nome);
    }
    public  CategoriaDto fromEntity() {
        return new CategoriaDto(id, nome);
    }
}
