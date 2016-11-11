package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.service.ProprietarioService;

@Named("proprietarioMB")
@SessionScoped
public class ProprietarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Proprietario proprietario;
	
	private List<Proprietario> proprietarios;
	
	public ProprietarioBean() {
		this.proprietario = new Proprietario();
	}
	
	@Inject
	private ProprietarioService proprietarioService;
	
	public String incluir(){
		proprietarioService.incluir(proprietario);
		this.proprietario = new Proprietario();
		return "pages/sucessoProprietario.faces?faces-redirect=true";
	}
	
	public String carregar(Proprietario proprietario){
		this.proprietario = proprietarioService.buscar(proprietario.getCpfProprietario());
		return "/pages/cadastroTelefones.xhtml";
	}
	
	public void excluir(Integer cpfProprietario) {
		proprietarioService.excluir(cpfProprietario);
	}
	
	// Gets e Sets
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public ProprietarioService getProprietarioService() {
		return proprietarioService;
	}

	public void setProprietarioService(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	public List<Proprietario> getProprietarios() {
		return proprietarioService.listar(proprietario);
	}

	public void setProprietarios(List<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
	}


}
