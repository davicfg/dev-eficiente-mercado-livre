package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class NovoUsuarioRequest {
	
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Length(min = 6)
	private String senha;

	public NovoUsuarioRequest(@NotBlank String email, @NotBlank @Length(min = 6) String senha) {
		this.email = email;
		this.senha = senha;
	}

	//A senha ficou nesse toString para fins de estudo
	
	@Override
	public String toString() {
		return "NovoUsuarioRequest [email=" + email + ", senha=" + senha + "]";
	}

	public Usuario toModel() {
		return new Usuario(email, senha);
	}
	
}
