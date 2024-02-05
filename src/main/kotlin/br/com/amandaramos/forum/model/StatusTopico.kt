package com.amandaramos.br.com.amandaramos.forum.model
//4 parte
import java.time.LocalDateTime

// Define um enum chamado StatusTopico para representar os possíveis estados de um tópico.
enum class StatusTopico{

    NAO_RESPONDIDO,  // Tópico sem resposta.
    NAO_SOLUCIONADO, // Tópico com resposta, mas ainda não solucionado.
    SOLUCIONADO,     // Tópico solucionado.
    FECHADO          // Tópico fechado (pode indicar que não aceita mais respostas ou discussões).

}

/*Comentários adicionais:
O enum class StatusTopico é uma forma de representar os diferentes estados
de um tópico em um fórum. Os estados possíveis são NAO_RESPONDIDO, NAO_SOLUCIONADO,
SOLUCIONADO e FECHADO. Utilizando esse enum, é mais fácil entender e gerenciar o
status de um tópico no código, proporcionando clareza e evitando o uso de valores mágicos
ou strings.*/