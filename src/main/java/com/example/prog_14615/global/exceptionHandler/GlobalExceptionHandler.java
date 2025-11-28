package com.example.prog_14615.global.exceptionHandler;

import com.example.prog_14615.domain.post.post.RsData;
import com.example.prog_14615.global.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// Exception 핸들러 처리 하는 법
// ControllerAdvice를 쓰면 모든 Exception을 전부 지켜봄
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public RsData handleException(ServiceException e) {

        RsData rsData = new RsData();
        rsData.setResultCode("401");
        rsData.setMessage(e.getMessage());
        return rsData;
    }
}
