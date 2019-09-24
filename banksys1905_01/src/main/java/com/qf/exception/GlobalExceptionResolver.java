package com.qf.exception;

import com.qf.common.JsonResult;
import org.springframework.web.bind.annotation.*;

// 异常类必须使用该注解 @ControllerAdvice
//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(Exception.class)
    public JsonResult exception(Exception e){

        return new JsonResult(1,e.getMessage());
    }
}
