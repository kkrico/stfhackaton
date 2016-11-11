package com.stefanini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

@Entity
public class Localinfracao {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idLocalInfracao;

	private String descricaoLocalInfracao;
	private Double velocidadePermitida;
	private Double latitude;
	private Double longitude;

	// Gets e Sets

	public Integer getIdLocalInfracao() {
		return idLocalInfracao;
	}

	public void setIdLocalInfracao(Integer idLocalInfracao) {
		this.idLocalInfracao = idLocalInfracao;
	}

	public String getDescricaoLocalInfracao() {
		return descricaoLocalInfracao;
	}

	public void setDescricaoLocalInfracao(String descricaoLocalInfracao) {
		this.descricaoLocalInfracao = descricaoLocalInfracao;
	}

	public Double getVelocidadePermitida() {
		return velocidadePermitida;
	}

	public void setVelocidadePermitida(Double velocidadePermitida) {
		this.velocidadePermitida = velocidadePermitida;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
