package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Agente;
import com.stefanini.model.Tipoinfracao;

public class TipoInfracaoRepository {
	
	@Inject
	private EntityManager manager;
	
	public void incluir(Tipoinfracao tipoinfracao) {
		this.manager.persist(tipoinfracao);
	}
	
	public Tipoinfracao buscar(Integer idTipoInfracao){
		return this.manager.find(Tipoinfracao.class, idTipoInfracao);
	}
	
	public List<Tipoinfracao> listaTodos() {
		Query query = manager.createQuery("select t from Tipoinfracao t");
		
		 List<Tipoinfracao> lista = query.getResultList();
		return lista;
	}
	
	public void excluir(Integer idTipoInfracao) {
		this.manager.remove(manager.find(Tipoinfracao.class, idTipoInfracao));
	}
}

