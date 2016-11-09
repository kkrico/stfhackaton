package com.stefanini.repository;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Denunciante;

@Dependent
public class DenuncianteRepository {

	@Inject
	private EntityManager manager;

	public void salva(Denunciante denunciante) {
		if (denunciante.getId() != null) {
			this.manager.merge(denunciante);
		} else {
			this.manager.persist(denunciante);
		}
	}

	public Denunciante busca(Integer id) {
		return this.manager.find(Denunciante.class, id);
	}

	public List<Denunciante> lista() {
		return this.manager.createQuery("select c from Denunciante c", Denunciante.class).getResultList();
	}

	public void excluir(Integer id) {
		this.manager.remove(this.manager.find(Denunciante.class, id));
	}

	@SuppressWarnings("unchecked")
	public List<Denunciante> consultar(Denunciante denunciante) {
		StringBuffer hql = new StringBuffer();

		hql.append("SELECT d FROM Denunciante d ");
		hql.append("WHERE 1=1 ");
		if (denunciante.getNome() != null && !denunciante.getNome().isEmpty()) {
			hql.append("AND d.nome LIKE (:nome) ");
		}
		if (denunciante.getEmail() != null && !denunciante.getEmail().isEmpty()) {
			hql.append("AND d.email = :email ");
		}
		if (denunciante.getTelefone() != null && !denunciante.getTelefone().isEmpty()) {
			hql.append("AND d.telefone = :telefone ");
		}
		
		
		Query query = this.manager.createQuery(hql.toString());
		
		if (denunciante.getNome() != null && !denunciante.getNome().isEmpty()) {
			query.setParameter("nome", "%"+denunciante.getNome()+"%");
		}
		if (denunciante.getEmail() != null && !denunciante.getEmail().isEmpty()) {
			query.setParameter("email", denunciante.getNome());
		}
		if (denunciante.getTelefone() != null && !denunciante.getTelefone().isEmpty()) {
			query.setParameter("telefone", denunciante.getTelefone());
		}
		return (List<Denunciante>)query.getResultList();
		
	}

}
