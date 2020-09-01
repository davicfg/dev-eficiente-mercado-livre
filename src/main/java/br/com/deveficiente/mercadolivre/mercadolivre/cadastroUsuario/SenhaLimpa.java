package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

/**
 * Representa uma senha limpa no sistema
 * 
 * Comentário extra: usamos essa solução para não ocorrer de no futuro alguma pessoa sem querer passar
 * uma senha já encriptada.
 *  
 * @author davicfg
 *
 */
public class SenhaLimpa {

	private String senha;

	public SenhaLimpa(@NotBlank @Length(min = 6) String senha) {
		Assert.hasLength(senha, "senha não pode ser em branco");
		Assert.isTrue(senha.length()>=6, "senha tem que ter no mínimo 6 caracteres");
		this.senha = senha;
	}

	public String hash() {
		return new BCryptPasswordEncoder().encode(senha);
	}

}
