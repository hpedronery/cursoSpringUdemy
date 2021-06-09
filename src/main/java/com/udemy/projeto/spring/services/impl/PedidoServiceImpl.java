package com.udemy.projeto.spring.services.impl;

import com.udemy.projeto.spring.domain.Pedido;
import com.udemy.projeto.spring.exceptions.ObjectNotFoundException;
import com.udemy.projeto.spring.repositories.PedidoRepository;
import com.udemy.projeto.spring.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
