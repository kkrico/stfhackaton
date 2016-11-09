package com.stefanini.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Tipotelefone;

public class TipoTelefoneService implements Serializable {

	@Inject
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;

	public Collection<Tipotelefone> listar() {
		Query q = em.createQuery("SELECT t FROM Tipotelefone t");
		return (Collection<Tipotelefone>) q.getResultList();
	}

}
