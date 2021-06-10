package com.udemy.projeto.spring.services.impl;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.exceptions.DataIntegrityException;
import com.udemy.projeto.spring.exceptions.ObjectNotFoundException;
import com.udemy.projeto.spring.repositories.CategoriaRepository;
import com.udemy.projeto.spring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    @Override
    public Categoria criar(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    @Override
    public Categoria alterar(Integer id, Categoria novoObj) {
        Categoria obj = buscar(id);
        obj.setNome(novoObj.getNome());
        return repository.save(obj);
    }

    @Override
    public void deletar(Integer id) {
        buscar(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos vinculados.");
        }
    }

    @Override
    public List<Categoria> buscarLista() {
        return repository.findAll();
    }
}
