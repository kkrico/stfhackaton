package com.stefanini.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Telefones;

public class TelefoneRepository {
	
	@Inject
	private EntityManager em;

	public void salvar(Telefones telefone) {
		
		em.persist(telefone);
	}
}
