package com.amandaramos.br.com.amandaramos.forum.model
//5 parte
import java.time.LocalDateTime
import javax.persistence.*

/*Declaração da Data Class: Utilizamos a palavra-chave data class para declarar a classe
 Topico, indicando que ela será usada para representar dados imutáveis.
Define uma data class chamada Topico para representar informações do topico em um forum*/

@Entity

data class Topico (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null, // Identificador único do tópico, inicializado como nulo por padrão
    var titulo: String, // Título do tópico, campo obrigatório
    var mensagem: String, // Mensagem do tópico, campo obrigatório
    val dataCriacao: LocalDateTime = LocalDateTime.now(), // Data e hora de criação do tópico, padrão é a data e hora atuais

    @ManyToOne
    val curso: Curso,    // Curso associado ao tópico, representado por outra data class chamada Curso

    @ManyToOne
    val autor: Usuario,  // Autor do tópico, representado por outra data class chamada Usuario

    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,  // Status do tópico, inicializado como NAO_RESPONDIDO por padrão

   @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = listOf()  // Lista de respostas associadas ao tópico, inicializada como uma lista vazia

)