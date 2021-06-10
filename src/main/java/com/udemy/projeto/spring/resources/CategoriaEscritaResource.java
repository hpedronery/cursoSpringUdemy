package com.udemy.projeto.spring.resources;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.dtos.CategoriaDTO;
import com.udemy.projeto.spring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaEscritaResource {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody CategoriaDTO objDto) {
        Categoria obj = service.transformarDTO(objDto);
        obj = service.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> alterar(@Valid @RequestBody CategoriaDTO objDto,
                                        @PathVariable Integer id) {
        Categoria obj = service.transformarDTO(objDto);
        obj.setId(id);
        service.alterar(id, obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
