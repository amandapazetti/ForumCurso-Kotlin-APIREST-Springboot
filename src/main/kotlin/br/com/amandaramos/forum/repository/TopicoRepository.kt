package br.com.amandaramos.forum.repository
//8 parte
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
//Neste trecho de código, temos uma interface chamada TopicoRepository,
// que é responsável por definir a camada de acesso aos dados para a entidade Topico
interface TopicoRepository: JpaRepository<Topico, Long> {
}