package com.amandaramos.br.com.amandaramos.forum.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

// 2 parte do código

@Entity
// Define uma data class chamada Usuario para representar informações de um usuário.
data class Usuario (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Propriedade id, que pode ser nula e tem um valor padrão de null.
    val id: Long? = null,

    // Propriedade nome, que armazena o nome do usuário como uma String.
    val nome: String,

    // Propriedade email, que armazena o endereço de e-mail do usuário como uma String.
    val email: String
)



/*Comentários adicionais:

data class: A palavra-chave data é usada para declarar uma data class no Kotlin. Data classes automaticamente geram métodos como toString(), hashCode(), equals(), entre outros, com base nas propriedades declaradas.

val: As propriedades são declaradas com a palavra-chave val, indicando que são somente leitura (não podem ser modificadas após a inicialização).

Long?: O tipo Long? indica que a propriedade id é do tipo Long e pode ser nula.

Valores padrão: As propriedades id têm um valor padrão de null, o que significa que se não for fornecido durante a criação de uma instância, será atribuído o valor padrão null.

Essa data class é utilizada para representar informações básicas de um usuário, como id, nome e email. Pode ser usada em aplicações que envolvem o gerenciamento de usuários.





*/