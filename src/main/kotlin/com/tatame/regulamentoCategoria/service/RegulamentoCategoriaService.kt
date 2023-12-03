package com.tatame.regulamentoCategoria.service

import com.tatame.categoriaIdade.repository.CategoriaIdadeRepository
import com.tatame.categoriaPeso.repository.CategoriaPesoRespository
import com.tatame.regulamento.repository.RegulamentoRepository
import com.tatame.regulamentoCategoria.entity.RegulamentoCategoriaEntity
import com.tatame.regulamentoCategoria.entity.RegulamentoCategoriaForm


import com.tatame.regulamentoCategoria.repository.RegulamentoCategoriaRepository
import org.springframework.transaction.annotation.Transactional

class RegulamentoCategoriaService(val repository: RegulamentoCategoriaRepository,
    val regulamentoRepository: RegulamentoRepository,
    val categoriaPesoRespository: CategoriaPesoRespository,
    val categoriaIdadeRepository: CategoriaIdadeRepository
) {

    fun findAll(): List<RegulamentoCategoriaEntity> = repository.findAll()

    fun save(regulamento: RegulamentoCategoriaForm): RegulamentoCategoriaEntity {

        try {

            val regulamentoEntity = regulamentoRepository.findById(regulamento.regulamentoId).orElseThrow{NoSuchElementException("Regulamento não encontrado")}
            val categoriaPeso = categoriaPesoRespository.findById(regulamento.categoriaPesoId).orElseThrow{NoSuchElementException("Categoria não encontrado")}
            val categoriaIdade =  categoriaIdadeRepository.findById(regulamento.categoriaIdadeId).orElseThrow{NoSuchElementException("Categoria não encontrado")}

            return repository.save(
                RegulamentoCategoriaEntity(
                    id = regulamento.id,
                    regulamentoEntity = regulamentoEntity,
                    categoriaIdadeEntity =  categoriaIdade,
                    categoriaPesoEntity = categoriaPeso
                )
            )
        } catch (e: Exception){
            throw NoSuchElementException("Categoria ou regulamento não encontrado");
        }
    }

    fun findById(idRegulamentoCategoria: Int): RegulamentoCategoriaEntity {
        return repository.findById(idRegulamentoCategoria).orElseThrow { NoSuchElementException("Categoria não cadastrada ${idRegulamentoCategoria}") }
    }

    @Transactional
    fun deleteById(id: Int) = repository.deleteById(id)

}