package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Agente;
import com.stefanini.model.Localinfracao;

public class LocalInfracaoRepository {
	
	@Inject
	private EntityManager manager;
	
	public void incluir(Localinfracao localinfracao) {
		this.manager.persist(localinfracao);
	}
	
	public Localinfracao buscar(Integer idLocalInfracao){
		return this.manager.find(Localinfracao.class, idLocalInfracao);
	}
	
	public List<Localinfracao> listaTodos() {
		Query query = manager.createQuery("select l from Localinfracao l");
		
		 List<Localinfracao> lista = query.getResultList();
		return lista;
	}
	
	public void excluir(Integer idLocalInfracao) {
		this.manager.remove(manager.find(Localinfracao.class, idLocalInfracao));
	}

}
