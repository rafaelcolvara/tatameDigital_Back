package com.tatame.categoriaPeso.controller

import com.tatame.categoriaPeso.entity.CategoriaPeso
import com.tatame.categoriaPeso.service.CategoriaPesoService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Categoria Peso")
@RestController
@RequestMapping("/categoriaPeso")
class CategoriaPesoController(private val categoriaPesoService: CategoriaPesoService) {


    @GetMapping
    fun getAll(): ResponseEntity<List<CategoriaPeso>> {
        return ResponseEntity.ok(categoriaPesoService.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<CategoriaPeso> {
        val categoria = categoriaPesoService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(categoria)
    }

    @PostMapping
    fun create(@RequestBody categoriaPeso: CategoriaPeso): ResponseEntity<CategoriaPeso> {
        return ResponseEntity.ok(categoriaPesoService.save(categoriaPeso))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody categoriaPeso: CategoriaPeso): ResponseEntity<CategoriaPeso> {
        if (categoriaPesoService.findById(id) == null) return ResponseEntity.notFound().build()
        return ResponseEntity.ok(categoriaPesoService.save(categoriaPeso))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        if (categoriaPesoService.findById(id) == null) return ResponseEntity.notFound().build()
        categoriaPesoService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}