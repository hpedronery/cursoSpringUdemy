package com.udemy.projeto.spring.services;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.dtos.CategoriaDTO;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.List;

public interface CategoriaService {

    Categoria buscar(Integer id);

    Categoria criar(@Valid Categoria obj);

    Categoria alterar(Integer id, Categoria obj);

    void deletar(Integer id);

    List<Categoria> buscarLista();

    Page<Categoria> buscarPagina(Integer page, Integer linesPerPage, String orderBy, String direction);

    Categoria transformarDTO (CategoriaDTO objDto);
}
