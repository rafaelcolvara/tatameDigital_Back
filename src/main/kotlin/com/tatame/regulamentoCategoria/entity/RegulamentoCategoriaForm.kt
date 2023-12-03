package com.tatame.regulamentoCategoria.entity

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import com.tatame.categoriaPeso.entity.CategoriaPesoEntity
import com.tatame.regulamento.entity.RegulamentoEntity
import jakarta.persistence.*

data class RegulamentoCategoriaForm(


    val id: Int,

    val regulamentoId: Int,

    val categoriaIdadeId: Int,

    val categoriaPesoId: Int

)
