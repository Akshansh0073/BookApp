package com.virtualBook.controller.test;

import com.virtualBook.payload.test.UserData;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {


    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signup")
    public ResponseEntity<UserData> signup(@Valid @RequestBody UserData user){

        logger.info("User signing up: {}", user.toString());

        return new ResponseEntity<UserData>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>>
    logIn(@RequestBody Map<String,Object> data,@RequestHeader("User-Agent") String agent)

    {
        String test=null;
        test.length(); // intentionally create Nullpointerexception
        logger.info("User-Agent: {}", agent);
        logger.info("Undefined source: {}", data);
        return new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
    }


    // Only for this controller

//    @ExceptionHandler(NullPointerException.class)
//    public String handleNullPointerException(NullPointerException ex) {
//        logger.error("NullPointerException occurred: {}", ex.getMessage());
//        return ex.getMessage();
//    }
//
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        logger.error("MethodArgumentNotValidException occurred: {}", ex.getMessage());
//        return "Your input data not valid";
//    }

}
