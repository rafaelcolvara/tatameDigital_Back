package com.arena.endereco.service

import com.arena.endereco.entity.Endereco
import com.arena.endereco.repository.EnderecoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class EnderecoService(private val enderecoRepository: EnderecoRepository) {
    fun findAll(): List<Endereco> = enderecoRepository.findAll()
    fun save(endereco: Endereco): Endereco = enderecoRepository.save(endereco)
}

