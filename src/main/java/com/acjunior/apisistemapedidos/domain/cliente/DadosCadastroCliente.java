package com.acjunior.apisistemapedidos.domain.cliente;

import com.acjunior.apisistemapedidos.domain.endereco.DadosEndereco;

public record DadosCadastroCliente(
        String nome,
        String sobrenome,
        String telefone,
        DadosEndereco endereco
) {
}
