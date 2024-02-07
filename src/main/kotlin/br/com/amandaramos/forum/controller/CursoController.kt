package br.com.amandaramos.forum.controller
//22 parte
import com.amandaramos.br.com.amandaramos.forum.model.Curso
import com.amandaramos.br.com.amandaramos.forum.service.CursoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// Define a classe CursoController como um controlador Rest
@RestController

// Define o caminho base para as requisições relacionadas a cursos
@RequestMapping("/cursos")

//Define a classe CursoController como um controlador Spring. Recebe uma instância de CursoService por
// meio de injeção de dependência no construtor.
class CursoController(private val cursoService: CursoService) {

    // Mapeia requisições GET para o endpoint "/cursos/{id}" e retorna um curso com o ID especificado
    @GetMapping("/{id}")

    // O parâmetro id é extraído do path da URL
    fun buscarCursoPorId(@PathVariable id: Long): ResponseEntity<Curso> {

        // Chama o método buscarPorId do serviço CursoService para buscar o curso pelo ID fornecido
        val curso = cursoService.buscarPorId(id)

        // Retorna uma resposta HTTP com o curso encontrado, se existir, no corpo da resposta
        return ResponseEntity.ok(curso)
    }



}

/*Resumo:
O objetivo da classe CursoController é fornecer uma interface HTTP para operações relacionadas aos cursos
dentro do sistema do fórum. Aqui está uma explicação mais detalhada do seu propósito:
Gerenciamento das Requisições HTTP: O controlador é responsável por receber e processar requisições HTTP
relacionadas aos cursos. Isso inclui operações como buscar cursos por ID, criar novos cursos, atualizar informações de cursos, entre outras.
Separação de Responsabilidades: O controlador atua como uma camada intermediária entre a camada de apresentação (como interfaces de usuário
ou clientes web/mobile) e a camada de serviço. Ele separa as responsabilidades de lidar com as requisições HTTP e a lógica de negócios subjacente.
Padronização das Rotas e Endpoints: A anotação @RequestMapping("/cursos") define um prefixo para todas as rotas relacionadas aos cursos.
Isso ajuda na organização e padronização das URLs dentro da aplicação.
Integração com o Serviço: A classe utiliza uma instância de CursoService para acessar as funcionalidades relacionadas aos cursos.
Isso é feito por meio da injeção de dependência no construtor. Assim, o controlador pode delegar tarefas específicas, como buscar
um curso por ID, para o serviço correspondente.
Tratamento de Respostas HTTP: O controlador retorna objetos ResponseEntity para
encapsular as respostas HTTP. Isso permite configurar o código de status, cabeçalhos e corpo da resposta de forma mais flexível,
dependendo do resultado da operação.
Em resumo, a classe CursoController funciona como um ponto de entrada para operações
relacionadas aos cursos, garantindo a interoperabilidade entre a interface de usuário
e a lógica de negócios, seguindo as práticas recomendadas de arquitetura de software
e design de APIs RESTful.*/