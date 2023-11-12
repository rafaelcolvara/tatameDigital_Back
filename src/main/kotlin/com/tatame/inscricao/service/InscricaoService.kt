package com.tatame.inscricao.service

import com.tatame.inscricao.entity.Inscricao
import com.tatame.inscricao.entity.InscricaoForm
import com.tatame.inscricao.repository.InscricaoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InscricaoService (private val inscricaoRepository: InscricaoRepository){

    @Transactional(readOnly = true)
    fun findAll(): List<Inscricao> = inscricaoRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Inscricao? = inscricaoRepository.findById(id).orElse(null)

    @Transactional
    fun save(inscricao: InscricaoForm): Inscricao = inscricaoRepository.save(
        Inscricao( dtIncricao = inscricao.dtIncricao,
            id_Categoria = inscricao.id_Categoria,
            id_Competidor = inscricao.id_Competidor,
            id_Evento = inscricao.id_Evento,
            pago = inscricao.pago)
    )
    @Transactional
    fun deleteById(id: Int) = inscricaoRepository.deleteById(id)

}