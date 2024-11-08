package linzi.spring.restful.crud.vo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import linzi.spring.restful.crud.annotation.DIYGender;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class EmployeeAddVO {
    private Long id;         // 主键

    @NotNull
    private String name;     // 员工名字

    @NotNull
    @Max(value = 150, message = "最大年龄150")
    @Min(value = 18, message = "最小年龄18岁")
    private Integer age;     // 年龄

    @Email
    private String email;    // 邮箱

    @DIYGender(message = "{my-gender.message}")
    private String gender;   // 性别

    private String address;  // 住址

    private Double salary;   // 薪资

    // 反序列化: 前端提交的日期 ===> 日期对象.
    // 序列化: 日期对象 ===> 日期字符串.
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birth; // 生日

}

