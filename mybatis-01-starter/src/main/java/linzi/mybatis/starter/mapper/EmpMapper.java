package linzi.mybatis.starter.mapper;

import linzi.mybatis.starter.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 使用 Mybatis 不再需要实例化 DAO 接口了.
 * 这个接口用于定义对数据库表 `Emp` 的操作方法。
 * 通过 Mybatis 的 Mapper 注解，我们可以让 Spring 自动生成该接口的实现。
 */
@Mapper // 告诉 Spring 这是 Mybatis 操作数据库使用的接口
public interface EmpMapper {

    // 开启驼峰命名自动映射封装之后就不需要 emp_name AS empName ...

    /**
     * 根据 ID 获取员工信息。
     * @param id 员工 ID
     * @return 对应的员工对象
     */
    Emp getEmpById(int id);

    /**
     * 添加员工信息。
     * @param emp 要添加的员工对象
     */
    void addEmp(Emp emp);

    /**
     * 更新员工信息。
     * @param emp 包含更新信息的员工对象
     */
    void updateEmp(Emp emp);

    /**
     * 根据 ID 删除员工信息。
     * @param id 要删除的员工 ID
     */
    void deleteEmpById(int id);

    /**
     * 查询所有员工信息.
     * @return 所有员工实例的 list 集合.
     */
    List<Emp> getAllEmp();

}
