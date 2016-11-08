package com.stefanini.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Localinfracao;

public class LocalInfracaoService implements Serializable {
	
	@Inject
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;

	public void salvar(Localinfracao localInfracao) {
		em.persist(localInfracao);
	}

}
