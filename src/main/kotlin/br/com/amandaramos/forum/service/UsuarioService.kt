package com.amandaramos.br.com.amandaramos.forum.service

import com.amandaramos.br.com.amandaramos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (var usuarios: List<Usuario>) {

        init {
            val usuario = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "ana@email.com.br"
            )
            usuarios = Arrays.asList(usuario)
        }

        fun buscarPorId(id: Long): Usuario {
            return usuarios.stream().filter { c ->
                c.id == id
            }.findFirst().get()
        }


    }

