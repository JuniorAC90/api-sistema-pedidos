package com.acjunior.apisistemapedidos.domain.endereco;

public record DadosEndereco(
      String bairro,
      String cep,
      String complemento,
      String localidade,
      String logradouro,
      String numero,
      String uf
) {
}
