package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Modelo;
import com.stefanini.model.Tipotelefone;
import com.stefanini.repository.ModeloRepository;

@Stateless
public class ModeloService {
	
	@Inject
	ModeloRepository modeloRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Modelo modelo){
		modeloRepository.incluir(modelo);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Modelo> listar(Modelo modelo){
		return modeloRepository.listaTodos();
	}

	public Modelo buscar(Integer idModelo) {
		// TODO Auto-generated method stub
		return modeloRepository.buscar(idModelo);
	}

}
