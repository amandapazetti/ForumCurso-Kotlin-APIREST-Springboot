package com.amandaramos.br.com.amandaramos.forum.dto
//18 parte
import com.amandaramos.br.com.amandaramos.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoViewDTO (

    // Propriedade que representa o ID do tópico
    val id: Long?,

    // Propriedade que representa o título do tópico
    val titulo: String,

    // Propriedade que representa a mensagem do tópico
    val mensagem: String,

// Propriedade que representa o status do tópico (aberto, fechado etc.)
    val status: StatusTopico,

    // Propriedade que representa a data e hora de criação do tópico
    val dataCriacao: LocalDateTime
)

/*Resumo: Essa classe define um DTO (Objeto de Transferência de Dados) chamado
 TopicoViewDTO, que possui propriedades para representar os detalhes de um tópico,
 como ID, título, mensagem, status e data de criação. Este DTO é útil para transmitir
 essas informações entre diferentes partes da aplicação, proporcionando uma estrutura
 consistente e modular para a manipulação de dados de tópicos.*/