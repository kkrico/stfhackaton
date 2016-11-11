package com.stefanini.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import com.stefanini.model.Veiculos;
import com.stefanini.repository.VeiculoRepository;

public class VeiculoService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private VeiculoRepository veiculoRepository;

	public Collection<Veiculos> listarTodos() {
		return this.veiculoRepository.listar();
	}

	public Veiculos buscar(Integer placaVeiculo) {
		// TODO Auto-generated method stub
		return this.veiculoRepository.buscar(placaVeiculo);
	}

	public void incluir(Veiculos veiculos) {
		// TODO Auto-generated method stub
		this.veiculoRepository.incluir(veiculos);
	}
}
