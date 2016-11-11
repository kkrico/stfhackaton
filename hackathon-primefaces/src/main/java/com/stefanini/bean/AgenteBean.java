package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;
import com.stefanini.service.AgenteService;
import com.stefanini.util.Mostrar;

@Named("agenteBean")
@SessionScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Agente agente;
	
	private List<Agente> agentes;

	public AgenteBean() {
		this.agente = new Agente();
	}

	@Inject
	private AgenteService agenteService;

	public void incluir() {
		agenteService.incluir(agente);
		this.agente = new Agente();
		Mostrar.MensagemSucesso("Atenção", "Cadastrado com Sucesso");
	}
	
	public void excluir(Integer idAgente) {
		agenteService.excluir(idAgente);
	}
	
	// Gets e Sets
	
	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public AgenteService getAgenteService() {
		return agenteService;
	}

	public void setAgenteService(AgenteService agenteService) {
		this.agenteService = agenteService;
	}

	public List<Agente> getAgentes() {
		return agenteService.listar();
	}

	public void setAgentes(List<Agente> agentes) {
		this.agentes = agentes;
	}
	
}
