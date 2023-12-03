package com.tatame.regulamentoCategoria.entity

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import com.tatame.categoriaPeso.entity.CategoriaPeso
import com.tatame.regulamento.entity.Regulamento
import jakarta.persistence.*

@Entity
@Table(
    name = "regulamento_categoria",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["regulamento_id", "categoria_idade_id", "categoria_peso_id"])
    ]
)
data class RegulamentoCategoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @ManyToOne
    @JoinColumn(name = "regulamento_id")
    val regulamento: Regulamento,

    @ManyToOne
    @JoinColumn(name = "categoria_idade_id")
    val categoriaIdadeEntity: CategoriaIdadeEntity,

    @ManyToOne
    @JoinColumn(name = "categoria_peso_id")
    val categoriaPeso: CategoriaPeso
)
