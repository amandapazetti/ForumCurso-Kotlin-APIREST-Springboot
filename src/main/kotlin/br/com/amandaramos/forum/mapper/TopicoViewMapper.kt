package com.amandaramos.br.com.amandaramos.forum.mapper
//15 parte
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoViewDTO
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoViewDTO> {

    override fun map(t: Topico): TopicoViewDTO {
        return TopicoViewDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}