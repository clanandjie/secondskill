package com.fanzs.secondskill.exception;

import com.fanzs.secondskill.result.CodeMsg;
import com.fanzs.secondskill.result.Result;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fzs on 2018/4/8.
 */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request,Exception e){
        if(e instanceof GlobalException){
            GlobalException ex=(GlobalException)e;
            return Result.error(ex.getCm());
        }else if(e instanceof BindException){
            BindException bex= (BindException) e;
            List<ObjectError> errors= bex.getAllErrors();
            ObjectError error= errors.get(0);
            String msg=error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
