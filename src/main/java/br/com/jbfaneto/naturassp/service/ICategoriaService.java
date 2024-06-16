package br.com.jbfaneto.naturassp.service;

import br.com.jbfaneto.naturassp.model.Categoria;

import java.util.List;

public interface ICategoriaService {
    public Categoria inserirNovaCategoria(Categoria categoria);

    public Categoria alterarCategoria(Categoria categoria);

    public void excluirCategoria(int id);

    public List<Categoria> recuperarTodasCategorias();

    public List<Categoria> recuperarPorPalavraChave(String palavraChave);
}
