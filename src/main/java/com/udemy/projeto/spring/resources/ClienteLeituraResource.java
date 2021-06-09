package com.udemy.projeto.spring.resources;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.domain.Cliente;
import com.udemy.projeto.spring.services.CategoriaService;
import com.udemy.projeto.spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientes")
public class ClienteLeituraResource {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
