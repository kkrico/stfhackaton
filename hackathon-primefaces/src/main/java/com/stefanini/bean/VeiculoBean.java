package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefones;
import com.stefanini.model.TelefonesKey;
import com.stefanini.model.Veiculos;
import com.stefanini.service.ModeloService;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.VeiculoService;
import com.stefanini.util.Mostrar;

@Named("veiculoBean")
public class VeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Collection<Veiculos> todoVeiculos = new ArrayList<Veiculos>();
	private Integer idModelo;
	private Integer cpfProprietario;
	private Integer idProprietario;
	
	@Inject
	private ProprietarioService proprietarioService;
	
	@Inject
	private ModeloService modeloService;
	
	@Inject
	private VeiculoService veiculoService;
	
	public ProprietarioService getProprietarioService() {
		return proprietarioService;
	}

	public void setProprietarioService(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	public ModeloService getModeloService() {
		return modeloService;
	}

	public void setModeloService(ModeloService modeloService) {
		this.modeloService = modeloService;
	}

	@Inject
	private Veiculos veiculos;
	
	public void incluir(){
		try {
			this.veiculos.setCpfProprietario(proprietarioService.buscar(cpfProprietario));
			this.veiculos.setIdModelo(modeloService.buscar(this.idModelo));
			this.veiculoService.incluir(this.veiculos);
			this.veiculos = new Veiculos();
			Mostrar.MensagemSucesso("Sucesso", "Registro Inserido com sucesso");
		} catch (Exception e) {
			Mostrar.MensagemFracasso("Fracasso", e.getMessage());
		}
	}	

	public VeiculoService getVeiculoService() {
		return veiculoService;
	}

	public void setVeiculoService(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

	public Integer getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}

	public Collection<Veiculos> getTodoVeiculos() {
		return this.veiculoService.listarTodos();
	}

	public void setTodoVeiculos(Collection<Veiculos> todoVeiculos) {
		this.todoVeiculos = todoVeiculos;
	}
	
	public Collection<Veiculos> listarTodosVeiculos() {
		return this.todoVeiculos;
	}
}
