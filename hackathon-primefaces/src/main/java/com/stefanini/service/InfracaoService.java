package com.stefanini.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.stefanini.repository.InfracaoRepository;

public class InfracaoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private InfracaoRepository infracaoRepository;
}
