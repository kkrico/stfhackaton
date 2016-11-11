package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;

@Path("/agente")
@RequestScoped
public class AgenteController {

	@Inject
	private AgenteService agenteService;
	
	//Lista
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Agente> get() {
		return agenteService.listar();
	}

	//Create
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void post(Agente agente) {
		this.agenteService.incluir(agente);
	}
	
	//Delete
	@POST
	@Path("{id}/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void post(@PathParam("id") Integer id) {
		Agente agente = new Agente();
		agente.setIdAgente(id);
		System.out.println("id to delete" + id);
		this.agenteService.deleta(id);
	}

}