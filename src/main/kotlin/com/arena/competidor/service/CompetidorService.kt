package com.arena.competidor.service

import com.arena.competidor.entity.Competidor
import com.arena.competidor.repository.CompetidorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CompetidorService(private val repository: CompetidorRepository) {
    @Transactional(readOnly = true)
    fun findAll(): List<Competidor> = repository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Short): Competidor? = repository.findById(id).orElse(null)

    @Transactional
    fun save(competidor: Competidor): Competidor = repository.save(competidor)

    @Transactional
    fun deleteById(id: Short) = repository.deleteById(id)

}

