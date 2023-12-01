package com.tatame.regulamentoCategoria.entity


import com.tatame.regulamento.entity.RegulamentoCategoriaPK
import jakarta.persistence.EmbeddedId


data class RegulamentoCategoria(

    @EmbeddedId
    val regulamentoCategoriaPK: RegulamentoCategoriaPK

)
