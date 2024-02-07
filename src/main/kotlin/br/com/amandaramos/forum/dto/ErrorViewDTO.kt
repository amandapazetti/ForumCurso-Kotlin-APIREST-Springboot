package com.amandaramos.br.com.amandaramos.forum.dto
//19 parte
import java.time.LocalDateTime

data class ErrorViewDTO (

    // Propriedade que armazena a data e hora em que o erro ocorreu, com valor padrão sendo o momento atual
    val timestamp: LocalDateTime = LocalDateTime.now(),

    // Propriedade que armazena o status HTTP do erro
    val status: Int,
    // Propriedade que armazena uma descrição do erro
    val error: String,
    // Propriedade que armazena uma mensagem detalhada sobre o erro (pode ser nula)
    val message: String?,
// Propriedade que armazena o caminho (path) do recurso onde ocorreu o erro
    val path: String
)