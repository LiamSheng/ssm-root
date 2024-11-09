package linzi.spring.restful.crud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 这是直接和数据库交互的 Java bean, 不需要任何注解.
 * 将前端传来的值做封装以及数据校验的工作归给 VO 层的 EmployeeAddVO.
 * 同时需要将 VO 转化为能和数据库交互的此对象.
 * 和数据库交互的类不需要做数据校验. 因为那是其他 VO 的事情.
 */
@Data
public class Employee {

    private Long id;         // 主键

    private String name;     // 员工名字

    private Integer age;     // 年龄

    private String email;    // 邮箱

    private String gender;   // 性别

    private String address;  // 住址

    private Double salary;   // 薪资

    private Date birth;  // 生日

}

