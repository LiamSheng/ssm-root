package linzi.spring.restful.crud.advice;

import linzi.spring.restful.crud.common.R;
import linzi.spring.restful.crud.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器
// @ControllerAdvice // 告诉 SpringMVC 这个组件专门负责全局异常处理
// @ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R<Object> error(Exception e) {
        System.out.println("[全局异常处理] - Exception.");
        return R.error(500, e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public R<Object> arithmeticException(ArithmeticException e) {
        System.out.println("[全局异常处理] - ArithmeticException.");
        return R.error(500, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public R<Object> businessException(BusinessException e) {
        System.out.println("[全局异常处理] - BusinessException.");
        return R.error(e.getCode(), e.getMessage());
    }

}
