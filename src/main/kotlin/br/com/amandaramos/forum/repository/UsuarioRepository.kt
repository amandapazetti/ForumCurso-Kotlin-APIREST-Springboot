package br.com.amandaramos.forum.repository
//9 parte
import com.amandaramos.br.com.amandaramos.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// Anotação indicando que esta interface é um componente gerenciado pelo Spring, responsável pela camada de acesso aos dados
@Repository
// Nenhuma implementação adicional é necessária, pois JpaRepository fornece métodos prontos para acesso aos dados, como salvar, buscar, atualizar e deletar
interface UsuarioRepository: JpaRepository<Usuario, Long> {
}