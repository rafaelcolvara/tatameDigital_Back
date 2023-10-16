package com.arena.competidor.service

import com.arena.competidor.entity.Competidor
import com.arena.competidor.entity.CompetidorForm
import com.arena.competidor.repository.CompetidorRepository
import com.arena.endereco.service.EnderecoService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CompetidorService(
    private val repository: CompetidorRepository,
    private val enderecoService: EnderecoService
) {
    @Transactional(readOnly = true)
    fun findAll(): List<Competidor> = repository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Short): Competidor? = repository.findById(id).orElse(null)

    @Transactional
    fun save(competidor: CompetidorForm): Competidor = repository.save(
        Competidor(
            nome = competidor.nome,
            dtNascimento = competidor.dtNascimento,
            enderecoId = enderecoService.save(competidor.endereco).id!!.toLong()
        )
    )

    @Transactional
    fun deleteById(id: Short) = repository.deleteById(id)

}

