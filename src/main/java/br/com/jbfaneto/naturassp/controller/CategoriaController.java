package br.com.jbfaneto.naturassp.controller;

import br.com.jbfaneto.naturassp.model.dto.CategoriaDto;
import br.com.jbfaneto.naturassp.service.impl.CategoriaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
    private final CategoriaServiceImpl service;
    public CategoriaController(CategoriaServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listarCategorias() {
        List<CategoriaDto> response = service.recuperarTodasCategorias().stream().map(c ->
                new CategoriaDto(c.getId(), c.getNome())).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoriaDto>> listarCategoriasPorPalavraChave(@RequestParam("key") String palavraChave) {
        List<CategoriaDto> response = service.recuperarPorPalavraChave(palavraChave).stream().map(c ->
                new CategoriaDto(c.getId(), c.getNome())).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> inserirNovaCategoria(@RequestBody CategoriaDto dto) {
            service.inserirNovaCategoria(dto.fromDto(dto));
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.id()).toUri();
            return ResponseEntity.created(uri).build();
        }
}
