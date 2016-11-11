package com.stefanini.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mostrar {

	public static void MensagemSucesso(String titulo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem));
	}

	public static void MensagemFracasso(String titulo, String message) {
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, message));
		
	}
}
