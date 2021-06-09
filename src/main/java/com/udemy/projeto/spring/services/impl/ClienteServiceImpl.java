package com.udemy.projeto.spring.services.impl;

import com.udemy.projeto.spring.domain.Cliente;
import com.udemy.projeto.spring.exceptions.ObjectNotFoundException;
import com.udemy.projeto.spring.repositories.ClienteRepository;
import com.udemy.projeto.spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
