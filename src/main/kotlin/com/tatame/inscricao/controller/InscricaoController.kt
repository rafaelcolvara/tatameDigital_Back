package com.tatame.inscricao.controller

import com.tatame.inscricao.entity.Inscricao
import com.tatame.inscricao.entity.InscricaoForm
import com.tatame.inscricao.service.InscricaoService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Inscrições")
@RestController
@RequestMapping("/inscricoes")
class InscricaoController (private val inscricaoService: InscricaoService){

    @GetMapping
    fun getAll(): ResponseEntity<List<Inscricao>>{
        return ResponseEntity.ok(inscricaoService.findAll())
    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Inscricao>{
        val inscricao = inscricaoService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(inscricao)
    }

    @PostMapping
    fun create(@RequestBody inscricao: InscricaoForm): ResponseEntity<Inscricao> {
        return ResponseEntity.ok(inscricaoService.save(inscricao))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedInscricaoForm: InscricaoForm): ResponseEntity<Inscricao> {
        if (inscricaoService.findById(id) == null) return ResponseEntity.notFound().build()
        return ResponseEntity.ok(inscricaoService.save(updatedInscricaoForm))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        if (inscricaoService.findById(id) == null) return ResponseEntity.notFound().build()
        inscricaoService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}