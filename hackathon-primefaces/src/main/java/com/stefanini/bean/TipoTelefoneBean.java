package com.stefanini.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Tipotelefone;
import com.stefanini.service.TipoTelefoneService;

@Named("tipoTelefoneBean")
@SessionScoped
public class TipoTelefoneBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoTelefoneService tipotelefoneservice;
	
	public Collection<Tipotelefone> listar() {
		return this.tipotelefoneservice.listar();
	}
}
