package br.com.amandaramos.forum.repository
//8 parte
import com.amandaramos.br.com.amandaramos.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}