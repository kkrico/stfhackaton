package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Localinfracao;
import com.stefanini.service.LocalInfracaoService;

@Named("localInfracaoBean")
@SessionScoped
public class LocalInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Localinfracao localInfracao;
	@Inject 
	private LocalInfracaoService localInfracaoService;
	
	public Localinfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(Localinfracao localInfracao) {
		this.localInfracao = localInfracao;
	}
	
	public void salvar() {
		
		Loca
		
	}
}
