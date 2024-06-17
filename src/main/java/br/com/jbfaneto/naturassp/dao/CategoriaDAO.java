package br.com.jbfaneto.naturassp.dao;

import br.com.jbfaneto.naturassp.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {

    public List<Categoria> findByNomeContaining(String palavra);
}
