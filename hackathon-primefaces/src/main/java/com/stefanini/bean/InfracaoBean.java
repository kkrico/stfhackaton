package com.stefanini.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;
import com.stefanini.model.Localinfracao;
import com.stefanini.model.Tipoinfracao;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracoesService;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.service.TipoinfracaoService;
import com.stefanini.service.VeiculoService;
import com.stefanini.util.Mostrar;

@Named("infracaoMB")
@RequestScoped
public class InfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Infracoes infracoe;
	private Integer idTipoInfracao;
	private Integer idLocalInfracao;
	private Integer idAgente;
	private Integer placaVeiculo;
	private Double latitude = null;
	private Double longitude = null;

	private Collection<Agente> agentes;
	private Collection<Localinfracao> localInfracoes;
	private Collection<Tipoinfracao> tipoInfracoes;

	@PostConstruct
	public void GerarListas() {
		this.setAgentes(agenteService.listar());
		this.setLocalInfracoes(localInfracaoService.listar());
		this.setTipoInfracoes(tipoInfracaoService.listar());
	}

	public Integer getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(Integer placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	private List<Infracoes> infracoes;

	public InfracaoBean() {
		this.infracoe = new Infracoes();
	}

	@Inject
	Infracoes infracao;
	@Inject
	InfracoesService infracoesService;
	@Inject
	TipoinfracaoService tipoInfracaoService;
	@Inject
	AgenteService agenteService;
	@Inject
	LocalInfracaoService localInfracaoService;
	@Inject
	VeiculoService veiculoService;

	public void incluir() {
		this.infracoe.setAgente(buscarAgente(idAgente));
		this.infracoe.setLocalInfracao(buscarLocal(idLocalInfracao));
		this.infracoe.setTipoInfracao(buscarTipoInfracao(idTipoInfracao));

		infracoesService.incluir(infracoe);
		NovaInfracoe();

		Mostrar.MensagemSucesso("Atenção", "Inserido com sucesso");
	}

	private Tipoinfracao buscarTipoInfracao(Integer idTipoInfracao2) {

		for (Tipoinfracao t : this.tipoInfracoes) {
			if (idTipoInfracao2 == t.getIdTipoInfracao()) {
				return t;
			}
		}
		return null;
	}

	private Localinfracao buscarLocal(Integer idLocalInfracao2) {
		// TODO Auto-generated method stub
		for (Localinfracao l : this.getLocalInfracoes()) {
			if (idLocalInfracao2 == l.getIdLocalInfracao()) {
				return l;
			}
		}

		return null;
	}

	private Agente buscarAgente(Integer idAgente) {

		for (Agente a : this.getAgentes()) {
			if (idAgente == a.getIdAgente()) {
				return a;
			}
		}
		return null;
	}

	public Collection<Agente> todosOsAgentes() {
		return this.agentes;
	}

	public Collection<Localinfracao> todosOsLocaisInfracao() {
		return this.localInfracoes;
	}

	public Collection<Tipoinfracao> todosOsTipoInfracao() {
		return this.tipoInfracoes;
	}

	private void NovaInfracoe() {
		this.infracoe = null;
		this.infracoe = new Infracoes();
	}

	public void excluir(Integer idInfracao) {
		infracoesService.excluir(idInfracao);
	}

	public void carregar(Infracoes infracao) throws IOException {
		this.infracao = infracoesService.buscar(infracao.getId());
			
		this.latitude = infracao.getLocalInfracao().getLatitude();
		this.longitude = infracao.getLocalInfracao().getLongitude();
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

	public Collection<Agente> getAgentes() {
		return agentes;
	}

	public void setAgentes(Collection<Agente> agentes) {
		this.agentes = agentes;
	}

	public Collection<Localinfracao> getLocalInfracoes() {
		return localInfracoes;
	}

	public void setLocalInfracoes(Collection<Localinfracao> localInfracoes) {
		this.localInfracoes = localInfracoes;
	}

	public Collection<Tipoinfracao> getTipoInfracoes() {
		return tipoInfracoes;
	}

	public void setTipoInfracoes(Collection<Tipoinfracao> tipoInfracoes) {
		this.tipoInfracoes = tipoInfracoes;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
