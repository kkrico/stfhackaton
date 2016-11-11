package com.stefanini.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Infracoes;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracoesService;
import com.stefanini.viewmodel.InfracoesUsuarioGrafico;

@Path("/infracoesDaniel")
@RequestScoped
public class InfracaoDanielController {

	private Collection<Infracoes> infracoes = new ArrayList<Infracoes>();

	@Inject
	private InfracoesService infracoesService;

	@Inject
	private AgenteService agenteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Infracoes> getInfracoes() {
		return infracoesService.listar();
	}

	@GET
	@Path("/InfracoesUsuarioGrafico")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<InfracoesUsuarioGrafico> get() {

		Collection<Infracoes> infracoes = infracoesService.listar();
		this.infracoes = infracoes;

		Collection<InfracoesUsuarioGrafico> vm = new ArrayList<InfracoesUsuarioGrafico>();
		String ultimoAgente = null;

		for (Infracoes i : infracoes) {
			if (i.getAgente() != null) {
				if (i.getAgente().getNome() != ultimoAgente) {
					vm.add(new InfracoesUsuarioGrafico(i.getAgente().getNome(),
							contarInfracoesAgente(i.getAgente().getIdAgente())));
					ultimoAgente = i.getAgente().getNome();
				}
			}

		}

		return vm;
	}

	private Integer contarInfracoesAgente(Integer idAgente) {

		int r = 0;
		for (Infracoes i : this.infracoes) {
			if (i.getAgente().getIdAgente() == idAgente)
				r++;
		}

		return r;
	}

}
