package com.amandaramos.br.com.amandaramos.forum.service
//- 10 parte
import br.com.amandaramos.forum.repository.CursoRepository
import com.amandaramos.br.com.amandaramos.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

// Anotação indicando que essa classe é um serviço gerenciado pelo Spring
@Service
class CursoService (private val cursoRepository: CursoRepository) {



  fun buscarPorId(id: Long): Curso? {
      return cursoRepository.findById(id).orElse(null)

    }


}