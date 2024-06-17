package br.com.jbfaneto.naturassp.service.impl;

import br.com.jbfaneto.naturassp.dao.CategoriaDAO;
import br.com.jbfaneto.naturassp.model.Categoria;
import br.com.jbfaneto.naturassp.service.ICategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    private final CategoriaDAO dao;

    public CategoriaServiceImpl(CategoriaDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public Categoria inserirNovaCategoria(Categoria categoria) {
        if (categoria.getNome() != null && !categoria.getNome().isEmpty()) {
            return dao.save(categoria);
        }
        throw new IllegalArgumentException("Nome da categoria não pode ser nulo");
    }

    @Override
    @Transactional
    public Categoria alterarCategoria(Categoria categoria) {
        if(categoria.getId() != null && categoria.getNome() != null && !categoria.getNome().isEmpty()) {
            Categoria categoriaDB = dao.findById(categoria.getId()).orElse(null);
            if (categoriaDB != null) {
                categoriaDB.setNome(categoria.getNome());
                return dao.save(categoriaDB);
            }

        }
        throw new IllegalArgumentException("Categoria não encontrada");
    }

    @Override
    @Transactional
    public void excluirCategoria(int id) {
        try {
            dao.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir categoria: " + e.getMessage());
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> recuperarTodasCategorias() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> recuperarPorPalavraChave(String palavraChave) {
        if (palavraChave != null && !palavraChave.isEmpty()){
            return dao.findByNomeContaining(palavraChave);
        } else {
            throw new IllegalArgumentException("Palavra chave não pode ser nula");
        }
    }
}
