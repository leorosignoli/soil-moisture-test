package br.edu.uniceub.soilmoisture.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid date format, should be yyyy-MM-dd HH:mm.")
public class InvalidDateTime extends RuntimeException {

	private static final long serialVersionUID = 1227379112317496314L;

	public InvalidDateTime() {
		super("Invalid date format, should be yyyy-MM-dd HH:mm.");
	}

}
