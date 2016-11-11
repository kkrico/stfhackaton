package com.stefanini.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Telefones;
import com.stefanini.model.TelefonesKey;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.TelefoneService;
import com.stefanini.util.Mostrar;

@Named("telefonesMB")
@RequestScoped
public class TelefonesBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idTipoTelefone;
	private Integer ddd;
	private Integer numero;
	private Integer cpfProprietario;
	
	private Telefones telefones;
	
	public TelefonesBean() {
		this.telefones = new Telefones();
	}
	
	@Inject
	private TelefoneService telefoneService;
	@Inject
	private ProprietarioService proprietarioService;
	
	public void incluir(){
		try {
			this.telefones.setProprietario(proprietarioService.buscar(cpfProprietario));
			this.telefones.setTipoTelefone(telefoneService.buscar(this.idTipoTelefone));
			this.telefones.setTelefoneKey(new TelefonesKey(this.ddd.intValue(), this.numero.intValue()));
			telefoneService.incluir(telefones);
			this.telefones = new Telefones();
			Mostrar.MensagemSucesso("Sucesso", "Registro Inserido com sucesso");
		} catch (Exception e) {
			Mostrar.MensagemFracasso("Fracasso", e.getMessage());
		}
	}	
	
	// Gets e Sets
	
	public Telefones getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefones telefones) {
		this.telefones = telefones;
	}

	public TelefoneService getTelefoneService() {
		return telefoneService;
	}

	public void setTelefoneService(TelefoneService telefoneService) {
		this.telefoneService = telefoneService;
	}

	public Integer getIdTipoTelefone() {
		return idTipoTelefone;
	}

	public void setIdTipoTelefone(Integer idTipoTelefone) {
		this.idTipoTelefone = idTipoTelefone;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public ProprietarioService getProprietarioService() {
		return proprietarioService;
	}

	public void setProprietarioService(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	public Integer getIdProprietario() {
		return getCpfProprietario();
	}

	public void setIdProprietario(Integer idProprietario) {
		this.setCpfProprietario(idProprietario);
	}

	public Integer getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(Integer cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}
}
