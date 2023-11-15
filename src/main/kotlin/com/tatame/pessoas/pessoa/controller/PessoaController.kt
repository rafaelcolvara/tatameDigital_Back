package com.tatame.pessoas.pessoa.controller

import com.tatame.categoria.entity.Categoria
import com.tatame.categoria.entity.CategoriaForm
import com.tatame.categoria.service.CategoriaService
import com.tatame.pessoas.pessoa.entity.Pessoa
import com.tatame.pessoas.pessoa.entity.PessoaForm
import com.tatame.pessoas.pessoa.service.PessoaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Pessoa")
@RestController
@RequestMapping("/pessoas")
data class PessoaController(private val pessoaService: PessoaService){
    @GetMapping
    fun getAll(): ResponseEntity<List<Pessoa>> {
        return ResponseEntity.ok(pessoaService.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Pessoa> {
        val pessoa = pessoaService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(pessoa)
    }

    @PostMapping
    fun create(@RequestBody pessoa: PessoaForm): ResponseEntity<Pessoa> {
        return ResponseEntity.ok(pessoaService.save(pessoa))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedPessoaForm: PessoaForm): ResponseEntity<Pessoa> {
        if (pessoaService.findById(id) == null) return ResponseEntity.notFound().build()
        return ResponseEntity.ok(pessoaService.save(updatedPessoaForm))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        if (pessoaService.findById(id) == null) return ResponseEntity.notFound().build()
        pessoaService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
