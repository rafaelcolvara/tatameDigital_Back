package com.tatame.endereco.entity

data class EnderecoForm(
    var rua: String,
    var complemento: String? = null,
    var numero: Int? = null,
    var cep: String? = null,
    var cidade: CidadeForm,
)
