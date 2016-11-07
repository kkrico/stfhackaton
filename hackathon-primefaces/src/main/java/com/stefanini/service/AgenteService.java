package com.stefanini.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.stefanini.repository.AgenteRepository;

@Stateless
public class AgenteService {
	
	@Inject
	private AgenteRepository agenteRepository;

}
