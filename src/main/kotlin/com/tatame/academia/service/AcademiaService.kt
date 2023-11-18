package com.tatame.academia.service

import com.tatame.academia.entity.Academia
import com.tatame.academia.entity.AcademiaForm
import com.tatame.academia.repository.AcademiaRepository
import com.tatame.categoria.entity.Categoria
import com.tatame.categoria.entity.CategoriaForm
import com.tatame.categoria.repository.CategoriaRepository
import com.tatame.pessoas.pessoa.entity.Pessoa
import com.tatame.pessoas.pessoa.repository.PessoaRepository
import com.tatame.pessoas.pessoa.service.PessoaService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AcademiaService(private val academiaRepository: AcademiaRepository,
    private val pessoaRepository: PessoaRepository
) {
    @Transactional(readOnly = true)
    fun findAll(): List<Academia> = academiaRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Academia? = academiaRepository.findById(id).orElse(null)

    @Transactional
    fun save(academia: AcademiaForm): Academia {
        val professorPessoa: Pessoa = pessoaRepository.findById(academia.idProfessor).orElseThrow { NoSuchElementException("id professor nao encontrado ${academia.idProfessor}") }

        return academiaRepository.save(
            Academia( nome = academia.nome,
                professor = professorPessoa,
                id = null)
        )

    }
    @Transactional
    fun deleteById(id: Int) = academiaRepository.deleteById(id)

}