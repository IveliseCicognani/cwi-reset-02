package br.com.cwi.resetflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class NotFoundMessageException extends RuntimeException {

    public NotFoundMessageException(String message) {
        super(message);
    }
}
