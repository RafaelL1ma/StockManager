package br.com.controllers;


import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@ControllerAdvice
public class ErrorController {

@ExceptionHandler(Forbidden.class)
@ResponseStatus(HttpStatus.FORBIDDEN)
public String forBidden() {
	return "/error/403.hmtl";
}

@ExceptionHandler(NotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public String notFound() {
	return "/error/404.html";
}

@ExceptionHandler(InternalServerError.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public String internalServerError() {
	return "/error/500.html";
}

}
