package com.stefanini.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.service.VeiculoService;

@Named("veiculoBean")
public class VeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	VeiculoService veiculoService;

	public VeiculoService getVeiculoService() {
		return veiculoService;
	}

	public void setVeiculoService(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
}
