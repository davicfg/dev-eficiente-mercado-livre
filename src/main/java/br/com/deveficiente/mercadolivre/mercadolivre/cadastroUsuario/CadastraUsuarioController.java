package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CadastraUsuarioController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/usuario")
	@Transactional
	public String cria(@Valid @RequestBody NovoUsuarioRequest request) {
		Usuario novoUsuario = request.toModel();
		manager.persist(novoUsuario);
		return novoUsuario.toString();
	}
}
