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

    @GetMapping("/{id}")
    fun buscarUsuarioPorId(@PathVariable id: Long): ResponseEntity<Usuario> {
        val usuario = usuarioService.buscarPorId(id)
        return ResponseEntity.ok(usuario)

    }

}