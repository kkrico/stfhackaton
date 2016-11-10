package com.stefanini.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Agente;

public class AgenteRepository {

	@Inject
	private EntityManager manager;
	
	public void salvar(Agente agente) {
		this.manager.persist(agente);
	}

	public Collection<Agente> todos() {
		// TODO Auto-generated method stub
		Query q = manager.createQuery("SELECT A FROM Agente A");
		return (Collection<Agente>)q.getResultList();
	}

	public void atualizar(Agente agente) {
		this.manager.merge(agente);
	}

	public void remover(Integer id) {
		
		this.manager.remove(manager.find(Agente.class, id));
	}
}
