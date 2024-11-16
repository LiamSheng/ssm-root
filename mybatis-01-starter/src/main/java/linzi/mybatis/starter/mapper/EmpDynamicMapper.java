package linzi.mybatis.starter.mapper;

import linzi.mybatis.starter.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 测试动态 SQL.
 */
@Mapper
public interface EmpDynamicMapper {

    // 按照员工名字和薪资查询员工.
    Emp selectEmpByNameAndSalary(@Param("name") String name,
                                 @Param("salary") BigDecimal salary);

    // 更新员工
    void updateEmp(Emp emp);

    // 批量查询
    List<Emp> getAllEmpIn(List<Integer> idList);

    // 批量插入
    void insertEmp(List<Emp> empList);

    // 批量修改
    void updateEmpByList(List<Emp> empList);
}
