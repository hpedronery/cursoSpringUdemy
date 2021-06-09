package com.udemy.projeto.spring.resources;

import com.udemy.projeto.spring.domain.Pedido;
import com.udemy.projeto.spring.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoLeituraResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {
        Pedido obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
