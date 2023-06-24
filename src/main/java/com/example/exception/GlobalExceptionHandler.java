package com.example.exception;

import com.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // 捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败");
    }
}
