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

	public static Collection<Agente> todosOsAgentes() {
		
		Agente a1 = new Agente();
		a1.setNome("Agente 01");
		a1.setTempoServico(10);
		a1.setDtContratacao(new Date("29/09/1990"));
		
		Agente a2 = new Agente();
		a2.setNome("Agente 01");
		a2.setTempoServico(10);
		a2.setDtContratacao(new Date("29/09/1990"));
		
		Collection<Agente> resultado = new ArrayList<Agente>();
		resultado.add(a1);
		resultado.add(a2);
		
		return resultado;
	}

	public void salvar(Agente agente) {
		
		agenteRepository.salvar(agente);
	}
}
