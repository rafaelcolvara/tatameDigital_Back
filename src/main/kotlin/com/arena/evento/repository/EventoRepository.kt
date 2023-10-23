package com.arena.evento.repository

import com.arena.evento.entity.Evento
import org.springframework.data.jpa.repository.JpaRepository

interface EventoRepository: JpaRepository<Evento, Int> {
}