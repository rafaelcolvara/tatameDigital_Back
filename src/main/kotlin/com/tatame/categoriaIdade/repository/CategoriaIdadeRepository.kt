package com.tatame.categoriaIdade.repository

import com.tatame.categoriaIdade.entity.CategoriaIdade
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaIdadeRepository: JpaRepository<CategoriaIdade, Int> {
}