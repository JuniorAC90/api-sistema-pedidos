package com.acjunior.apisistemapedidos.controller;

import com.acjunior.apisistemapedidos.domain.cliente.Cliente;
import com.acjunior.apisistemapedidos.domain.cliente.ClienteRepository;
import com.acjunior.apisistemapedidos.domain.cliente.DadosCadastroCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
}
