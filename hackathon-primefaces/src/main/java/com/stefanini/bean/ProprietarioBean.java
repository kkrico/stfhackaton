package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.service.ProprietarioService;

@Named("proprietarioBean")
@SessionScoped
public class ProprietarioBean implements Serializable {

	private Proprietario proprietario = new Proprietario();
	private static final long serialVersionUID = 1L;
	@Inject
	private ProprietarioService proprietarioService;
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	public Collection<String> listar() {
		Collection<Proprietario>  props = this.proprietarioService.listar();
		
		Collection<String> res = new ArrayList<String>();
		for(Proprietario prop : props) {
			res.add(String.valueOf(prop.getCpfProprietario()));
		}
		
		return res;
	}
}
