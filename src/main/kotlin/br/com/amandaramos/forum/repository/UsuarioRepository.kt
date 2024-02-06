package br.com.amandaramos.forum.repository
//9 parte
import com.amandaramos.br.com.amandaramos.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
}