package br.com.deveficiente.mercadolivre.mercadolivre.cadastroUsuario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CadastraUsuarioController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ProibeUsuarioComEmailDuplicadoValidator proibeUsuarioComEmailDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeUsuarioComEmailDuplicadoValidator);
	}
	
	@PostMapping("/usuario")
	@Transactional
	public String cria(@Valid @RequestBody NovoUsuarioRequest request) {
		Usuario novoUsuario = request.toModel();
		manager.persist(novoUsuario);
		return novoUsuario.toString();
	}
}
