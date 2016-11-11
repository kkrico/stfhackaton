package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Tipotelefone;
import com.stefanini.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService {
	
	@Inject
	private ProprietarioRepository proprietarioRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Proprietario proprietario){
		proprietarioRepository.incluir(proprietario);
	}
	
	public Proprietario buscar(Integer cpfProprietario){
		return proprietarioRepository.buscar(cpfProprietario);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Proprietario> listar(){
		return proprietarioRepository.listaTodos();
	}
	
	public void excluir(Integer cpfProprietario){
		proprietarioRepository.excluir(cpfProprietario);
	}

}
