package linzi.mybatis.starter.mapper;

import linzi.mybatis.starter.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface EmpParamMapper {

    /**
     * 根据员工的唯一标识获取员工信息.
     *
     * @param id 员工的唯一标识
     * @return 具有对应id的员工对象
     */
    Emp getEmpById(Long id);

    /**
     * 获取 List 中第二个 id 的员工.
     *
     * @param idList 包含多个员工标识的列表
     * @return 具有列表中第二个id的员工对象
     */
    Emp getTheSecondEmpByIdList(List<Long> idList);

    /**
     * 添加新员工的信息.
     *
     * @param emp 要添加的员工对象
     */
    void addEmp(Emp emp);

    /**
     * 根据给定的参数 map 获取员工信息.
     *
     * @param map 包含查询条件的键值对
     * @return 满足查询条件的员工对象
     */
    Emp getEmpMap(Map<String, String> map);

    //--------------- 以下是多参数测试 ---------------
    Emp getEmpByNameAndId(Long id, String name);

    // 多参数情况下最推荐的方式.
    Emp getEmpByNameAndAge(@Param("pAge") Long age, @Param("pName") String name);

    Emp getEmpByEverything(@Param("pId") Long id,
                           @Param("pName") Map<String, Object> map,
                           @Param("pAge") List<Long> ages,
                           @Param("pSalary") Emp emp);

}
