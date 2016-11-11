package com.stefanini.viewmodel;

public class InfracoesUsuarioGrafico {

	private String nomeAgente;
	private Integer quantidadeInfracoes;

	public InfracoesUsuarioGrafico(String nome, Integer quantidade) {
		this.nomeAgente = nome;
		this.quantidadeInfracoes = quantidade;
	}

	public String getNomeAgente() {
		return nomeAgente;
	}

	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}

	public Integer getQuantidadeInfracoes() {
		return quantidadeInfracoes;
	}

	public void setQuantidadeInfracoes(Integer quantidadeInfracoes) {
		this.quantidadeInfracoes = quantidadeInfracoes;
	}

}
