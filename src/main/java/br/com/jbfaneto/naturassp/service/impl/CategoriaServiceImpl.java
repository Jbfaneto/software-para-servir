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
        try{
            if (categoria.getNome() != null && !categoria.getNome().isEmpty()){
                return dao.save(categoria);
            }
        } catch (IllegalArgumentException  e) {
            System.out.println("Erro ao inserir nova categoria: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao inserir nova categoria: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Categoria alterarCategoria(Categoria categoria) {
        try{
            if(categoria.getId() != null && categoria.getNome() != null && !categoria.getNome().isEmpty()) {
                Categoria categoriaDB = dao.findById(categoria.getId()).orElse(null);
                if (categoriaDB != null) {
                    categoriaDB.setNome(categoria.getNome());
                    return dao.save(categoriaDB);
                }
            }
        } catch(Exception e) {
        System.out.println("Erro ao alterar categoria: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void excluirCategoria(int id) {
        try {
            dao.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir categoria: " + e.getMessage());
        }

    }

    @Override
    public List<Categoria> recuperarTodasCategorias() {
        return dao.findAll();
    }

    @Override
    public List<Categoria> recuperarPorPalavraChave(String palavraChave) {
        return null;
    }
}
