package br.com.deveficiente.mercadolivre.mercadolivre.cadastroCategoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraCategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/categoria")
	@Transactional
	public String cria(@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria novaCategoria = request.toModel(manager);
		manager.persist(novaCategoria);
		return novaCategoria.toString();
	}
}
