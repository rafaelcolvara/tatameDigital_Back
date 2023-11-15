package com.tatame.categoria.controller

import com.tatame.categoria.entity.Categoria
import com.tatame.categoria.entity.CategoriaForm
import com.tatame.categoria.service.CategoriaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@Tag(name = "Categoria")
@RestController
@RequestMapping("/categorias")
class CategoriaController(private val categoriaService: CategoriaService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Categoria>> {
        return ResponseEntity.ok(categoriaService.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Categoria> {
        val categoria = categoriaService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(categoria)
    }

    @PostMapping
    fun create(@RequestBody categoria: CategoriaForm): ResponseEntity<Categoria> {
        return ResponseEntity.ok(categoriaService.save(categoria))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedCategoria: CategoriaForm): ResponseEntity<Categoria> {
        if (categoriaService.findById(id) == null) return ResponseEntity.notFound().build()
        return ResponseEntity.ok(categoriaService.save(updatedCategoria))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        if (categoriaService.findById(id) == null) return ResponseEntity.notFound().build()
        categoriaService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}