package com.udemy.projeto.spring.services.impl;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.repositories.CategoriaRepository;
import com.udemy.projeto.spring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(long id) {
        Categoria obj = repository.findById(id)
                .orElse(null);
        return obj;
    }
}
