package com.amandaramos.br.com.amandaramos.forum.mapper
//14 parte
import com.amandaramos.br.com.amandaramos.forum.dto.NovoTopicoFormDTO
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import com.amandaramos.br.com.amandaramos.forum.service.CursoService
import com.amandaramos.br.com.amandaramos.forum.service.UsuarioService
import org.springframework.stereotype.Component

//Uma anotação do Spring que marca essa classe como um componente gerenciado pelo contêiner de injeção de dependência.
@Component
class TopicoFormMapper (
    //Declara uma propriedade privada cursoService do tipo CursoService.
    private val cursoService: CursoService,
    //Declara uma propriedade privada usuarioService do tipo UsuarioService.
    private val usuarioService: UsuarioService

//Indica que esta classe implementa a interface Mapper, onde NovoTopicoForm é o tipo de entrada e Topico é o tipo de saída.
): Mapper<NovoTopicoFormDTO, Topico> {

    //Topico: Implementa o método map da interface Mapper, onde t é um objeto do tipo NovoTopicoForm.
      override fun map(t: NovoTopicoFormDTO): Topico {

       //Chama o método buscarPorId do cursoService para encontrar o curso com o ID especificado em t.idCurso.
          val curso = cursoService.buscarPorId(t.idCurso)

       //Chama o método buscarPorId do usuarioService para encontrar o usuário com o ID especificado em t.idAutor.
        val autor = usuarioService.buscarPorId(t.idAutor)

       //Retorna um novo objeto Topico, utilizando os dados fornecidos em t.
        return Topico(
        // Define o título do tópico como o título fornecido em t.
            titulo = t.titulo,

         //Define a mensagem do tópico como a mensagem fornecida em t.
            mensagem = t.mensagem,

            //Define o curso do tópico, verificando se o curso retornado não é nulo, caso contrário, lança uma exceção com a mensagem "Curso não encontrado".
            curso = requireNotNull(curso) { "Curso não encontrado" },

          //Define o autor do tópico, verificando se o autor retornado não é nulo, caso contrário, lança uma exceção com a mensagem "Autor não encontrado".
            autor = requireNotNull(autor) { "Autor não encontrado" }
        )
    }
}


/*Essa classe realiza o mapeamento de um objeto NovoTopicoForm para um objeto Topico, usando serviços (cursoService e usuarioService) para buscar o curso e o
autor associados aos IDs fornecidos no objeto NovoTopicoForm.*/