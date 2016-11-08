package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Localinfracao;
import com.stefanini.service.LocalInfracaoService;

@Named("localInfracaoBean")
@SessionScoped
public class LocalInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Localinfracao localInfracao;
	
	public LocalInfracaoBean() {
		this.localInfracao = new Localinfracao();
	}
	
	@Inject 
	private LocalInfracaoService localService;
	
	public Localinfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(Localinfracao localInfracao) {
		this.localInfracao = localInfracao;
	}
	
	public void salvar() {
		localService.salvar(this.localInfracao);
		this.localInfracao = new Localinfracao();
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Atenção", "Inserido com sucesso"));
	}
}
