package com.tatame.endereco.service

import com.tatame.endereco.entity.Cidade
import com.tatame.endereco.entity.CidadeForm
import com.tatame.endereco.repository.CidadeRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class CidadeService(private val cidadeRepository: CidadeRepository) {
    fun findAll(): List<Cidade> = cidadeRepository.findAll()
    fun save(cidade: CidadeForm): Cidade{
        return cidadeRepository.save(Cidade(nome = cidade.nome))
    }

    fun findById(idCidade: Int): Cidade {
        return cidadeRepository.findById(idCidade).orElseThrow { NoSuchElementException("Cidade não cadastrada ${idCidade}") }
    }

}