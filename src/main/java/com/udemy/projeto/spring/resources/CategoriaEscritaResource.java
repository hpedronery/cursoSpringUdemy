package com.udemy.projeto.spring.resources;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaEscritaResource {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody Categoria obj) {
        obj = service.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> alterar(@RequestBody Categoria obj,
                                        @PathVariable Integer id) {
        service.alterar(id, obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
