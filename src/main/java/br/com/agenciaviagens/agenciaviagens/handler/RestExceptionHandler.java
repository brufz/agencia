package br.com.agenciaviagens.agenciaviagens.handler;

import br.com.agenciaviagens.agenciaviagens.error.ErrosDetails;
import br.com.agenciaviagens.agenciaviagens.error.IdNaoEncontradoDetails;
import br.com.agenciaviagens.agenciaviagens.error.IdNaoEncontradoException;
import br.com.agenciaviagens.agenciaviagens.error.ValidacoesErroDetails;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNaoEncontradoException.class)
    public ResponseEntity<?> handlerIdNaoEncontradoException(IdNaoEncontradoException idNaoEncontradoException){
        IdNaoEncontradoDetails idNaoEncontradoDetails = IdNaoEncontradoDetails
                .IdNaoEncontradoDetailsBuilder
                .newBuilder()
                .title("Id não encontrado")
                .status(HttpStatus.NOT_FOUND.value())
                .details(idNaoEncontradoException.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage(idNaoEncontradoException.getClass().getName())
                .build();
        return new ResponseEntity<>(idNaoEncontradoDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String field = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String messageField = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        ValidacoesErroDetails validationErrorDetails = ValidacoesErroDetails
                .ValidacoesErroDetailsBuilder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Resource not found")
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .campo(field)
                .mensagemCampo(messageField)
                .build();
        return new ResponseEntity<>(validationErrorDetails, HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             @Nullable Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus statusCode,
                                                             WebRequest request) {
        ErrosDetails errosDetails = ErrosDetails
                .ErrosDetailsBuilder
                .newBuilder()
                .title("Internal error")
                .status(HttpStatus.NOT_FOUND.value())
                .details(ex.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(errosDetails, headers, statusCode);

            }
        }

