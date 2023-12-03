package com.tatame.categoriaIdade.repository

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaIdadeRepository: JpaRepository<CategoriaIdadeEntity, Int> {
}