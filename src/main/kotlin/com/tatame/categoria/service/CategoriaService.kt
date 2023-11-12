package com.tatame.categoria.service

import com.tatame.categoria.entity.Categoria
import com.tatame.categoria.entity.CategoriaForm
import com.tatame.categoria.repository.CategoriaRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoriaService (private val categoriaRepository: CategoriaRepository){

    @Transactional(readOnly = true)
    fun findAll(): List<Categoria> = categoriaRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Categoria? = categoriaRepository.findById(id).orElse(null)

    @Transactional
    fun save(categoria: CategoriaForm): Categoria = categoriaRepository.save(
        Categoria( nome = categoria.nome)
    )
    @Transactional
    fun deleteById(id: Int) = categoriaRepository.deleteById(id)

}