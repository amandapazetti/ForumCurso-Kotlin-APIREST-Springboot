package com.amandaramos.br.com.amandaramos.forum.mapper
//14 parte
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
        val curso = cursoService.buscarPorId(t.idCurso)
        val autor = usuarioService.buscarPorId(t.idAutor)

        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = requireNotNull(curso) { "Curso não encontrado" },
            autor = requireNotNull(autor) { "Autor não encontrado" }
        )
    }
}