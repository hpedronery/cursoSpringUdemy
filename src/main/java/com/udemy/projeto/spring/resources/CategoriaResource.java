package com.udemy.projeto.spring.resources;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
