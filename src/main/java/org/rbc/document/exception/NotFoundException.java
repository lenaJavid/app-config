package org.rbc.document.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lena on 2017-04-04.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Can not find configuration!")
public class NotFoundException extends IllegalArgumentException {
    private static final long serialVersionUID = -1L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
