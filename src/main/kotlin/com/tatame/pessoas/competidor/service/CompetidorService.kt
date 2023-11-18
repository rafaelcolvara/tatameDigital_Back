package com.tatame.pessoas.competidor.service

import com.tatame.academia.entity.Academia
import com.tatame.academia.repository.AcademiaRepository
import com.tatame.endereco.entity.Cidade
import com.tatame.endereco.entity.Endereco
import com.tatame.endereco.repository.CidadeRepository
import com.tatame.pessoas.competidor.entity.Competidor
import com.tatame.pessoas.competidor.entity.CompetidorForm
import com.tatame.pessoas.competidor.repository.CompetidorRepository
import com.tatame.endereco.service.EnderecoService
import com.tatame.faixa.entity.Faixa
import com.tatame.faixa.repository.FaixaRepository
import com.tatame.pessoas.pessoa.entity.Pessoa
import com.tatame.pessoas.pessoa.repository.PessoaRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.NoSuchElementException

@Service
class CompetidorService(
    private val repository: CompetidorRepository,
    private val enderecoService: EnderecoService,
    private val academiaRepository: AcademiaRepository,
    private val faixaRepository: FaixaRepository,
    private val pessoaRepository: PessoaRepository,
    private val cidadeRepository: CidadeRepository
) {
    @Transactional(readOnly = true)
    fun findAll(): List<Competidor> = repository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Short): Competidor? = repository.findById(id).orElse(null)

    @Transactional
    fun save(competidor: CompetidorForm): Competidor  {

        val academia: Academia = academiaRepository.findById(competidor.idAcademia).orElseThrow {NoSuchElementException("Não existe academia com o numero ${competidor.idFaixa}")}
        val faixa: Faixa = faixaRepository.findById(competidor.idFaixa).orElseThrow { NoSuchElementException("Não existe faixa com o código ${competidor.idFaixa}") }

        val enderecoCompeenderecoStidor: Endereco = enderecoService.save(competidor.endereco)

        return repository.save(
            Competidor(
                academia = academia,
                faixa = faixa,
                pessoa = Pessoa(
                    id = null,
                    nome = competidor.nomeCompetidor,
                    dataNascimento = competidor.dataNascimento,
                    celular = competidor.celular,
                    dddCelular = competidor.dddCelular,
                    cpfCnpj = competidor.cnpjcpj,
                    foto = competidor.foto,
                    endereco =enderecoCompeenderecoStidor )
                )
            )
    }

    @Transactional
    fun deleteById(id: Short) = repository.deleteById(id)

}

