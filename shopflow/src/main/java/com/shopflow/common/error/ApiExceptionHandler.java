package com.shopflow.common.error;

import com.shopflow.common.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@ControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceAccessException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(ResourceNotFoundException e) {
        e.printStackTrace();
        return new ErrorMessage (e);
    }

}
