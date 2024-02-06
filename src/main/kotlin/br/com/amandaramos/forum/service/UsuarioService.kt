package com.amandaramos.br.com.amandaramos.forum.service
//12 parte
import br.com.amandaramos.forum.repository.UsuarioRepository
import com.amandaramos.br.com.amandaramos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (private val usuarioRepository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario? {
        return usuarioRepository.findById(id).orElse(null)
        }


    }


