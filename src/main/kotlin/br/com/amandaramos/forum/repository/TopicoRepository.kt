package br.com.amandaramos.forum.repository
//8 parte
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository: JpaRepository<Topico, Long> {
}