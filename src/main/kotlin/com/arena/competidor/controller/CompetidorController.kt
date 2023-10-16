package com.arena.competidor.controller

import com.arena.competidor.entity.Competidor
import com.arena.competidor.entity.CompetidorForm
import com.arena.competidor.service.CompetidorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/competidores")
class CompetidorController(private val service: CompetidorService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Competidor>> {
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Short): ResponseEntity<Competidor> {
        val competidor = service.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(competidor)
    }

    @PostMapping
    fun create(@RequestBody competidor: CompetidorForm): ResponseEntity<Competidor> {
        return ResponseEntity.ok(service.save(competidor))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Short, @RequestBody updatedCompetidor: CompetidorForm): ResponseEntity<Competidor> {
        if (service.findById(id) == null) return ResponseEntity.notFound().build()
        return ResponseEntity.ok(service.save(updatedCompetidor))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Short): ResponseEntity<Void> {
        if (service.findById(id) == null) return ResponseEntity.notFound().build()
        service.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
