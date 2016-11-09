package com.stefanini.controller;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Denuncia;
import com.stefanini.service.DenunciaService;

@Path("/denuncias")
@RequestScoped
public class DenunciaController {

	
	@Inject
	private DenunciaService denunciaService;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Denuncia> get() {
        return denunciaService.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void post(Denuncia denuncia) {
        denunciaService.salvar(denuncia);
    }
}
