package com.stefanini.service;

import java.io.Serializable;

import com.stefanini.model.Telefones;
import com.stefanini.repository.TelefoneRepository;

public class TelefoneService implements Serializable {

	private static final long serialVersionUID = 1L;
	private TelefoneRepository telefoneRepository;

	public void salvar(Telefones telefone) {
		
		telefoneRepository.salvar(telefone);
	}
}
