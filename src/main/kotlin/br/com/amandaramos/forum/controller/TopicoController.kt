package com.amandaramos.br.com.amandaramos.forum.controller
//20 parte
import com.amandaramos.br.com.amandaramos.forum.dto.AtualizacaoTopicoFormDTO
import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoFormDTO
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoViewDTO
import com.amandaramos.br.com.amandaramos.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.net.URI


@RestController
@RequestMapping("/topicos")
class TopicoController (private val topicoService: TopicoService) {
    @GetMapping
    fun listarTopicos(): ResponseEntity<List<TopicoViewDTO>> {
        val topicos = topicoService.listar()
        return ResponseEntity.ok(topicos)
    }

    @GetMapping("/{id}")
    fun buscarTopicoPorId(@PathVariable id: Long): ResponseEntity<TopicoViewDTO> {
        val topico = topicoService.buscarPorId(id)
        return ResponseEntity.ok(topico)
    }

    @PostMapping
    fun cadastrarTopico(@RequestBody form: NovoTopicoFormDTO): ResponseEntity<TopicoViewDTO> {
        val topico = topicoService.cadastrar(form)
        return ResponseEntity.created(URI("/topicos/${topico.id}")).body(topico)
    }

    @PutMapping("/{id}")
    fun atualizarTopico(@PathVariable id: Long, @RequestBody form: AtualizacaoTopicoFormDTO): ResponseEntity<TopicoViewDTO> {
        val topico = topicoService.atualizar(id, form)
        return ResponseEntity.ok(topico)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarTopico(@PathVariable id: Long) {
        topicoService.deletar(id)
    }
}