package com.stefanini.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Proprietario;

public class ProprietarioRepository {

	@Inject
	private EntityManager manager;
	
	public Proprietario Buscar(int id) {
		return manager.find(Proprietario.class, id);
	}

	public Collection<Proprietario> listar() {
		// TODO Auto-generated method stub
		Query q = manager.createQuery("SELECT p FROM Proprietario p");
		return (Collection<Proprietario>) q.getResultList();
	}
}
