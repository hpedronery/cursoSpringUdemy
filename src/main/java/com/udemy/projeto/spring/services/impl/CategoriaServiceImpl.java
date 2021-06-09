package com.udemy.projeto.spring.services.impl;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.exceptions.ObjectNotFoundException;
import com.udemy.projeto.spring.repositories.CategoriaRepository;
import com.udemy.projeto.spring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
