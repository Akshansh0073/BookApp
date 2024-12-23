package com.virtualBook.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.virtualBook.entities.OrderStatus;
import com.virtualBook.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> userResourceNotFoundExceptionHandler(UserResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleEnumTypeMismatch(MethodArgumentTypeMismatchException ex) {
		Map<String, String> resp = new HashMap<>();
		String field1 = "Fixture";
        String message1 =  "Allowed values are: "+ String.join(", ", OrderStatus.valuesAsString());
		String field = ex.getName();
        String message = "Invalid value in request parameter '" + ex.getName() +"'";
        resp.put(field, message);
        resp.put(field1, message1);
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }
	
}
