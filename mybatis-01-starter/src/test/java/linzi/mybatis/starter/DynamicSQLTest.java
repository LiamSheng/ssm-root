package linzi.mybatis.starter;

import linzi.mybatis.starter.bean.Emp;
import linzi.mybatis.starter.mapper.EmpDynamicMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DynamicSQLTest {

    @Autowired
    private EmpDynamicMapper empDynamicMapper;

    @Test
    void selectEmpByNameAndSalaryTest() {
        // 没有动态SQL时, Parameters: (String), 40000(BigDecimal)
        empDynamicMapper.selectEmpByNameAndSalary(null, BigDecimal.valueOf(30000));
    }

    @Test
    void updateEmpTest() {
        Emp emp = new Emp();
        emp.setId(5);
        // emp.setEmpName("Linzi");
//        emp.setAge(20);
//        emp.setEmpSalary(30000.0);
        empDynamicMapper.updateEmp(emp);
    }

    @Test
    void chooseWhenOtherwiseTest() {
        empDynamicMapper.selectEmpByNameAndSalary(null, BigDecimal.valueOf(300));
    }

    @Test
    void getAllEmpInTest() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(5);
        List<Emp> empList = empDynamicMapper.getAllEmpIn(idList);
        System.out.println(empList);
    }

    @Test
    void insertEmpTest() {
        List<Emp> empList = new ArrayList<>();
        Emp emp1 = new Emp();
        emp1.setId(1);
        emp1.setEmpName("Alice");
        emp1.setAge(30);
        emp1.setEmpSalary(70000.0);
        Emp emp2 = new Emp();
        emp2.setId(2);
        emp2.setEmpName("Bob");
        emp2.setAge(25);
        emp2.setEmpSalary(50000.0);
        Emp emp3 = new Emp();
        emp3.setId(3);
        emp3.setEmpName("Charlie");
        emp3.setAge(35);
        emp3.setEmpSalary(90000.0);
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empDynamicMapper.insertEmp(empList);
    }

    @Test
    @Transactional
    void updateEmpByListTest() {
        List<Emp> empList = new ArrayList<>();
        Emp emp1 = new Emp();
        emp1.setId(9);
        emp1.setEmpName("C-Alice");
        emp1.setAge(30);
        emp1.setEmpSalary(70000.0);
        Emp emp2 = new Emp();
        emp2.setId(10);
        emp2.setEmpName("CB-ob");
        emp2.setAge(25);
        emp2.setEmpSalary(50000.0);
        Emp emp3 = new Emp();
        emp3.setId(11);
        emp3.setEmpName("CCha-rlie");
        emp3.setAge(35);
        emp3.setEmpSalary(90000.0);
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empDynamicMapper.updateEmpByList(empList);
    }

}
