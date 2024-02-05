package com.amandaramos.br.com.amandaramos.forum.dto

import com.amandaramos.br.com.amandaramos.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)