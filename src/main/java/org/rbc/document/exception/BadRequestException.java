package org.rbc.document.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lena on 2017-04-04.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad Request")
public class BadRequestException extends IllegalArgumentException {
    private static final long serialVersionUID = -1L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
