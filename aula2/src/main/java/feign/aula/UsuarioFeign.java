package feign.aula;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import feign.aula.model.Usuario;

@FeignClient(name="app1", url = "http://localhost:5001/usuario")
public interface UsuarioFeign {

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll();
}
