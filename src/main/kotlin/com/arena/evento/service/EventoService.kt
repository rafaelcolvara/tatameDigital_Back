package com.arena.evento.service

import com.arena.categoria.entity.Categoria
import com.arena.categoria.entity.CategoriaForm
import com.arena.evento.entity.Evento
import com.arena.evento.entity.EventoForm
import com.arena.evento.repository.EventoRepository
import org.springframework.transaction.annotation.Transactional

data class EventoService(private val eventoRepository: EventoRepository){

    @Transactional(readOnly = true)
    fun findAll(): List<Evento> = eventoRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Evento? = eventoRepository.findById(id).orElse(null)

    @Transactional
    fun save(evento: EventoForm): Evento = eventoRepository.save(
        Evento( nome = evento.nome, dtEvento = evento.dtEvento)
    )
    @Transactional
    fun deleteById(id: Int) = eventoRepository.deleteById(id)


}
