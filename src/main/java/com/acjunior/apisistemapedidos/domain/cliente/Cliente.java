package com.acjunior.apisistemapedidos.domain.cliente;

import com.acjunior.apisistemapedidos.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="cliente")
@Entity(name="Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Cliente (DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.sobrenome() != null) {
            this.sobrenome = dados.sobrenome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }
}
