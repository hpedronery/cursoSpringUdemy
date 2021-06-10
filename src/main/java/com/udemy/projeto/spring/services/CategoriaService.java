package com.udemy.projeto.spring.services;

import com.udemy.projeto.spring.domain.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria buscar(Integer id);

    Categoria criar(Categoria obj);

    Categoria alterar(Integer id, Categoria obj);

    void deletar(Integer id);

    List<Categoria> buscarLista();
}
