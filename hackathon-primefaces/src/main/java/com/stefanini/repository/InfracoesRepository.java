package com.stefanini.repository;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;

@Dependent
public class InfracoesRepository {
	
	@Inject
	private EntityManager manager;
	
	public void incluir(Infracoes infracoes) {
		this.manager.persist(infracoes);
	}
	
	public Infracoes buscar(Integer idInfracao){
		return this.manager.find(Infracoes.class, idInfracao);
	}
	
	public List<Infracoes> listaTodos() {
		Query query = manager.createQuery("select i from Infracoes i");
		
		 List<Infracoes> lista = query.getResultList();
		return lista;
	}
	
	public void excluir(Integer idInfracao) {
		this.manager.remove(manager.find(Infracoes.class, idInfracao));
	}

}
