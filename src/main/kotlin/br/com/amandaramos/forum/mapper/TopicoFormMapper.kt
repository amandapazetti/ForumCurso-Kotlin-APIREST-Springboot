package com.amandaramos.br.com.amandaramos.forum.mapper

import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoForm
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import com.amandaramos.br.com.amandaramos.forum.service.CursoService
import com.amandaramos.br.com.amandaramos.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper (
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}