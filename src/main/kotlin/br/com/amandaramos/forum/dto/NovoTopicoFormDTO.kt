package com.amandaramos.br.com.amandaramos.forum.dto
//16 parte
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoFormDTO (

    //Anotação para garantir que o título não esteja vazio
    @field:NotEmpty(message = "Titulo nao pode ser em branco")
    // Anotação para definir o tamanho mínimo e máximo do título
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
     val titulo: String,

    // Anotação para garantir que a mensagem não esteja vazia
    @field:NotEmpty(message = "Mensagem nao pode ser em branco")
    val mensagem: String,


// Anotação para garantir que o ID do curso não seja nulo
    @field:NotNull
    val idCurso: Long,

// Anotação para garantir que o ID do autor não seja nulo
    @field:NotNull
    val idAutor: Long


)

/*Resumo: Essas anotações de validação encapsulam a lógica de validação dentro
da própria classe, garantindo que os dados enviados pelo usuário em um formulário
 estejam corretos antes de serem processados pela aplicação. Isso ajuda a manter o
 código mais limpo e legível, evitando a necessidade de escrever manualmente a lógica
  de validação em outros lugares do código.*/