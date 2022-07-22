package info4.desenvolvimento.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info4.desenvolvimento.exception.UsuarioException;
import info4.desenvolvimento.model.UsuarioModel;
import info4.desenvolvimento.repository.UsuarioRepository;
import info4.desenvolvimento.security.UsuarioServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

	private final UsuarioRepository repository;
	private final PasswordEncoder encoder;

	public UsuarioControler(UsuarioRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	@Autowired
	UsuarioServiceImp usuarioService;

	@GetMapping("/listarUsuarios")
	public ResponseEntity<List<UsuarioModel>> listarUsiario() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/criarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UsuarioModel> criar(@RequestBody UsuarioModel usuario) {

		usuario.setSenha(encoder.encode(usuario.getSenha()));
		return ResponseEntity.ok(repository.save(usuario));
	}

	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String email, @RequestParam String senha) {

		Optional<UsuarioModel> optUsuario = repository.findByEmail(email);
		if (optUsuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}

		UsuarioModel usuario = optUsuario.get();
		Boolean valid = encoder.matches(senha, usuario.getSenha());

		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<UsuarioModel> Put(@PathVariable(value = "id") Integer id, @RequestBody UsuarioModel newUser) {
		Optional<UsuarioModel>oldUser=repository.findById(id);
		if(oldUser.isPresent()) {
			UsuarioModel usuarioModel=oldUser.get();
			usuarioModel.setNome(newUser.getNome());
			usuarioModel.setEmail(newUser.getEmail());
			usuarioModel.setSenha(encoder.encode(newUser.getSenha()));
			
			repository.save(usuarioModel);
			return new ResponseEntity<UsuarioModel>(usuarioModel, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) throws UsuarioException {
		repository.deleteById(id);
	}

}