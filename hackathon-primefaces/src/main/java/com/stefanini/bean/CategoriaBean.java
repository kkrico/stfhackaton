package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Categoria;
import com.stefanini.service.CategoriaService;

@Named("categoriaMB")
@SessionScoped
public class CategoriaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	Categoria categoria;

	private List<Categoria> categorias;

	public CategoriaBean() {
		this.categoria = new Categoria();
	}

	@Inject
	CategoriaService categoriaService;
	
	public String incluir(){
		categoriaService.incluir(categoria);
		this.categoria = new Categoria();
		return "pages/sucessoCategoria.faces?faces-redirect=true";
	}
	
	// Gets e Sets

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categoriaService.listar(categoria);
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	

}
