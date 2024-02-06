package com.amandaramos.br.com.amandaramos.forum.model
//6 - parte
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Resposta (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // Identificador único, inicializado como nulo por padrão.
    val mensagem: String, // Conteúdo da resposta.
    val dataCriacao: LocalDateTime = LocalDateTime.now(), // Data e hora de criação, iniciada com a atual.
    val autor: Usuario, // Autor da resposta, presume-se que seja uma instância da classe Usuario.
    val topico: Topico, // Tópico associado à resposta, presume-se que seja uma instância da classe Topico.
    val solucao: Boolean // Indica se a resposta é a solução para o tópico.

)
