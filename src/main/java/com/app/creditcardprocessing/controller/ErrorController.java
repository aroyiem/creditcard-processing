package com.app.creditcardprocessing.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ErrorHandlerController implements ErrorController {

    @Override
    @RequestMapping("/error")
    @ResponseBody
    public String getErrorPath() {
        return "<h1>Something went wrong</h1>";
    }
}
