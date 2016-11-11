package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Modelo;
import com.stefanini.model.Tipotelefone;

public class ModeloRepository {
	
	@Inject
	private EntityManager manager;
	
	public void incluir(Modelo modelo) {
		this.manager.persist(modelo);
	}
	
	public List<Modelo> listaTodos() {
		Query query = manager.createQuery("select m from Modelo m");
		
		 List<Modelo> lista = query.getResultList();
		return lista;
	}


}
