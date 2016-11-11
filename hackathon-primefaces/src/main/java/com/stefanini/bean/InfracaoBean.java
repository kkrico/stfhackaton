package com.stefanini.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracoesService;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.service.TipoinfracaoService;
import com.stefanini.service.VeiculoService;
import com.stefanini.util.Mostrar;

@Named("infracaoMB")
@RequestScoped
public class InfracaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Infracoes infracoe;
	private Integer idTipoInfracao;
	private Integer idLocalInfracao;
	private Integer idAgente;
	private Integer placaVeiculo;
	
	private List<Infracoes> infracoes;
	
	public InfracaoBean() {
		this.infracoe = new Infracoes();
	}
	
	@Inject
	InfracoesService infracoesService;
	@Inject
	TipoinfracaoService tipoInfracaoService;
	@Inject
	AgenteService agenteService;
	@Inject
	LocalInfracaoService localInfracaoService;
	@Inject
	private
	VeiculoService veiculoService;
	
	
	public void incluir() {
		this.infracoe.setAgente(agenteService.buscar(idAgente));
		this.infracoe.setLocalInfracao(localInfracaoService.buscar(idLocalInfracao));
		this.infracoe.setTipoInfracao(tipoInfracaoService.buscar(idTipoInfracao));
		this.infracoe.setVeiculo(getVeiculoService().buscar(placaVeiculo));
		
		infracoesService.incluir(infracoe);
		NovaInfracoe();
		
		Mostrar.MensagemSucesso("Atenção", "Inserido com sucesso");
	}

	private void NovaInfracoe() {
		this.infracoe = null;
		this.infracoe = new Infracoes();
	}

	public void excluir(Integer idInfracao) {
		infracoesService.excluir(idInfracao);
	}
	
	 public String chamar(){
		 return "/pages/Infracao.xhtml";
	 }
	
	// Gets e Sets

	public Infracoes getInfracoe() {
		return infracoe;
	}

	public void setInfracoe(Infracoes infracoe) {
		this.infracoe = infracoe;
	}

	public List<Infracoes> getInfracoes() {
		return infracoesService.listar();
	}

	public void setInfracoes(List<Infracoes> infracoes) {
		this.infracoes = infracoes;
	}

	public InfracoesService getInfracoesService() {
		return infracoesService;
	}

	public void setInfracoesService(InfracoesService infracoesService) {
		this.infracoesService = infracoesService;
	}

	public Integer getIdTipoInfracao() {
		return idTipoInfracao;
	}

	public void setIdTipoInfracao(Integer idTipoInfracao) {
		this.idTipoInfracao = idTipoInfracao;
	}

	public Integer getIdLocalInfracao() {
		return idLocalInfracao;
	}

	public void setIdLocalInfracao(Integer idLocalInfracao) {
		this.idLocalInfracao = idLocalInfracao;
	}

	public Integer getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}

	public VeiculoService getVeiculoService() {
		return veiculoService;
	}

	public void setVeiculoService(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

}
