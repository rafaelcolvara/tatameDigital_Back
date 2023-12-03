package com.tatame.categoriaPeso.controller

import com.tatame.categoriaPeso.entity.CategoriaPesoEntity
import com.tatame.categoriaPeso.entity.CategoriaPesoForm
import com.tatame.categoriaPeso.service.CategoriaPesoService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Categoria Peso")
@RestController
@RequestMapping("/categoriaPeso")
class CategoriaPesoController(private val categoriaPesoService: CategoriaPesoService) {


    @PostMapping
    fun create(@RequestBody categoria: CategoriaPesoForm): ResponseEntity<CategoriaPesoEntity> {
        return ResponseEntity.ok(categoriaPesoService.save(categoria))
    }

    @GetMapping("/all")
    fun getAll(): List<CategoriaPesoEntity> = categoriaPesoService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<CategoriaPesoEntity> {
        try{
            val categoria = categoriaPesoService.findById(id)
            return ResponseEntity.ok(categoria)
        }
        catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedCategoria: CategoriaPesoForm): ResponseEntity<CategoriaPesoEntity> {
        try {
            val categoriaIdadeEntity = categoriaPesoService.findById(id);
            updatedCategoria.id = categoriaIdadeEntity.id
            return ResponseEntity.ok(categoriaPesoService.save(updatedCategoria))

        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        try {
            categoriaPesoService.findById(id)
            categoriaPesoService.deleteById(id)
            return ResponseEntity.noContent().build()

        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }


    }

}