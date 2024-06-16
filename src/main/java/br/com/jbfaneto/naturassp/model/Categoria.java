package br.com.jbfaneto.naturassp.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tbl_categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;
    @Column(name = "nome_categoria", length = 100, nullable = false, unique = true)
    private String nome;

    public Categoria() {
    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String npme) {
        this.nome = nome;
    }
}
