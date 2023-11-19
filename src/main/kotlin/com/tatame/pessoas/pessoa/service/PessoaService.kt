package com.tatame.pessoas.pessoa.service


import com.tatame.endereco.entity.Endereco
import com.tatame.endereco.entity.EnderecoForm
import com.tatame.endereco.repository.CidadeRepository
import com.tatame.endereco.service.EnderecoService
import com.tatame.pessoas.pessoa.entity.Pessoa
import com.tatame.pessoas.pessoa.entity.PessoaForm
import com.tatame.pessoas.pessoa.repository.PessoaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PessoaService(private val repository: PessoaRepository,
                    private val enderecoService: EnderecoService,
                    private val cidadeRepository: CidadeRepository
) {
    @Transactional(readOnly = true)
    fun findAll(): List<Pessoa> = repository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Pessoa? = repository.findById(id).orElse(null)

    @Transactional(readOnly = true)
    fun deleteById(id: Int)  = repository.deleteById(id)

    @Transactional
    fun save(pessoa: PessoaForm): Pessoa {

        val endereco: Endereco = enderecoService.save(
            EnderecoForm(
                rua = pessoa.endereco!!.rua,
                numero = pessoa.endereco.numero,
                complemento = pessoa.endereco.complemento,
                cep = pessoa.endereco.cep,
                idCidade =  pessoa.endereco!!.idCidade
        ))

        return repository.save(Pessoa(
            id = null,
            nome = pessoa.nome,
            dataNascimento = pessoa.dataNascimento,
            celular = pessoa.celular,
            cpfCnpj = pessoa.cpfCnpj,
            dddCelular = pessoa.dddCelular,
            foto = pessoa.foto,
            endereco = endereco) )


    }

}