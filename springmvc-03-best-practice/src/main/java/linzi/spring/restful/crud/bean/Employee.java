package linzi.spring.restful.crud.bean;

import jakarta.validation.constraints.*;
import linzi.spring.restful.crud.annotation.DIYGender;
import lombok.Data;

@Data
public class Employee {
    private Long id;         // 主键

    private String name;     // 员工名字

    @NotNull
    @Max(value=150, message = "最大年龄150")
    @Min(value=18, message = "最小年龄18岁")
    private Integer age;     // 年龄

//    @Email(message = "错误的email格式!")
    @Email
    private String email;    // 邮箱

//    @Pattern(regexp = "^男|女$", message = "Male/Female")
    @DIYGender(message = "{my-gender.message}")
    private String gender;   // 性别

    private String address;  // 住址

    private Double salary;   // 薪资

}

