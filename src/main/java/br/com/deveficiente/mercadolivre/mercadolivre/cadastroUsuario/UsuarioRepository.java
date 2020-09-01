package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Optional<Usuario> findByEmail(@Email String email);
}
