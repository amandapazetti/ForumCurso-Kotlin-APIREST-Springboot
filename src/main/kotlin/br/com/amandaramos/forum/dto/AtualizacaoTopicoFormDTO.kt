package com.amandaramos.br.com.amandaramos.forum.dto
//17 parte
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoTopicoFormDTO (

    // Propriedade que representa o ID do tópico a ser atualizado.
    // Anotação para garantir que o ID não seja nulo
    @field:NotNull
    val id: Long,

// Propriedade que representa o novo título do tópico
    @field:NotEmpty // Anotação para garantir que o título não esteja vazio
    @field:Size(min = 5, max = 100) // Anotação para definir o tamanho mínimo e máximo do título
    val titulo: String,


   //Propriedade que representa a nova mensagem do tópico
    @field:NotEmpty // Anotação para garantir que a mensagem não esteja vazia
    val mensagem: String
)


/*Resumo:Padronização e Estruturação de Dados: Serve como um "envelope" para os dados fornecidos pelo usuário em um formulário de atualização de tópicos. As propriedades do DTO representam campos específicos do formulário, como título e mensagem, permitindo uma organização estruturada dos dados.

Facilita a Transferência de Dados: Simplifica a transferência de dados entre as camadas da aplicação. Quando um usuário envia um formulário de atualização, os dados são encapsulados dentro do DTO e transferidos de forma coesa entre a interface do usuário, o controle e a camada de serviço, garantindo consistência no processo de atualização.

Garantia de Integridade dos Dados: As anotações de validação, como @NotEmpty e @Size, aplicadas às propriedades do DTO, asseguram que os dados fornecidos pelo usuário estejam em conformidade com os critérios definidos pela aplicação. Por exemplo, garantem que o título tenha um tamanho mínimo e máximo especificado e que campos obrigatórios não estejam vazios.

Melhora a Manutenção e Escalabilidade: Ao centralizar a estrutura de dados e a lógica de validação em um DTO, facilita a manutenção e evita a duplicação de código. Além disso, torna mais simples adicionar novos campos ou regras de validação no futuro, garantindo uma aplicação mais flexível e escalável.

Em suma, o AtualizacaoTopicoFormDTO é uma peça-chave para garantir a consistência, padronização e validação dos dados durante o processo de atualização de tópicos em um fórum, contribuindo para a eficiência e robustez da aplicação.*/