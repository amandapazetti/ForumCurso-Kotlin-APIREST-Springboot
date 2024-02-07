package br.com.amandaramos.forum.repository
//7 parte
import com.amandaramos.br.com.amandaramos.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
/*Neste trecho de código, temos uma interface chamada CursoRepository,
que é responsável por definir a camada de acesso aos dados para a entidade Curso*/
interface CursoRepository: JpaRepository<Curso, Long> {


}