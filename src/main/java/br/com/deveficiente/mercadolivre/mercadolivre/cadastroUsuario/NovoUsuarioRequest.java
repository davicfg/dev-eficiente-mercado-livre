package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.deveficiente.mercadolivre.mercadolivre.compartilhado.UniqueValue;
import net.bytebuddy.asm.Advice.Exit;

public class NovoUsuarioRequest {

	@Email
	@NotBlank
//	@UniqueValue(domainClass = Usuario.class, fieldName = "email")
	private String email;
	@NotBlank
	@Length(min = 6)
	private String senha;

	/**
	 * 
	 * @param email string formato de email
	 * @param senha string em texto limpo
	 */
	public NovoUsuarioRequest(@NotBlank String email, @NotBlank @Length(min = 6) String senha) {
		this.email = email;
		this.senha = senha;

	}

	public String getEmail() {
		return email;
	}

	// A senha ficou nesse toString para fins de estudo
	@Override
	public String toString() {
		return "NovoUsuarioRequest [email=" + email + ", senha=" + senha + "]";
	}

	public Usuario toModel() {
		return new Usuario(email, new SenhaLimpa(senha));
	}

}
