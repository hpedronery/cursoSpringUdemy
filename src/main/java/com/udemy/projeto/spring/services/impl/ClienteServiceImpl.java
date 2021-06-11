package com.udemy.projeto.spring.services.impl;

import com.udemy.projeto.spring.domain.Cliente;
import com.udemy.projeto.spring.domain.Cliente;
import com.udemy.projeto.spring.dtos.ClienteDTO;
import com.udemy.projeto.spring.exceptions.DataIntegrityException;
import com.udemy.projeto.spring.exceptions.ObjectNotFoundException;
import com.udemy.projeto.spring.repositories.ClienteRepository;
import com.udemy.projeto.spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
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

    public Page<Cliente> buscarPagina(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    @Override
    public Cliente criar(Cliente obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    @Override
    public Cliente alterar(Integer id, Cliente novoObj) {
        Cliente obj = buscar(id);
        System.out.println(obj.getNome());
        obj.setNome(novoObj.getNome());
        return repository.save(obj);
    }

    @Override
    public void deletar(Integer id) {
        buscar(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma Cliente que possui produtos vinculados.");
        }
    }

    @Override
    public List<Cliente> buscarLista() {
        return repository.findAll();
    }

    @Override
    public Cliente transformarDTO (ClienteDTO objDto){
        return new Cliente(objDto.getNome(), objDto.getEmail());
    }
}
