package com.gv.userservice.exception;

import com.gv.userservice.dto.response.APIResponse;
import com.gv.userservice.dto.response.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoUserFoundException.class)
    public ResponseEntity<APIResponse> handleNoUserFoundException(NoUserFoundException noUserFoundException) {
        log.info("handleNoUserFoundException++++" + noUserFoundException.getMessage());
        APIResponse apiResponse = new APIResponse();
        apiResponse.setError(new Error("9999", noUserFoundException.getMessage()));
        return ResponseEntity.ok(apiResponse);
    }

    @ExceptionHandler(value = NoSuchMethodException.class)
    public ResponseEntity<APIResponse> handleNoSuchMethodException(NoSuchMethodException noSuchMethodException) {
        log.info("handleNoUserFoundException++++" + noSuchMethodException.getMessage());
        APIResponse apiResponse = new APIResponse();
        apiResponse.setError(new Error("9999", noSuchMethodException.getMessage()));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
