package br.com.amandaramos.forum.controller
//22 parte
import com.amandaramos.br.com.amandaramos.forum.model.Curso
import com.amandaramos.br.com.amandaramos.forum.service.CursoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cursos")
class CursoController(private val cursoService: CursoService) {

    @GetMapping("/{id}")
    fun buscarCursoPorId(@PathVariable id: Long): ResponseEntity<Curso> {
        val curso = cursoService.buscarPorId(id)
        return ResponseEntity.ok(curso)
    }



}