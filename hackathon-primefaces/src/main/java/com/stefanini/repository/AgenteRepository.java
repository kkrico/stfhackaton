package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;

public class AgenteRepository {

	@Inject
	private EntityManager manager;
	
	public void incluir(Agente agente) {
		this.manager.persist(agente);
	}
	
	public Agente buscar(Integer idAgente){
		return this.manager.find(Agente.class, idAgente);
	}
	
	public List<Agente> listaTodos() {
		Query query = manager.createQuery("select a from Agente a");
		
		 List<Agente> lista = query.getResultList();
		return lista;
	}
	
	public void excluir(Integer idAgente) {
		this.manager.remove(manager.find(Agente.class, idAgente));
	}

	public void atualizar(Agente agente) {
		this.manager.merge(agente);
	}
}
