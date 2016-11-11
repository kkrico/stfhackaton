package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Localinfracao;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.util.Mostrar;

@Named("localInfracaooMB")
@SessionScoped
public class LocalInfracaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Localinfracao localinfracao;
	
	private List<Localinfracao> localinfracoes;
	
	public LocalInfracaoBean(){
		this.localinfracao = new Localinfracao();
	}
	
	@Inject
	private LocalInfracaoService localInfracaoService;
	
	public void incluir(){
		localInfracaoService.incluir(localinfracao);
		this.localinfracao = new Localinfracao();
		Mostrar.MensagemSucesso("Atenção", "Cadastrado com Sucesso");
	}
	
	// Gets e Sets

	public Localinfracao getLocalinfracao() {
		return localinfracao;
	}

	public void setLocalinfracao(Localinfracao localinfracao) {
		this.localinfracao = localinfracao;
	}

	public LocalInfracaoService getLocalInfracaoService() {
		return localInfracaoService;
	}

	public void setLocalInfracaoService(LocalInfracaoService localInfracaoService) {
		this.localInfracaoService = localInfracaoService;
	}

	public List<Localinfracao> getLocalinfracoes() {
		return localInfracaoService.listar();
	}

	public void setLocalinfracoes(List<Localinfracao> localinfracoes) {
		this.localinfracoes = localinfracoes;
	}
	
	

}
