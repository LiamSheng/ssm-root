package linzi.spring.restful.crud.advice;

import linzi.spring.restful.crud.common.R;
import linzi.spring.restful.crud.exception.BusinessException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("[全局异常处理] - MethodArgumentNotValidException.");
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errors = new HashMap<String, String>();
        // 拿到所有属性错误的信息.
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            // 获取属性名
            String field = fieldError.getField();
            // 获取错误信息
            String defaultMessage = fieldError.getDefaultMessage();
            errors.put(field, defaultMessage);
        }
        return R.error(500, "数据校验错误", errors);
    }

}
