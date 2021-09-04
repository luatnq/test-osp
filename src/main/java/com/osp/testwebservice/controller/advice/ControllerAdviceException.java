package com.osp.testwebservice.controller.advice;

import com.osp.testwebservice.exception.CompanyNotFoundException;
import com.osp.testwebservice.exception.NetworkTypeNotFound;
import com.osp.testwebservice.model.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ControllerAdviceException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CompanyNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(CompanyNotFoundException exception, WebRequest request){
        log.error(exception.getMessage());
        BaseResponse response = new BaseResponse(null,
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                ((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NetworkTypeNotFound.class})
    public ResponseEntity<?> handleNotFoundException(NetworkTypeNotFound exception, WebRequest request){
        log.error(exception.getMessage());
        BaseResponse response = new BaseResponse(null,
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                ((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
