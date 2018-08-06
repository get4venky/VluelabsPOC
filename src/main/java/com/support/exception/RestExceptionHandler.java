package com.support.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
    
    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<Object> handlePosException(ApplicationException ex) {
        return this.buildResponseEntity(ex);
    }
    
    private ResponseEntity<Object> buildResponseEntity(ApplicationException ex) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("datetime", sdf.format(new Date()));
        body.put("httpStatus", ex.getHttpStatus().value());
        body.put("errorCode", ex.getErrorCode());
        body.put("errorDescription", ex.getErrorDescription());
        body.put("errorDescription", ex.getErrorDescription());
        body.put("displayMessage", ex.getDisplayMessage());
        body.put("data", ex.getData());
        return new ResponseEntity<>(body, ex.getHttpStatus());
    }

}
