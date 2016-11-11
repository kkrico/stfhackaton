package com.stefanini.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idCategoria;

	private String descricaiCategoria;

	// Gets e Sets

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricaiCategoria() {
		return descricaiCategoria;
	}

	public void setDescricaiCategoria(String descricaiCategoria) {
		this.descricaiCategoria = descricaiCategoria;
	}

}
