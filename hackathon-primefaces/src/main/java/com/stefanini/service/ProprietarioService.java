package com.stefanini.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.repository.ProprietarioRepository;

public class ProprietarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ProprietarioRepository proprietarioRepository;
	
	public Proprietario buscar(int cpf) {

		return this.proprietarioRepository.Buscar(cpf);
	}
	
	public Collection<Proprietario> listar() {
		return this.proprietarioRepository.listar();
	}
}
