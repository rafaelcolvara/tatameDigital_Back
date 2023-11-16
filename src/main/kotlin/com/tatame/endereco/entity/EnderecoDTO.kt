package com.tatame.endereco.entity

data class EnderecoDTO(
    var rua: String,
    var complemento: String? = null,
    var numero: Int? = null,
    var cep: String? = null,
    var cidade: Int?= null,
    var nomeCidade: String? = null
)
