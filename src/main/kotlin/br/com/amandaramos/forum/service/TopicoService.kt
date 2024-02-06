package com.amandaramos.br.com.amandaramos.forum.service
//11 parte
import br.com.amandaramos.forum.repository.TopicoRepository
import com.amandaramos.br.com.amandaramos.forum.dto.AtualizacaoTopicoForm
import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoForm
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoView
import com.amandaramos.br.com.amandaramos.forum.mapper.TopicoFormMapper
import com.amandaramos.br.com.amandaramos.forum.mapper.TopicoViewMapper
import org.springframework.stereotype.Service

@Service
class TopicoService (private val topicoRepository: TopicoRepository,
                     private val topicoViewMapper: TopicoViewMapper,
                     private val topicoFormMapper: TopicoFormMapper,

) {
    private val notFoundMessage = "Topico nao encontrado!"
    fun listar(): List<TopicoView> {
        return topicoRepository.findAll().map { topicoViewMapper.map(it) }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicoRepository.findById(id)
            .orElseThrow { NoSuchElementException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        val topicoSalvo = topicoRepository.save(topico)
        return topicoViewMapper.map(topicoSalvo)
    }

    fun atualizar(id: Long, form: AtualizacaoTopicoForm): TopicoView {
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

    fun deletar(id: Long) {
        val topico = topicoRepository.findById(id)
            .orElseThrow { NoSuchElementException(notFoundMessage) }
        topicoRepository.delete(topico)
    }
}