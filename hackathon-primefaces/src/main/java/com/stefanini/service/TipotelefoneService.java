package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Tipotelefone;
import com.stefanini.repository.TipotelefoneRepository;

@Stateless
public class TipotelefoneService {
	
	@Inject
	private TipotelefoneRepository tipotelefoneRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Tipotelefone tipotelefone){
		tipotelefoneRepository.incluir(tipotelefone);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Tipotelefone> listar(){
		return tipotelefoneRepository.listaTodos();
	}

}
