package com.tatame.pessoas.competidor.controller

import com.tatame.pessoas.competidor.entity.Competidor
import com.tatame.pessoas.competidor.entity.CompetidorDTO
import com.tatame.pessoas.competidor.entity.CompetidorForm
import com.tatame.pessoas.competidor.service.CompetidorService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@Tag(name = "Competidores")
@RestController
@RequestMapping("/competidores")
class CompetidorController(private val service: CompetidorService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Competidor>> {
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Short): ResponseEntity<CompetidorDTO> {
        val competidor = service.findById(id)
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
        service.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
