package com.udemy.projeto.spring.resources;

import com.udemy.projeto.spring.domain.Cliente;
import com.udemy.projeto.spring.dtos.ClienteDTO;
import com.udemy.projeto.spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/clientes")
public class ClienteLeituraResource {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarLista() {
        List<Cliente> lista = service.buscarLista();
        List<ClienteDTO> listaDTO = lista.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClienteDTO>> buscarListaPage(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value="direction", defaultValue = "ASC") String direction) {
        Page<Cliente> lista = service.buscarPagina(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listaDTO = lista.map(obj -> new ClienteDTO(obj));
        return ResponseEntity.ok().body(listaDTO);
    }
}
