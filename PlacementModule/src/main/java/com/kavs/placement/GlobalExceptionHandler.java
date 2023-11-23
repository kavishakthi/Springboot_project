package com.kavs.placement;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


	@RestControllerAdvice
public class GlobalExceptionHandler
{

	    @ExceptionHandler(PlValidateException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    
	    public ResponseEntity<String> handlePlacementValidateException(PlValidateException ex)
	    {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }
}

