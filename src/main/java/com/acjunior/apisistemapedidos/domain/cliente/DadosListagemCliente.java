package com.acjunior.apisistemapedidos.domain.cliente;

public record DadosListagemCliente(
        String nome,
        String sobrenome
) {
    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getNome(), cliente.getSobrenome());
    }
}
