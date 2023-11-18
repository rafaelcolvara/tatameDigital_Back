package com.tatame.academia.controller

import com.tatame.academia.entity.Academia
import com.tatame.academia.entity.AcademiaForm
import com.tatame.academia.service.AcademiaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@Tag(name = "Academia")
@RestController
@RequestMapping("/academias")
class AcademiaController(private val academiaService: AcademiaService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Academia>> {
        return ResponseEntity.ok(academiaService.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Academia> {
        val academia = academiaService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(academia)
    }

    @PostMapping
    fun create(@RequestBody academia: AcademiaForm): ResponseEntity<Academia> {
        return ResponseEntity.ok(academiaService.save(academia))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedAcademia: AcademiaForm): ResponseEntity<Academia> {
        if (academiaService.findById(id) == null) return ResponseEntity.notFound().build()
        return ResponseEntity.ok(academiaService.save(updatedAcademia))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        if (academiaService.findById(id) == null) return ResponseEntity.notFound().build()
        academiaService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}