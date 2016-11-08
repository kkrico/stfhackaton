package com.stefanini.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class InfracaoRepository implements Serializable{
	
	@Inject
	private EntityManager manager;
	
	private static final long serialVersionUID = 1L;

}
