package linzi.spring.restful.crud.vo.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import linzi.spring.restful.crud.annotation.DIYGender;
import lombok.Data;

@Data
public class EmployeeUpdateVO {
    @NotNull
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

}