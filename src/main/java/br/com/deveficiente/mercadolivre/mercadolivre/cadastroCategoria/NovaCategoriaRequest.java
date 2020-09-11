package br.com.deveficiente.mercadolivre.mercadolivre.cadastroCategoria;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import br.com.deveficiente.mercadolivre.mercadolivre.compartilhado.ExistId;
import br.com.deveficiente.mercadolivre.mercadolivre.compartilhado.UniqueValue;

public class NovaCategoriaRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	@Positive
	@ExistId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoriaMae;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdCategoriaMae(Long idCategoriaMae) {
		this.idCategoriaMae = idCategoriaMae;
	}

	@Override
	public String toString() {
		return "NovaCategoriaRequest [nome=" + nome + ", idCategoriaMae=" + idCategoriaMae + "]";
	}

	public Categoria toModel(EntityManager manager) {
		Categoria categoria = new Categoria(nome);
		
		if(idCategoriaMae != null) {
			Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
			Assert.notNull(categoriaMae, "O id da categoria mae precisa ser válido");
			categoria.setMae(categoriaMae);
		}
		return categoria;
	}
	
	
}
