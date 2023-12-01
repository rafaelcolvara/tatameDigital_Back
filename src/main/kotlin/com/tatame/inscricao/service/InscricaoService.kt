package com.tatame.inscricao.service

import com.tatame.evento.repository.EventoRepository
import com.tatame.inscricao.entity.Inscricao
import com.tatame.inscricao.entity.InscricaoForm
import com.tatame.inscricao.repository.InscricaoRepository
import com.tatame.pessoas.competidor.repository.CompetidorRepository
import com.tatame.regulamento.entity.RegulamentoCategoriaPK
import com.tatame.regulamentoCategoria.repository.RegulamentoCategoriaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InscricaoService (private val inscricaoRepository: InscricaoRepository,
    private val eventoRepository: EventoRepository,
    private val competidorRepository: CompetidorRepository,
    private val regulamentoCategoriaRepository: RegulamentoCategoriaRepository
    ){

    @Transactional(readOnly = true)
    fun findAll(): List<Inscricao> = inscricaoRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Inscricao? = inscricaoRepository.findById(id).orElse(null)

    @Transactional
    fun save(inscricao: InscricaoForm): Inscricao  {

        val evento = eventoRepository.findById(inscricao.id_Evento!!).orElseThrow { NoSuchElementException("Evento ${inscricao.id_Evento} não encontrado") }
        val competidor = competidorRepository.findById(inscricao.id_Competidor!!).orElseThrow { NoSuchElementException("Competior ${inscricao.id_Competidor!!} não encontrado") }
        val regulamentoCategoria = regulamentoCategoriaRepository.findById(inscricao.id_Regulamento_Categoria!!).orElseThrow { NoSuchElementException("Categoria ${inscricao.id_Regulamento_Categoria} não encontrada") }

        return inscricaoRepository.save(
            Inscricao( dtIncricao = inscricao.dtIncricao,
                id_Competidor = competidor,
                id_Evento = evento,
                pago = inscricao.pago,
                regulamentoCategoria = regulamentoCategoria
            )
        )
    }
    @Transactional
    fun deleteById(id: Int) = inscricaoRepository.deleteById(id)

}