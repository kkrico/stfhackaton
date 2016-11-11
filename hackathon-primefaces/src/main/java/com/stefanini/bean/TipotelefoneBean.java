package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Tipotelefone;
import com.stefanini.service.TipotelefoneService;
import com.stefanini.util.Mostrar;

@Named("tipotelefoneMB")
@RequestScoped
public class TipotelefoneBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Tipotelefone tipotelefone;
	
	private List<Tipotelefone> tipotelefones;
	
	public TipotelefoneBean(){
		this.tipotelefone = new Tipotelefone();
	}
	
	@Inject
	private TipotelefoneService tipotelefoneService;
	
	public void incluir(){
		tipotelefoneService.incluir(tipotelefone);
		this.tipotelefone = new Tipotelefone();
		Mostrar.MensagemSucesso("Sucesso", "Inserido com sucesso");
	}
	
	
	// Get e Sets
	

	public Tipotelefone getTipotelefone() {
		return tipotelefone;
	}

	public void setTipotelefone(Tipotelefone tipotelefone) {
		this.tipotelefone = tipotelefone;
	}

	public TipotelefoneService getTipotelefoneService() {
		return tipotelefoneService;
	}

	public void setTipotelefoneService(TipotelefoneService tipotelefoneService) {
		this.tipotelefoneService = tipotelefoneService;
	}


	public List<Tipotelefone> getTipotelefones() {
		return tipotelefoneService.listar();
	}


	public void setTipotelefones(List<Tipotelefone> tipotelefones) {
		this.tipotelefones = tipotelefones;
	}
	

}
