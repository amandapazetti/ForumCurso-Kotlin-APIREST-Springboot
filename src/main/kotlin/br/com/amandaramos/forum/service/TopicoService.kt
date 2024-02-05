package com.amandaramos.br.com.amandaramos.forum.service

import com.amandaramos.br.com.amandaramos.forum.dto.AtualizacaoTopicoForm
import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoForm
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoView
import com.amandaramos.br.com.amandaramos.forum.mapper.TopicoFormMapper
import com.amandaramos.br.com.amandaramos.forum.mapper.TopicoViewMapper
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import java.util.stream.Collectors
@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(),
                     private val topicoViewMapper: TopicoViewMapper,
                     private val topicoFormMapper: TopicoFormMapper,
                     private val notFoundMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{ ChangeSetPersister.NotFoundException() }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().orElseThrow{ ChangeSetPersister.NotFoundException() }
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{ ChangeSetPersister.NotFoundException() }
        topicos = topicos.minus(topico)
    }

}