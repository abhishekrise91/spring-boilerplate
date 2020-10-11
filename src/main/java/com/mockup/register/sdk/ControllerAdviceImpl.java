package com.mockup.register.sdk;

import com.mockup.register.sdk.exception.ErrorBody;
import com.mockup.register.sdk.exception.WebException;
import com.mockup.register.sdk.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@Slf4j
@ControllerAdvice
public class ControllerAdviceImpl extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WebException.class)
    public ResponseEntity<?> handleWebException(WebException ex, WebRequest request) {
        log.error("[ {} ] -> {}", ex.getErrorCode(), ex.getMessage());
        ex.setTimestamp(DateUtil.getCurrentDate());
        ErrorBody errorBody = new ErrorBody(ex);
        return new ResponseEntity<>(errorBody, HttpStatus.valueOf(ex.getStatusCode()));
    }

    @ExceptionHandler(IOException.class)
    public final ResponseEntity<ErrorBody> handleIOException(IOException ex, WebRequest request) {
        ErrorBody errorDetails = new ErrorBody(DateUtil.getCurrentDate(), ex.getMessage());
        log.error("Exception -> ", ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorBody> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorBody errorDetails = new ErrorBody(DateUtil.getCurrentDate(), ex.getMessage());
        log.error("Exception -> ", ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}