package br.com.jbfaneto.naturassp.dao;

import br.com.jbfaneto.naturassp.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {

}
