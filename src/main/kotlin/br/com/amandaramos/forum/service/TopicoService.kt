package com.amandaramos.br.com.amandaramos.forum.service
//11 parte
import br.com.amandaramos.forum.repository.TopicoRepository
import com.amandaramos.br.com.amandaramos.forum.dto.AtualizacaoTopicoFormDTO
import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoFormDTO
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoViewDTO
import com.amandaramos.br.com.amandaramos.forum.mapper.TopicoFormMapper
import com.amandaramos.br.com.amandaramos.forum.mapper.TopicoViewMapper
import org.springframework.stereotype.Service

// Define a classe como um serviço Spring
@Service
class TopicoService (private val topicoRepository: TopicoRepository,// Injeção de dependência do repositório de tópicos
                     private val topicoViewMapper: TopicoViewMapper, // Injeção de dependência do mapeador de visualização de tópicos
                     private val topicoFormMapper: TopicoFormMapper, // Injeção de dependência do mapeador de formulário de tópicos

) {
    // Mensagem padrão para tópico não encontrado
    private val notFoundMessage = "Topico nao encontrado!"

    // Método para listar todos os tópicos e mapeá-los para DTOs de visualização
    fun listar(): List<TopicoViewDTO> {
        return topicoRepository.findAll().map { topicoViewMapper.map(it) }
    }

    // Método para buscar um tópico por ID e mapeá-lo para DTO de visualização
    fun buscarPorId(id: Long): TopicoViewDTO {
        val topico = topicoRepository.findById(id)
            .orElseThrow { NoSuchElementException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    // Método para cadastrar um novo tópico a partir de um formulário e mapeá-lo para DTO de visualização
    fun cadastrar(form: NovoTopicoFormDTO): TopicoViewDTO {
        val topico = topicoFormMapper.map(form)
        val topicoSalvo = topicoRepository.save(topico)
        return topicoViewMapper.map(topicoSalvo)
    }


    // Método para atualizar um tópico existente a partir de um formulário e mapeá-lo para DTO de visualização
    fun atualizar(id: Long, form: AtualizacaoTopicoFormDTO): TopicoViewDTO {
        val topico = topicoRepository.findById(form.id)
            .orElseThrow { NoSuchElementException(notFoundMessage) }

        // Atualiza os campos necessários
        topico.apply {
            titulo = form.titulo
            mensagem = form.mensagem
        }

        val topicoSalvo = topicoRepository.save(topico)
        return topicoViewMapper.map(topicoSalvo)
    }

    // Método para deletar um tópico existente
    fun deletar(id: Long) {
        val topico = topicoRepository.findById(id)
            .orElseThrow { NoSuchElementException(notFoundMessage) }
        topicoRepository.delete(topico)
    }
}

/*Resumo: Este serviço é responsável por realizar operações relacionadas
aos tópicos do fórum, como listar, buscar, cadastrar, atualizar e deletar tópicos.
Ele utiliza um repositório para acessar os dados, mapeadores para converter entre
 diferentes tipos de objetos (DTOs e entidades) e fornece métodos para executar
  as operações necessárias, retornando DTOs de visualização como resultado.*/