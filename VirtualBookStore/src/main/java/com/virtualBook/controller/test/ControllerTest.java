package com.virtualBook.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class ControllerTest {


    Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    // Testing for logger and path variable


    @GetMapping("/wish/{msg}/for/{userName}")
    public String wish(@PathVariable(value="msg") String message, @PathVariable String userName){

        logger.info("message: {}", message);
        logger.info("userName: {}", userName);
        return "Wishing " + message + " for " +userName;
    }


    // Testing for query parameter

    @GetMapping("/wish")
    public String wishQuery
    (@RequestParam(value="msg",required = false,defaultValue = "Good health") String message,
     @RequestParam String userName){


        logger.info("message: {}", message);
        logger.info("userName: {}", userName);
        return "Wishing " + message + " for " +userName;
    }
}

