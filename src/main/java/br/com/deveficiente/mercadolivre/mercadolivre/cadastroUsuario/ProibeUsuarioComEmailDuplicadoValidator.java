package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeUsuarioComEmailDuplicadoValidator implements Validator{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoUsuarioRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovoUsuarioRequest request = (NovoUsuarioRequest) target;
		
		Optional<Usuario> possivelEmail = usuarioRepository.findByEmail(request.getEmail());
		
		if(possivelEmail.isPresent()) {
			errors.rejectValue("email", null, "Já existe uma email no sistema ");
		}
	}

}
