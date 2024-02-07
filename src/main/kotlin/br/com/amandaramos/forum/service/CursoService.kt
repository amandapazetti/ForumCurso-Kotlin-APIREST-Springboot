package com.amandaramos.br.com.amandaramos.forum.service
//- 10 parte
import br.com.amandaramos.forum.repository.CursoRepository
import com.amandaramos.br.com.amandaramos.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

// Anotação indicando que essa classe é um serviço gerenciado pelo Spring
@Service
class CursoService (private val cursoRepository: CursoRepository) {



    // Método para buscar um curso pelo ID
  fun buscarPorId(id: Long): Curso? {

        // Chama o método findById do CursoRepository para buscar o curso pelo ID
        // Se o curso existir, retorna-o; caso contrário, retorna null
      return cursoRepository.findById(id).orElse(null)

    }


}


/*Este serviço simplesmente delega a responsabilidade de buscar
um curso pelo ID para o CursoRepository. Se o curso for encontrado,
ele é retornado; caso contrário, retorna-se null.*/