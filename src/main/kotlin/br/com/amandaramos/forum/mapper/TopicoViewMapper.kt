package com.amandaramos.br.com.amandaramos.forum.mapper
//15 parte
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoView
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}