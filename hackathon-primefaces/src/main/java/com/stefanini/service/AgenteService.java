package com.stefanini.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.repository.AgenteRepository;

@Stateless
public class AgenteService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private AgenteRepository agenteRepository;

	public Collection<Agente> todosOsAgentes() {
		
		return agenteRepository.todos();
	}

	public void salvar(Agente agente) {
		
		agenteRepository.salvar(agente);
	}

	public void atualizar(Agente agente) {
	
		agenteRepository.atualizar(agente);
		
	}

	public void remover(Integer id) {
		agenteRepository.remover(id);
		
	}
}
