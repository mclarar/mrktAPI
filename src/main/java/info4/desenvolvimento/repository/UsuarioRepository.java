package info4.desenvolvimento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import info4.desenvolvimento.model.UsuarioModel;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{

	public Optional<UsuarioModel> findByEmail(String email);
	
}
