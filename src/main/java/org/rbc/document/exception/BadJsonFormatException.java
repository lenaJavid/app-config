package org.rbc.document.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lena on 2017-04-04.
 */
@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Bad Request")
public class BadJsonFormatException extends IllegalArgumentException {
    private static final long serialVersionUID = -1L;

    public BadJsonFormatException(String message) {
        super(message);
    }

    public BadJsonFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadJsonFormatException(Throwable cause) {
        super(cause);
    }
}
