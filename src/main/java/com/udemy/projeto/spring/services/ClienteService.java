package com.udemy.projeto.spring.services;

import com.udemy.projeto.spring.domain.Cliente;
import com.udemy.projeto.spring.dtos.ClienteDTO;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.List;

public interface ClienteService {

    Cliente buscar(Integer id);

    List<Cliente> buscarLista();

    Page<Cliente> buscarPagina(Integer page, Integer linesPerPage, String orderBy, String direction);

    Cliente transformarDTO(ClienteDTO objDto);

    Cliente criar(@Valid Cliente obj);

    Cliente alterar(Integer id, Cliente obj);

    void deletar(Integer id);
}
