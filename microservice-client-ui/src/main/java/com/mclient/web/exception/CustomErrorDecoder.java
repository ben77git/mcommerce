package com.mclient.web.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();
	
	@Override
	public Exception decode(String invoqueur, Response reponse) {
		if (reponse.status() == 400) {
			System.out.println("raison exception 400 :" + reponse.reason());
			return new ProductBadRequestException("requete incorrecte");
		}
		if (reponse.status() == 404) {
			System.out.println("raison exception 404 :" + reponse.reason());
			return new ProductNotFoundException("requete incorrecteProduit nn trou\u00E9");
		}
		return defaultErrorDecoder.decode(invoqueur, reponse);
	}

}
