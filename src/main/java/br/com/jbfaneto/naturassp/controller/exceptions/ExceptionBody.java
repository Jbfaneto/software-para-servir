package br.com.jbfaneto.naturassp.controller.exceptions;

import java.time.Instant;


public record ExceptionBody(String message, String path, int status, Instant timestamp){

}
