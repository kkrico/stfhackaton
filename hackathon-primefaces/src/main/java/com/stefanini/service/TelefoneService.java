package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefones;
import com.stefanini.model.Tipotelefone;
import com.stefanini.repository.TelefonesRepository;

@Stateless
public class TelefoneService {
	
	@Inject
	private TelefonesRepository telefonesRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Telefones telefones){
		telefonesRepository.incluir(telefones);
	}

	public Tipotelefone buscar(Integer idTipoTelefone) {
		// TODO Auto-generated method stub
		return telefonesRepository.buscar(idTipoTelefone);
	}

}
