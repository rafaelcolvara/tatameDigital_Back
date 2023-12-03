package com.tatame.categoriaIdade.service

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import com.tatame.categoriaIdade.entity.CategoriaIdadeForm
import com.tatame.categoriaIdade.repository.CategoriaIdadeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoriaIdadeService(val categoriaIdadeRepository: CategoriaIdadeRepository) {

    fun findAll(): List<CategoriaIdadeEntity> = categoriaIdadeRepository.findAll()

    fun save(categoria: CategoriaIdadeForm): CategoriaIdadeEntity {
        return categoriaIdadeRepository.save(CategoriaIdadeEntity(
            id = categoria.idCategoria,
            idadeMaxima = categoria.idadeMaxima,
            idadeMinima = categoria.idadeMinima,
            nome = categoria.nome))
    }

    fun findById(idCategoriaIdade: Int): CategoriaIdadeEntity {
        return categoriaIdadeRepository.findById(idCategoriaIdade).orElseThrow { NoSuchElementException("Categoria não cadastrada ${idCategoriaIdade}") }
    }

    @Transactional
    fun deleteById(id: Int) = categoriaIdadeRepository.deleteById(id)

}