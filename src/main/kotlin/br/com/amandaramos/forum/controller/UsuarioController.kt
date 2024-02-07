package br.com.amandaramos.forum.controller
//21
import com.amandaramos.br.com.amandaramos.forum.model.Usuario
import com.amandaramos.br.com.amandaramos.forum.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    // Mapeia requisições GET para o endpoint "/usuarios/{id}" e retorna um usuário com o ID especificado
    @GetMapping("/{id}")

    // O parâmetro id é extraído do path da URL
    fun buscarUsuarioPorId(@PathVariable id: Long): ResponseEntity<Usuario> {

        // Chama o método buscarPorId do serviço UsuarioService para buscar o usuário pelo ID fornecido
        val usuario = usuarioService.buscarPorId(id)

        // Retorna uma resposta HTTP com o usuário encontrado, se existir, no corpo da resposta
        return ResponseEntity.ok(usuario)

    }

}