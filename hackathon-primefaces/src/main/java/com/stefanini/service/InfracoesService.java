package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;
import com.stefanini.repository.InfracoesRepository;

@Stateless
public class InfracoesService {
	
	@Inject
	private InfracoesRepository infracoesRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Infracoes infracoes){
		infracoesRepository.incluir(infracoes);
	}
	
	public Infracoes buscar(Integer idInfracao){
		return infracoesRepository.buscar(idInfracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Infracoes> listar(){
		return infracoesRepository.listaTodos();
	}
	
	public void excluir(Integer idInfracao){
		infracoesRepository.excluir(idInfracao);
	}

}
