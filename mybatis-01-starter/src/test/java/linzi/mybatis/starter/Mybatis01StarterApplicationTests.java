package linzi.mybatis.starter;

import linzi.mybatis.starter.bean.Emp;
import linzi.mybatis.starter.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatis01StarterApplicationTests {

    @Autowired // 容器中是 MyBatis 为每个 Mapper 接口创建的代理对象.
    private EmpMapper empMapper;

    /**
     * 测试 MyBatis 获取员工信息.
     */
    @Test
    void testMybatisSearch() {
        System.out.println(empMapper.getEmpById(1));
    }

    /**
     * 测试 MyBatis 插入员工信息.
     */
    @Test
    void testMybatisInsert() {
        Emp emp = new Emp();
        emp.setEmpName("LZsS");
        emp.setAge(18);
        emp.setEmpSalary(40000.00);
        empMapper.addEmp(emp);
        System.out.println("新添加的emp的id是: " + emp.getId());
    }

    /**
     * 测试 MyBatis 更新员工信息.
     */
    @Test
    void testMybatisUpdate() {
        Emp emp = empMapper.getEmpById(1);
        emp.setEmpName(emp.getEmpName() + "updated");
        empMapper.updateEmp(emp);
    }

    /**
     * 测试 MyBatis 删除员工信息.
     */
    @Test
    void testMybatisDelete() {
        empMapper.deleteEmpById(4);
    }

    /**
     * 测试 MyBatis 获取所有员工信息.
     */
    @Test
    void testMybatisFindAll() {
        List<Emp> emps = empMapper.getAllEmp();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

}
