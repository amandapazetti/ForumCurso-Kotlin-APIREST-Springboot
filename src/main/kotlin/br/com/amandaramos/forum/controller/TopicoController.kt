package com.amandaramos.br.com.amandaramos.forum.controller
//20 parte
import com.amandaramos.br.com.amandaramos.forum.dto.AtualizacaoTopicoFormDTO
import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoFormDTO
import com.amandaramos.br.com.amandaramos.forum.dto.TopicoViewDTO
import com.amandaramos.br.com.amandaramos.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.net.URI

/*Declaração da classe TopicoController, que é um controlador Rest responsável por gerenciar
as requisições relacionadas aos tópicos do fórum. A anotação @RestController
indica que esta classe irá lidar com requisições HTTP RESTful.
O @RequestMapping define o mapeamento de URL base para as rotas
relacionadas aos tópicos.*/
@RestController
@RequestMapping("/topicos")


/*Essa linha essencialmente declara um construtor para a classe TopicoController,
onde é injetado o TopicoService como uma dependência. Isso permite que a
classe TopicoController utilize os métodos e funcionalidades fornecidos pelo
TopicoService para gerenciar os tópicos. Esse padrão de injeção de dependência
é comumente utilizado em aplicações Spring para promover a modularidade,
reutilização e teste de componentes.*/

class TopicoController(private val topicoService: TopicoService) {

    // mapeia requisições HTTP GET para o método listarTopicos()
    @GetMapping

   //retorna um objeto ResponseEntity<List<TopicoViewDTO>>,
    // que é uma resposta HTTP que pode conter uma lista de tópicos.
    // O tipo <List<TopicoViewDTO>> especifica que o corpo da resposta
    // será uma lista de objetos do tipo TopicoViewDTO.
    fun listarTopicos(): ResponseEntity<List<TopicoViewDTO>> {
       // Aqui, estamos chamando o método listar() do topicoService para obter a lista de tópicos.
        val topicos = topicoService.listar()
       //Este é o retorno do método. Ele cria uma resposta HTTP OK (200 OK) utilizando o método estático
        // ok() da classe ResponseEntity, que indica que a requisição foi bem-sucedida.
        return ResponseEntity.ok(topicos)
    }

    @GetMapping("/{id}")
    fun buscarTopicoPorId(@PathVariable id: Long): ResponseEntity<TopicoViewDTO> {
        val topico = topicoService.buscarPorId(id) // Chama o método buscarPorId() do serviço para encontrar o tópico com o ID especificado
        return ResponseEntity.ok(topico) // Retorna uma resposta HTTP OK com o tópico encontrado no corpo da resposta
    }

    @PostMapping// Indica que este método responde a requisições HTTP POST
    fun cadastrarTopico(@RequestBody form: NovoTopicoFormDTO): ResponseEntity<TopicoViewDTO> {
        val topico = topicoService.cadastrar(form) // Chama o método cadastrar() do serviço para criar um novo tópico
        return ResponseEntity.created(URI("/topicos/${topico.id}")).body(topico) // Retorna uma resposta HTTP CREATED com o URI do recurso criado no cabeçalho e o corpo contendo os dados do tópico criado
    }

    @PutMapping("/{id}")// Indica que este método responde a requisições HTTP PUT para a URL "/topicos/{id}"
    fun atualizarTopico(@PathVariable id: Long, @RequestBody form: AtualizacaoTopicoFormDTO): ResponseEntity<TopicoViewDTO> {
        val topico = topicoService.atualizar(id, form)// Chama o método atualizar() do serviço para atualizar um tópico existente
        return ResponseEntity.ok(topico)// Retorna uma resposta HTTP OK com os dados do tópico atualizado

    }

    @DeleteMapping("/{id}")// Indica que este método responde a requisições HTTP DELETE para a URL "/topicos/{id}"
    @ResponseStatus(HttpStatus.NO_CONTENT) // Define o status da resposta HTTP como NO_CONTENT
    fun deletarTopico(@PathVariable id: Long) { // Chama o método deletar() do serviço para excluir um tópico existente
        topicoService.deletar(id)// Retorna uma resposta HTTP NO_CONTENT para indicar que a operação foi bem-sucedida, mas sem conteúdo no corpo da resposta
    }
}

/*Resumindo, a classe TopicoController atua como um controlador Rest que
gerencia as requisições relacionadas aos tópicos do fórum. Ela recebe requisições HTTP,
valida os dados, chama os métodos apropriados na classe de serviço TopicoService
para realizar as operações de CRUD e retorna as respostas HTTP adequadas.*/