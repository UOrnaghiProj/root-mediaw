package com.freeinfo.mediaw.rootservice.exception;

public class MediaworldException extends Exception {


	private static final long serialVersionUID = -99541825182442551L;

	private String messaggio = "problemi con il sito Mediaworld controllare i campi inseriti";

	public MediaworldException() {}
	
	public MediaworldException(String messaggio) {
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
