package com.amandaramos.br.com.amandaramos.forum.model
//5 parte
import java.time.LocalDateTime

/*Declaração da Data Class: Utilizamos a palavra-chave data class para declarar a classe
 Topico, indicando que ela será usada para representar dados imutáveis.
Define uma data class chamada Topico para representar informações do topico em um forum*/


data class Topico (var id: Long? = null, // Identificador único do tópico, inicializado como nulo por padrão
                   val titulo: String, // Título do tópico, campo obrigatório
                   val mensagem: String, // Mensagem do tópico, campo obrigatório
                   val dataCriacao: LocalDateTime = LocalDateTime.now(), // Data e hora de criação do tópico, padrão é a data e hora atuais
                   val curso: Curso,    // Curso associado ao tópico, representado por outra data class chamada Curso
                   val autor: Usuario,  // Autor do tópico, representado por outra data class chamada Usuario
                   val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,  // Status do tópico, inicializado como NAO_RESPONDIDO por padrão
                   val respostas: List<Resposta> = ArrayList()  // Lista de respostas associadas ao tópico, inicializada como uma lista vazia

)