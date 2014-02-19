package com.kaiser.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaiser.controller.response.ErrorResponse;

@Controller
public class ExceptionHandlingController {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(final HttpServletResponse httpServletResponse) {
        // TODO do something with the response code
        final ErrorResponse errorResponse = new ErrorResponse();
        return errorResponse;
    }
}
