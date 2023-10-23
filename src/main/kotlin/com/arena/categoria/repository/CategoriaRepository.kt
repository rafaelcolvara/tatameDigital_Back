package com.arena.categoria.repository

import com.arena.categoria.entity.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository: JpaRepository<Categoria, Int> {
}