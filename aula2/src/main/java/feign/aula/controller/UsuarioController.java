package feign.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.aula.UsuarioFeign;
import feign.aula.model.Usuario;

@RestController
@RequestMapping
public class UsuarioController {

	
	@Autowired
	private UsuarioFeign usuarioFeign;
	
	@GetMapping("hello")
	public String teste() {
		return "Hello";
	}
	
    @GetMapping
    public ResponseEntity<ResponseEntity<List<Usuario>>> getTodos() {
    	return ResponseEntity.ok(usuarioFeign.getAll());   
    }
    
    @GetMapping("listar/body")
    public ResponseEntity<List<Usuario>> getTodosBody() {
    	return ResponseEntity.ok(usuarioFeign.getAll().getBody());   
    }
}