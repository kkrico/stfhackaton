package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Telefones;
import com.stefanini.service.TelefoneService;

@Named("telefoneBean")
@SessionScoped
public class TelefoneBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Telefones telefone = new Telefones();
	private TelefoneService telefoneService;
	
	public Telefones getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefones telefone) {
		this.telefone = telefone;
	}
	
	public void salvar() {
		telefoneService.salvar(this.telefone);
		this.telefone = new Telefones();

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Atenção", "Inserido com sucesso"));
	}
}
