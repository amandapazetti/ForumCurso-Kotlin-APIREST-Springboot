package com.amandaramos.br.com.amandaramos.forum.service
//12 parte
import br.com.amandaramos.forum.repository.UsuarioRepository
import com.amandaramos.br.com.amandaramos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

// Anotação indicando que esta classe é um serviço gerenciado pelo Spring
@Service
class UsuarioService (private val usuarioRepository: UsuarioRepository) {

    // Método para buscar um usuário pelo ID
    fun buscarPorId(id: Long): Usuario? {
        // Chama o método findById do UsuarioRepository para buscar o usuário pelo ID
        // Se o usuário existir, retorna-o; caso contrário, retorna null

        return usuarioRepository.findById(id).orElse(null)
        }


    }


