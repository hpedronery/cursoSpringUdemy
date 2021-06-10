package com.udemy.projeto.spring.services;

import com.udemy.projeto.spring.domain.Categoria;

public interface CategoriaService {

    Categoria buscar(Integer id);

    Categoria criar(Categoria obj);

    Categoria alterar(Integer id, Categoria obj);

    void deletar(Integer id);
}
