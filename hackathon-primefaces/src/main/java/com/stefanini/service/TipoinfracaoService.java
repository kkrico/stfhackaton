package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.Tipoinfracao;
import com.stefanini.repository.TipoInfracaoRepository;

@Stateless
public class TipoinfracaoService {
	
	@Inject
	TipoInfracaoRepository tipoInfracaoRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Tipoinfracao tipoinfracao){
		tipoInfracaoRepository.incluir(tipoinfracao);
	}
	
	public Tipoinfracao buscar(Integer idTipoInfracao){
		return tipoInfracaoRepository.buscar(idTipoInfracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Tipoinfracao> listar(){
		return tipoInfracaoRepository.listaTodos();
	}
	
	public void excluir(Integer idTipoInfracao){
		tipoInfracaoRepository.excluir(idTipoInfracao);
	}

}
