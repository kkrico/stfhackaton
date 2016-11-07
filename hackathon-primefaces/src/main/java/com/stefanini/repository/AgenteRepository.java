package com.stefanini.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Agente;

public class AgenteRepository {

	@Inject
	private EntityManager manager;
	
	public void incluir(Agente agente) {
		this.manager.persist(agente);
	}
}
