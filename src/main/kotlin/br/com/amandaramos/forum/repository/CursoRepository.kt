package br.com.amandaramos.forum.repository
//7 parte
import com.amandaramos.br.com.amandaramos.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository: JpaRepository<Curso, Long> {


}