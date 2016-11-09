package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.stefanini.model.Denuncia;
import com.stefanini.repository.DenunciaRepository;

@Stateless
public class DenunciaService {

	
	@Inject
  	private DenunciaRepository denunciaRepository;
	
	public List<Denuncia> listar() {
		return denunciaRepository.lista();
	}

	public void salvar(Denuncia denuncia) {
		denunciaRepository.incluir(denuncia);
	}

}
