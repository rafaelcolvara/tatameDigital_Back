package com.tatame.evento.controller

import com.tatame.evento.entity.Evento
import com.tatame.evento.entity.EventoForm
import com.tatame.evento.service.EventoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/eventos")
class EventoController(private val eventoService: EventoService ) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Evento>> {
        return ResponseEntity.ok(eventoService.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Evento> {
        val evento = eventoService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(evento)
    }

    @PostMapping
    fun create(@RequestBody evento: EventoForm): ResponseEntity<Evento> {
        return ResponseEntity.ok(eventoService.save(evento))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedEvento: EventoForm): ResponseEntity<Evento> {
        if (eventoService.findById(id) == null) return ResponseEntity.notFound().build()
        return ResponseEntity.ok(eventoService.save(updatedEvento))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        if (eventoService.findById(id) == null) return ResponseEntity.notFound().build()
        eventoService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}