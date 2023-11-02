package com.test.technique.Billing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlllerHandlerException {
    //Body Mal formado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> malformedJsonException(HttpMessageNotReadableException exc) {

        ApiError apiError = ApiError.builder()

                .message("Json está mal formado")
                .status(HttpStatus.BAD_REQUEST.value()).build();
        return ResponseEntity.status(apiError.getStatus()).body(apiError);

    }

    //Capturas las validaciones de los "input"
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> malformedBodyException(MethodArgumentNotValidException e) {

        ApiError apiError = ApiError.builder()
                .error("La entrada no es válida")
                .message(e.getFieldError().getDefaultMessage())
                .status(HttpStatus.BAD_REQUEST.value()).build();
        return ResponseEntity.status(apiError.getStatus()).body(apiError);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiError> methodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ApiError apiError = ApiError.builder()
                .message("La entrada no es válida")
                .status(HttpStatus.BAD_REQUEST.value()).build();
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
