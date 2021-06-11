package com.udemy.projeto.spring.resources;

import com.udemy.projeto.spring.domain.Cliente;
import com.udemy.projeto.spring.dtos.ClienteDTO;
import com.udemy.projeto.spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/clientes")
public class ClienteEscritaResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody ClienteDTO objDto) {
        Cliente obj = service.transformarDTO(objDto);
        obj = service.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> alterar(@Valid @RequestBody ClienteDTO objDto,
                                        @PathVariable Integer id) {
        Cliente obj = service.transformarDTO(objDto);
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
