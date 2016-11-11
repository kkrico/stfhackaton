package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Tipoinfracao;
import com.stefanini.service.TipoinfracaoService;
import com.stefanini.util.Mostrar;

@Named("tipoInfracaoMB")
@SessionScoped
public class TipoInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	Tipoinfracao tipoinfracao;

	private List<Tipoinfracao> tipoinfracoes;

	public TipoInfracaoBean() {
		this.tipoinfracao = new Tipoinfracao();
	}

	@Inject
	private TipoinfracaoService tipoinfracaoService;

	public void incluir() {
		tipoinfracaoService.incluir(tipoinfracao);
		this.tipoinfracao = new Tipoinfracao();
		Mostrar.MensagemSucesso("Atenção", "Cadastrado com sucesso");
	}

	// Gets e Sets

	public Tipoinfracao getTipoinfracao() {
		return tipoinfracao;
	}

	public void setTipoinfracao(Tipoinfracao tipoinfracao) {
		this.tipoinfracao = tipoinfracao;
	}

	public TipoinfracaoService getTipoinfracaoService() {
		return tipoinfracaoService;
	}

	public void setTipoinfracaoService(TipoinfracaoService tipoinfracaoService) {
		this.tipoinfracaoService = tipoinfracaoService;
	}

	public List<Tipoinfracao> getTipoinfracoes() {
		return tipoinfracaoService.listar();
	}

	public void setTipoinfracoes(List<Tipoinfracao> tipoinfracoes) {
		this.tipoinfracoes = tipoinfracoes;
	}

}
