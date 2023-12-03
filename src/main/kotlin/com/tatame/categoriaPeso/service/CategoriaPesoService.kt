package com.tatame.categoriaPeso.service

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import com.tatame.categoriaPeso.entity.CategoriaPesoEntity
import com.tatame.categoriaPeso.entity.CategoriaPesoForm
import com.tatame.categoriaPeso.repository.CategoriaPesoRespository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CategoriaPesoService(
    val categoriaPesoRepository: CategoriaPesoRespository
) {

    fun findAll(): List<CategoriaPesoEntity> = categoriaPesoRepository.findAll()

    fun save(categoria: CategoriaPesoForm): CategoriaPesoEntity {
        return categoriaPesoRepository.save(
            CategoriaPesoEntity(
            id = categoria.id,
            pesoMaximo = categoria.pesoMaximo,
            pesoMinimo = categoria.pesoMinimo,
            nome = categoria.nome)
        )
    }

    fun findById(idCategoria: Int): CategoriaPesoEntity {
        return categoriaPesoRepository.findById(idCategoria).orElseThrow { NoSuchElementException("Categoria não cadastrada ${idCategoria}") }
    }

    @Transactional
    fun deleteById(id: Int) = categoriaPesoRepository.deleteById(id)

}