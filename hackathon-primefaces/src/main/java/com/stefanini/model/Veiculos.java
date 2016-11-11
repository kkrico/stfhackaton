package com.stefanini.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Veiculos {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer placa;

	@ManyToOne
	@JoinColumn(name = "cpfProprietario")
	private Proprietario cpfProprietario;

	@ManyToOne
	@JoinColumn(name = "idModelo")
	private Modelo idModelo;

	private String uf;

	// Gets e Sets

	public Integer getPlaca() {
		return placa;
	}

	public void setPlaca(Integer placa) {
		this.placa = placa;
	}

	public Proprietario getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(Proprietario cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public Modelo getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Modelo idModelo) {
		this.idModelo = idModelo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
