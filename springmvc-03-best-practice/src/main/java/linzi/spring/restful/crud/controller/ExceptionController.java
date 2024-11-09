package linzi.spring.restful.crud.controller;

import linzi.spring.restful.crud.common.R;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;

/**
 * 测试异常处理的 Controller.
 */
@RestController
public class ExceptionController {

    /**
     * 编程式异常处理, 业务逻辑复杂会很麻烦.
     * try {
     * int i = 1 / 0;
     * } catch (Exception e) {
     * return R.error();
     * }
     */
    @GetMapping("/e1")
    public R<Object> exceptionHander(
            @RequestParam(value = "id", defaultValue = "0") int id) throws FileNotFoundException {
        //throw new NullPointerException();
        //FileInputStream fis = new FileInputStream("sd1/2323");
        return R.ok(10 / id);
    }

    /**
     * 本 Controller 类出现数学计算异常, 自动在本类中寻找 @ExceptionHandler 标注的方法.
     * 如果有, 执行注解标记的方法, 返回值是客户到收到的结果.
     * 发生的异常, 类名精确的优先处理.
     */
//    @ExceptionHandler({ArithmeticException.class, FileNotFoundException.class})
////    类上标记了@RestController, 等于这个方法也标记了 @ResponseBody, 因此返回值会变成一个JSON对象给客户端.
//    public R<Object> handleArithmeticException(ArithmeticException e) {
//        return R.error(100, e.getMessage());
//    }

//    @ExceptionHandler(IOException.class)
//    public R<Object> handleIOException(IOException e) {
//        return R.error(300, e.getMessage());
//    }

    /**
     * 其他异常统一处理
     */
//    @ExceptionHandler(Throwable.class)
//    public R<Object> handleUnknownException(Exception e) {
//        return R.error(500, e.getMessage());
//    }

}
