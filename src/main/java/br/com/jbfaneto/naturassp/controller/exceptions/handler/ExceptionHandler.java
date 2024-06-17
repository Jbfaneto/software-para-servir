package br.com.jbfaneto.naturassp.controller.exceptions.handler;

import br.com.jbfaneto.naturassp.controller.exceptions.ExceptionBody;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice(basePackages = "br.com.jbfaneto.naturassp.controller")
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<ExceptionBody> handleIllegalArgumentException(
            final IllegalArgumentException exception,
            final HttpServletRequest request) {
        final var body = new ExceptionBody(
                exception.getMessage(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
