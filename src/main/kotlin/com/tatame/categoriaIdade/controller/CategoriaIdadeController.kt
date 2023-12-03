package com.tatame.categoriaIdade.controller

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import com.tatame.categoriaIdade.entity.CategoriaIdadeForm
import com.tatame.categoriaIdade.service.CategoriaIdadeService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "CategoriaIdade")
@RestController
@RequestMapping("/categoriaIdade")
class CategoriaIdadeController(val categoriaIdadeService: CategoriaIdadeService) {

    @PostMapping
    fun create(@RequestBody categoria: CategoriaIdadeForm): ResponseEntity<CategoriaIdadeEntity> {
        return ResponseEntity.ok(categoriaIdadeService.save(categoria))
    }

    @GetMapping("/all")
    fun getAll(): List<CategoriaIdadeEntity> = categoriaIdadeService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<CategoriaIdadeEntity> {
        try{
            val categoria = categoriaIdadeService.findById(id)
            return ResponseEntity.ok(categoria)
        }
        catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedCategoria: CategoriaIdadeForm): ResponseEntity<CategoriaIdadeEntity> {
        try {
            val categoriaIdadeEntity = categoriaIdadeService.findById(id);
            updatedCategoria.idCategoria = categoriaIdadeEntity.id
            return ResponseEntity.ok(categoriaIdadeService.save(updatedCategoria))

        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        try {
            categoriaIdadeService.findById(id)
            categoriaIdadeService.deleteById(id)
            return ResponseEntity.noContent().build()

        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }


    }

}