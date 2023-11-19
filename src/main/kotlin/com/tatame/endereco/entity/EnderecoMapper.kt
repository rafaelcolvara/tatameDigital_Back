package com.tatame.endereco.entity

class EnderecoMapper {

    fun EntityToForm(endereco: Endereco): EnderecoForm {
        return EnderecoForm(idCidade = endereco.cidade.id!!,
            numero = endereco.numero,
            cep = endereco.cep,
            complemento = endereco.complemento,
            rua = endereco.rua)
    }
}