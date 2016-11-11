package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Tipotelefone;

public class TipotelefoneRepository {
	
	@Inject
	private EntityManager manager;
	
	public void incluir(Tipotelefone tipotelefone){
		this.manager.persist(tipotelefone);
	}
	
	public List<Tipotelefone> listaTodos() {
		Query query = manager.createQuery("select t from Tipotelefone t");
		
		 List<Tipotelefone> lista = query.getResultList();
		return lista;
	}

}
