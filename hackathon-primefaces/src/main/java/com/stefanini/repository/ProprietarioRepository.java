package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;

public class ProprietarioRepository {
	
	@Inject
	private EntityManager manager;
	
	public void incluir(Proprietario prorietario) {
		this.manager.persist(prorietario);
	}
	
	public Proprietario buscar(Integer cpfProprietario){
		return this.manager.find(Proprietario.class, cpfProprietario);
	}
	
	public List<Proprietario> listaTodos() {
		Query query = manager.createQuery("select u from Proprietario u");
		
		 List<Proprietario> lista = query.getResultList();
		return lista;
	}
	
	public void excluir(Integer cpfProprietario) {
		this.manager.remove(manager.find(Proprietario.class, cpfProprietario));
	}
}
