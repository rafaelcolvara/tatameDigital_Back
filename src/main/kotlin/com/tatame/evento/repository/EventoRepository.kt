package com.tatame.evento.repository

import com.tatame.evento.entity.Evento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventoRepository: JpaRepository<Evento, Int> {
}