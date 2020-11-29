package com.freeinfo.mediaw.rootservice.exception;

public class NotFoundException extends Exception{

	private static final long serialVersionUID = -7096748236141930492L;
	
	private String messaggio;

	public NotFoundException() {}
	
	public NotFoundException(String messaggio) {
		super();
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

}
