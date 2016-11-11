package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Categoria;

public class CategoriaRepository {
	
	@Inject
	private EntityManager manager;
	
	public void incluir(Categoria categoria) {
		this.manager.persist(categoria);
	}
	
	public List<Categoria> listaTodos() {
		Query query = manager.createQuery("select c from Categoria c");
		
		 List<Categoria> lista = query.getResultList();
		return lista;
	}

}
