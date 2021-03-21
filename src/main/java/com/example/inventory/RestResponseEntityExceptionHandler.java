package com.example.inventory;

import com.example.inventory.errors.ApiErrorResponse;
import com.example.inventory.exceptions.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Date;

@RestControllerAdvice

public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)

    public ApiErrorResponse handleFileSizeLimitExceeded(MaxUploadSizeExceededException exc) {
        Date timestamp = new java.util.Date();
        return new ApiErrorResponse( HttpStatus.PAYLOAD_TOO_LARGE,exc.getMessage(),timestamp.toInstant());

    }


        @ExceptionHandler(value
                = { ItemNotFoundException.class })
        @ResponseStatus(HttpStatus.NOT_FOUND)
        protected ApiErrorResponse handleConflict(
            RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "This should be application specific";
        Date timestamp = new java.util.Date();
        return new ApiErrorResponse( HttpStatus.NOT_FOUND,ex.getMessage(),timestamp.toInstant());
    }

        @ExceptionHandler(value
                = {         ItemExistsException .class })

        @ResponseStatus(HttpStatus.CONFLICT)
        protected ApiErrorResponse someResponse(
                RuntimeException ex, WebRequest request) {
                Date timestamp = new java.util.Date();
                return new ApiErrorResponse( HttpStatus.CONFLICT,ex.getMessage(),timestamp.toInstant());
        }


    @ExceptionHandler(value
            = {         InvalidQuantityChangeException.class })


    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    protected ApiErrorResponse invalidQuantityResponse(
            RuntimeException ex, WebRequest request) {
        Date timestamp = new java.util.Date();
        return new ApiErrorResponse( HttpStatus.PRECONDITION_FAILED,ex.getMessage(),timestamp.toInstant());
    }

    @ExceptionHandler(value
            = {         InvalidCreatingException.class })
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    protected ApiErrorResponse invalidCreationResponse(
            RuntimeException ex, WebRequest request) {
            System.out.println("request:"+request.toString());
        Date timestamp = new java.util.Date();
        return new ApiErrorResponse( HttpStatus.PRECONDITION_FAILED,ex.getMessage(),timestamp.toInstant());
    }


    @ExceptionHandler(value
            = {         EmptyResultDataAccessException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ApiErrorResponse emptyResultDataAccess(
            RuntimeException ex, WebRequest request) {
        System.out.println("request:"+request.toString());
        System.out.println("ex:"+ex.toString());

        Date timestamp = new java.util.Date();
        return new ApiErrorResponse( HttpStatus.NOT_FOUND,ex.getMessage(),timestamp.toInstant());
    }

}
