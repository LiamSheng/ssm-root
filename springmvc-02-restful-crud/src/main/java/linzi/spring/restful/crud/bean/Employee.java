package linzi.spring.restful.crud.bean;

import lombok.Data;

@Data
public class Employee {

    private Long id;         // 主键

    private String name;     // 员工名字

    private Integer age;     // 年龄

    private String email;    // 邮箱

    private String gender;   // 性别

    private String address;  // 住址

    private Double salary;   // 薪资

}

