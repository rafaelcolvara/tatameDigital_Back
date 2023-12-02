package com.tatame.pessoas.competidor.service

import com.tatame.academia.entity.Academia
import com.tatame.academia.repository.AcademiaRepository
import com.tatame.endereco.entity.Endereco
import com.tatame.pessoas.competidor.entity.Competidor
import com.tatame.pessoas.competidor.entity.CompetidorForm
import com.tatame.pessoas.competidor.repository.CompetidorRepository
import com.tatame.endereco.service.EnderecoService
import com.tatame.faixa.entity.Faixa
import com.tatame.faixa.repository.FaixaRepository
import com.tatame.pessoas.competidor.entity.CompetidorDTO

import com.tatame.pessoas.pessoa.entity.Pessoa
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.NoSuchElementException

@Service
class CompetidorService(
    private val competidorRepository: CompetidorRepository,
    private val enderecoService: EnderecoService,
    private val academiaRepository: AcademiaRepository,
    private val faixaRepository: FaixaRepository
   ) {
    @Transactional(readOnly = true)
    fun findAll(): List<Competidor> = competidorRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): CompetidorDTO{

        val competidorEntity = competidorRepository.findById(id).orElseThrow {NoSuchElementException ("Código ${id} não encontrado")}
        return CompetidorDTO(nomeCompetidor = competidorEntity.pessoa.nome,
            academia = competidorEntity.academia!!.nome,
            peso = competidorEntity.peso
        )
    }

    @Transactional
    fun save(competidor: CompetidorForm): Competidor  {

        val academia: Academia = academiaRepository.findById(competidor.idAcademia).orElseThrow {NoSuchElementException("Não existe academia com o numero ${competidor.idFaixa}")}
        val faixa: Faixa = faixaRepository.findById(competidor.idFaixa).orElseThrow { NoSuchElementException("Não existe faixa com o código ${competidor.idFaixa}") }

        val enderecoCompeenderecoStidor: Endereco = enderecoService.save(competidor.endereco)

        return competidorRepository.save(
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
                    endereco = enderecoCompeenderecoStidor
                    ),
                peso = competidor.peso
            )
            )
    }

    @Transactional
    fun deleteById(id: Int) = competidorRepository.deleteById(id)

}

