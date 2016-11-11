package com.stefanini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Infracoes {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idInfracao")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idAgente")
	private Agente agente;

	@ManyToOne
	@JoinColumn(name = "idLocalInfracao")
	private Localinfracao localInfracao;

	@ManyToOne
	@JoinColumn(name = "idTipoInfracao")
	private Tipoinfracao tipoInfracao;

	@ManyToOne
	@JoinColumn(name = "placa")
	private Veiculos veiculo;

	private Integer velocidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Localinfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(Localinfracao localInfracao) {
		this.localInfracao = localInfracao;
	}

	public Tipoinfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(Tipoinfracao tipoInfracao) {
		this.tipoInfracao = tipoInfracao;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}
}
