package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;
import com.stefanini.repository.AgenteRepository;

@Stateless
public class AgenteService {
	
	@Inject
	private AgenteRepository agenteRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Agente agente){
		agenteRepository.incluir(agente);
	}
	
	public Agente buscar(Integer idAgente){
		return agenteRepository.buscar(idAgente);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Agente> listar(){
		return agenteRepository.listaTodos();
	}
	
	public void excluir(Integer idAgente){
		agenteRepository.excluir(idAgente);
	}

	public void atualizar(Agente agente) {
		agenteRepository.atualizar(agente);
	}

}
