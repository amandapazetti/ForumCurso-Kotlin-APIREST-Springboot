package com.amandaramos.br.com.amandaramos.forum.model
//3 parte

// Define uma data class chamada Curso para representar informações sobre um curso.
//data class Curso (
data class Curso (

    // Propriedade id, que pode ser nula e tem um valor padrão de null.
    val id: Long? = null,

    // Propriedade nome, que armazena o nome do curso como uma String.
    val nome: String,

    // Propriedade categoria, que armazena a categoria do curso como uma String.
    val categoria: String
)

/*EComentários adicionais:
essa data class é utilizada para representar informações sobre um curso, como id,
nome e categoria. Pode ser usada em aplicações que envolvem o gerenciamento de cursos,
por exemplo, em um sistema educacional.*/