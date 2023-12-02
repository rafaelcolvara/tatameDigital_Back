package com.tatame.categoriaPeso.service

import com.tatame.academia.entity.Academia
import com.tatame.academia.entity.AcademiaForm
import com.tatame.categoriaPeso.entity.CategoriaPeso
import com.tatame.categoriaPeso.repository.CategoriaPesoRespository
import com.tatame.pessoas.pessoa.entity.Pessoa
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CategoriaPesoService(
    val categoriaPesoRepository: CategoriaPesoRespository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<CategoriaPeso> = categoriaPesoRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): CategoriaPeso? = categoriaPesoRepository.findById(id).orElse(null)

    @Transactional
    fun save(categoriaPeso: CategoriaPeso): CategoriaPeso {
        return categoriaPesoRepository.save(categoriaPeso)
    }
    @Transactional
    fun deleteById(id: Int) = categoriaPesoRepository.deleteById(id)

}