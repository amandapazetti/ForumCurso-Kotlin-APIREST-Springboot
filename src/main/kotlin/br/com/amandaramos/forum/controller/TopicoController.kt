package com.amandaramos.br.com.amandaramos.forum.controller
//20 parte
import com.amandaramos.br.com.amandaramos.forum.dto.AtualizacaoTopicoForm
import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoForm
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoView
import com.amandaramos.br.com.amandaramos.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.net.URI


@RestController
@RequestMapping("/topicos")
class TopicoController (private val topicoService: TopicoService) {
    @GetMapping
    fun listarTopicos(): ResponseEntity<List<TopicoView>> {
        val topicos = topicoService.listar()
        return ResponseEntity.ok(topicos)
    }

    @GetMapping("/{id}")
    fun buscarTopicoPorId(@PathVariable id: Long): ResponseEntity<TopicoView> {
        val topico = topicoService.buscarPorId(id)
        return ResponseEntity.ok(topico)
    }

    @PostMapping
    fun cadastrarTopico(@RequestBody form: NovoTopicoForm): ResponseEntity<TopicoView> {
        val topico = topicoService.cadastrar(form)
        return ResponseEntity.created(URI("/topicos/${topico.id}")).body(topico)
    }

    @PutMapping("/{id}")
    fun atualizarTopico(@PathVariable id: Long, @RequestBody form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        val topico = topicoService.atualizar(id, form)
        return ResponseEntity.ok(topico)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarTopico(@PathVariable id: Long) {
        topicoService.deletar(id)
    }
}