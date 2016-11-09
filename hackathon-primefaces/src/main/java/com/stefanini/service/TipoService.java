package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.stefanini.model.Tipo;
import com.stefanini.repository.TipoRepository;

@Stateless
public class TipoService {

	@Inject
	private TipoRepository tipoRepository;
	
	public void salvar(Tipo tipo) {
		tipoRepository.salva(tipo);
	}

	public List<Tipo> listar() {
		return tipoRepository.lista();
	}

	public void excluir(Integer id) {
		tipoRepository.excluir(id);
	}

}
