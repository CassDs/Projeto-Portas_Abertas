package br.com.portasabertas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NegocioException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NegocioException(String msg) {
        super(msg);
    }
}
