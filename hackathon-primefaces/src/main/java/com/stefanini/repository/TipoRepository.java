package com.stefanini.repository;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Tipo;

@Dependent
public class TipoRepository {

	@Inject
	private EntityManager manager;

	public void salva(Tipo tipo) {
		if (tipo.getId() != null) {
			this.manager.merge(tipo);
		} else {
			this.manager.persist(tipo);
		}
	}
	
	public Tipo busca(Long id) {
		return this.manager.find(Tipo.class, id);
	}

	public List<Tipo> lista() {
		return this.manager.createQuery("select c from Tipo c", Tipo.class).getResultList();
	}

	public void excluir(Integer id) {
		this.manager.remove(this.manager.find(Tipo.class, id));
	}

}
