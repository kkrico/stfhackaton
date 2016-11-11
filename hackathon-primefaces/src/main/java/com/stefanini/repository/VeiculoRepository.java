package com.stefanini.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Veiculos;

public class VeiculoRepository {

	private EntityManager em;
	public Collection<Veiculos> listar() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select v from Veiculo v");
		return (Collection<Veiculos>)q.getResultList();
	}
	public Veiculos buscar(Integer placaVeiculo) {
		// TODO Auto-generated method stub
		return em.find(Veiculos.class, placaVeiculo);
	}
	public void incluir(Veiculos veiculos) {
		em.persist(veiculos);
	}
}
