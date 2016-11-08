package com.stefanini.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones", catalog = "hackatonjsf")
public class Telefones implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@Column(name = "idTipoTelefone")
	private Tipotelefone tipoTelefone;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_USER"))
	private Proprietario proprietario;
	
	@EmbeddedId
	private TelefonesKey telefoneKey;
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Telefones() {
		this.telefoneKey = new TelefonesKey();
	}

	public TelefonesKey getTelefoneKey() {
		return telefoneKey;
	}

	public void setTelefoneKey(TelefonesKey telefoneKey) {
		this.telefoneKey = telefoneKey;
	}

	public Tipotelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(Tipotelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
}
