package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @Email @NotBlank String email;
	private @NotBlank @Length(min = 6) String senha;

	public Usuario(@Email @NotBlank String email, @NotBlank @Length(min = 6) String senha) {
		Assert.isTrue(StringUtils.hasLength(email), "email não pode ser em branco");
		Assert.isTrue(StringUtils.hasLength(senha), "senha não pode ser em branco");
		Assert.isTrue(senha.length() >= 6, "senha tem que ter pelo menos 6 carcteres");
		this.email = email;
		this.senha = new BCryptPasswordEncoder().encode(senha);

	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}

}
