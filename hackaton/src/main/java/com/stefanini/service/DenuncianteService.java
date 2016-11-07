package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.stefanini.model.Denunciante;
import com.stefanini.repository.DenuncianteRepository;

@Stateless
public class DenuncianteService {

	@Inject
	private DenuncianteRepository denuncianteRepository;
	
	public void salvar(Denunciante denunciante) {
		denuncianteRepository.salva(denunciante);
	}

	public List<Denunciante> listar() {
		return denuncianteRepository.lista();
	}

	public void excluir(Integer id) {
		denuncianteRepository.excluir(id);
	}

	public List<Denunciante> consultar(Denunciante denunciante) {
		return denuncianteRepository.consultar(denunciante);
	}

}
