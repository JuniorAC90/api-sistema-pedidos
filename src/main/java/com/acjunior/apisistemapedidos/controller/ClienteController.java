package com.acjunior.apisistemapedidos.controller;

import com.acjunior.apisistemapedidos.domain.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados) {
        var cliente = new Cliente(dados);
        repository.save(cliente);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados) {

        var cliente = repository.getReferenceById(dados.id());
        //System.out.println(dados);
        cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        repository.delete(cliente);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemCliente>> listar() {
        List<DadosListagemCliente> listaDeClientes = repository.findAll().stream().map(DadosListagemCliente::new).toList();
        return ResponseEntity.ok().body(listaDeClientes);
    }
}
