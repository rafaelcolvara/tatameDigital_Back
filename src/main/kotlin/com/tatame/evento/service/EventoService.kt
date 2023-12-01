package com.tatame.evento.service

import com.tatame.evento.entity.Evento
import com.tatame.evento.entity.EventoForm
import com.tatame.evento.repository.EventoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
@Service
data class EventoService(private val eventoRepository: EventoRepository){

    @Transactional(readOnly = true)
    fun findAll(): List<Evento> = eventoRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Evento? = eventoRepository.findById(id).orElse(null)

    @Transactional
    fun save(evento: EventoForm): Evento = eventoRepository.save(
        Evento( nome = evento.nome,
            dtEvento = evento.dtEvento,
            fotoEvento = evento.fotoEvento,
            regulamento = evento.regulamento)
    )
    @Transactional
    fun deleteById(id: Int) = eventoRepository.deleteById(id)


}
