package com.stefanini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipotelefone", catalog = "hackatonjsf")
public class Tipotelefone implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoTipoTelefone == null) ? 0 : descricaoTipoTelefone.hashCode());
		result = prime * result + ((idTipoTelefone == null) ? 0 : idTipoTelefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipotelefone other = (Tipotelefone) obj;
		if (descricaoTipoTelefone == null) {
			if (other.descricaoTipoTelefone != null)
				return false;
		} else if (!descricaoTipoTelefone.equals(other.descricaoTipoTelefone))
			return false;
		if (idTipoTelefone == null) {
			if (other.idTipoTelefone != null)
				return false;
		} else if (!idTipoTelefone.equals(other.idTipoTelefone))
			return false;
		return true;
	}

	private Integer idTipoTelefone;
	private String descricaoTipoTelefone;

	public Tipotelefone() {
	}

	public Tipotelefone(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipoTelefone", unique = true, nullable = false)
	public Integer getIdTipoTelefone() {
		return this.idTipoTelefone;
	}

	public void setIdTipoTelefone(Integer idTipoTelefone) {
		this.idTipoTelefone = idTipoTelefone;
	}

	@Column(name = "descricaoTipoTelefone", length = 20)
	public String getDescricaoTipoTelefone() {
		return this.descricaoTipoTelefone;
	}

	public void setDescricaoTipoTelefone(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}

}
