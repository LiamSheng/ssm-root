package linzi.spring.restful.crud.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 有些敏感数据不应该展示, 需要一个"脱敏"的"缓冲区徐".
 * 返还数据的时候, 不透露性别和年龄.
 */
@Data
public class EmployeeRespVO {

    private int id;         // 主键

    private String name;     // 员工名字

    private String email;    // 邮箱

    private String address;  // 住址

    private Double salary;   // 薪资

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birth;
}
