package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;
import com.stefanini.model.Localinfracao;
import com.stefanini.model.Tipoinfracao;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracoesService;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.service.TipoInfracaoService;

@Path("/infracoes")
@RequestScoped
public class InfracaoController {
	
	@Inject
	private Infracoes infracao;
	
	@Inject
	private InfracoesService infracoesService;
	
	@Inject
	private AgenteService agenteService;
	
	@Inject
	private LocalInfracaoService localInfracaoService;
	

	@Inject
	private TipoInfracaoService tipoInfracaoService;
	
	
	//Listar Locais de infração
	@GET
	@Path("/local")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Localinfracao> get() {
		return localInfracaoService.listar();
	}
	
	//Listar Tipos de infrações
		@GET
		@Path("/tipo")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Tipoinfracao> getInfracao() {
			System.out.println("called");
			return tipoInfracaoService.listar();
		}
		
		//Listar Tipos de infrações
				@GET
				@Path("/cadastra/agente/{idAgente}/local/{idLocalInfracao}/tipo/{idTipoInfracao}")
				@Produces(MediaType.APPLICATION_JSON)
				public void cadastra(@PathParam("idAgente") Integer idAgente,@PathParam("idLocalInfracao") Integer idLocalInfracao,@PathParam("idTipoInfracao") Integer idTipoInfracao) {
					
					System.out.println("called idAgente: " + idAgente);
					agenteService.buscar(idAgente);
					
					System.out.println("called idTipoInfracao: " + idTipoInfracao);
					tipoInfracaoService.busca(idTipoInfracao);
					
					System.out.println("called idLocalInfracao: " + idLocalInfracao);
					localInfracaoService.busca(idLocalInfracao);
					
					infracao.setAgente(agenteService.buscar(idAgente));
					infracao.setTipoInfracao(tipoInfracaoService.busca(idTipoInfracao));
					infracao.setLocalInfracao(localInfracaoService.busca(idLocalInfracao));
					infracao.setVelocidade(170);
					infracoesService.incluir(infracao);
					
				}


}