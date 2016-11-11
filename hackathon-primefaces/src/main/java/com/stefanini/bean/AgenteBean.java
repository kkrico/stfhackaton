package com.stefanini.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import com.stefanini.util.Mostrar;

@Named("agenteBean")
@SessionScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Agente agente = new Agente();

	private List<Agente> agentes;

	@Inject
	private AgenteService agenteService;

	public void incluir() {
		if (agente.getIdAgente() == null) {
			agenteService.incluir(agente);
			Mostrar.MensagemSucesso("Atenção", "Cadastrado com Sucesso");
		} else {
			agenteService.atualizar(agente);
			Mostrar.MensagemSucesso("Atenção", "Alterado com Sucesso");
		}

		this.agente = new Agente();
	}

	public void excluir(Integer idAgente) {
		agenteService.excluir(idAgente);
	}

	public void carregar(Agente agente) throws IOException {
		this.agente = agenteService.buscar(agente.getIdAgente());
		System.out.println(agente.getIdAgente());
		FacesContext.getCurrentInstance().getExternalContext().redirect("alterarAgente.xhtml");
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
