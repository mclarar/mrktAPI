package info4.desenvolvimento.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import info4.desenvolvimento.data.UsuarioData;
import info4.desenvolvimento.model.UsuarioModel;
import info4.desenvolvimento.repository.UsuarioRepository;


@Service
@Component
public class UsuarioServiceImp implements UserDetailsService {

	private final UsuarioRepository repository;
	
	public UsuarioServiceImp(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> usuario =repository.findByEmail(username);
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException ("Usuário["+ username +"] não encontrado");
		}
		
		return new UsuarioData(usuario);
	}

	

	
}