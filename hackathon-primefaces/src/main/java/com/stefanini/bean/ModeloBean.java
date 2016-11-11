package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
import com.stefanini.model.Tipotelefone;
import com.stefanini.service.ModeloService;

@Named("modeloMB")
@SessionScoped
public class ModeloBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Modelo modelo;
	
	private List<Modelo> modelos;
	
	public ModeloBean() {
		this.modelo = new Modelo();
	}
	
	@Inject
	ModeloService modeloService;
	
	public String incluir(){
		modeloService.incluir(modelo);
		this.modelo = new Modelo();
		return "pages/sucessoModelo.faces?faces-redirect=true";
	}
	
	// Gets e Sets

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public ModeloService getModeloService() {
		return modeloService;
	}

	public void setModeloService(ModeloService modeloService) {
		this.modeloService = modeloService;
	}

	public List<Modelo> getModelos() {
		return modeloService.listar(modelo);
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}
	

}
