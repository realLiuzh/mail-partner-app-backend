package com.cqupt.Exception;

//import com.cqupt.pojo.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody //为了返回数据
//    public R error(Exception e) {
//
//        e.printStackTrace();
//        return R.error().message("执行了全局异常处理..");
//    }
//
//
//    @ExceptionHandler(GlobalException.class)
//    @ResponseBody //为了返回数据
//    public R error(GlobalException e) {
//
//        e.printStackTrace();
//        return R.error().code(e.getCode()).message(e.getMessage());
//    }
//
//}
