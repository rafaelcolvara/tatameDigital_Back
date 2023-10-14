package com.arena.endereco.service

import com.arena.endereco.entity.Cidade
import com.arena.endereco.repository.CidadeRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class CidadeService(private val cidadeRepository: CidadeRepository) {
    fun findAll(): List<Cidade> = cidadeRepository.findAll()
    fun save(cidade: Cidade): Cidade = cidadeRepository.save(cidade)

}