package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.Localinfracao;
import com.stefanini.repository.LocalInfracaoRepository;

@Stateless
public class LocalInfracaoService {
	
	@Inject
	LocalInfracaoRepository localInfracaoRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Localinfracao localinfracao){
		localInfracaoRepository.incluir(localinfracao);
	}
	
	public Localinfracao buscar(Integer idLocalInfracao){
		return localInfracaoRepository.buscar(idLocalInfracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Localinfracao> listar(){
		return localInfracaoRepository.listaTodos();
	}
	
	public void excluir(Integer idLocalInfracao){
		localInfracaoRepository.excluir(idLocalInfracao);
	}

}
