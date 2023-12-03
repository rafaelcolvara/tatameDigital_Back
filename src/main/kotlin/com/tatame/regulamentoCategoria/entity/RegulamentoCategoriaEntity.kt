package com.tatame.regulamentoCategoria.entity

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import com.tatame.categoriaPeso.entity.CategoriaPesoEntity
import com.tatame.regulamento.entity.RegulamentoEntity
import jakarta.persistence.*

@Entity
@Table(
    name = "regulamento_categoria",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["regulamento_id", "categoria_idade_id", "categoria_peso_id"])
    ]
)
data class RegulamentoCategoriaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @ManyToOne
    @JoinColumn(name = "regulamento_id")
    val regulamentoEntity: RegulamentoEntity,

    @ManyToOne
    @JoinColumn(name = "categoria_idade_id")
    val categoriaIdadeEntity: CategoriaIdadeEntity,

    @ManyToOne
    @JoinColumn(name = "categoria_peso_id")
    val categoriaPesoEntity: CategoriaPesoEntity
)
