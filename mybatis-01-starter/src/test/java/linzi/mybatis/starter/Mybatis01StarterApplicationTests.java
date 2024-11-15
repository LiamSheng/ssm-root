package linzi.mybatis.starter;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        PageHelper.startPage(1, 5);
        /**
         * 紧跟着 startPage 之后的方法就会执行 SQL 分页了. 对之后的方法无效.
         * 原理: 使用了拦截器:
         * 1. 统计结果的总数量.
         * 2. 给原业务层SQL的limit关键字动态拼接.
         * ----------------------------------
         * 原理是 ThreadLocal, 同一个线程共享数据. 用完即把分页数据删除.
         */
        List<Emp> emps = empMapper.getAllEmp();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 响应前端需要的数据:
     * 1. 总页码数.
     * 2. 当前需要第几页数据.
     * 3. 这一页的数据.
     */
    @Test
    void pageHelperForFrontEndTest() {
        PageHelper.startPage(1, 5);
        List<Emp> emps = empMapper.getAllEmp();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
        // 以后给前端返回这个⬇
        PageInfo<Emp> pageInfo = new PageInfo<>(emps);
        System.out.println("当前页码: " + pageInfo.getPageNum());
        System.out.println("总页码: " + pageInfo.getPages());
        System.out.println("总记录数: " + pageInfo.getTotal());
        System.out.println("有没有下一页? " + pageInfo.isHasNextPage());
        System.out.println("有没有上一页? " + pageInfo.isHasPreviousPage());
        System.out.println("本页数据: " + pageInfo.getList());
    }

}
