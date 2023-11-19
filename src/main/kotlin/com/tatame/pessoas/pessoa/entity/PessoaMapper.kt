package com.tatame.pessoas.pessoa.entity

import com.tatame.endereco.entity.EnderecoMapper

class PessoaMapper {

    fun EntityToForm(pessoa: Pessoa): PessoaForm {

        return PessoaForm(
            idPessoa = pessoa.id!!,
            nome = pessoa.nome,
            foto = pessoa.foto,
            endereco = EnderecoMapper().EntityToForm(pessoa.endereco!!),
            dddCelular = pessoa.dddCelular,
            dataNascimento = pessoa.dataNascimento,
            cpfCnpj = pessoa.cpfCnpj,
            celular = pessoa.celular)

    }


}