package com.acjunior.apisistemapedidos.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String uf;
    private String localidade;

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.complemento = dados.complemento();
        this.uf = dados.uf();
        this.localidade = dados.localidade();
    }

    public void atualizarInformacoes(DadosEndereco dados) {

        if (dados.cep() != null) {
            this.cep = dados.cep();
        }

        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }

        if (dados.numero() != null) {
            this.numero = dados.numero();
        }

        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }

        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }

        if (dados.uf() != null) {
            this.uf = dados.uf();
        }

        if (dados.localidade() != null) {
            this.localidade = dados.localidade();
        }


    }




}
