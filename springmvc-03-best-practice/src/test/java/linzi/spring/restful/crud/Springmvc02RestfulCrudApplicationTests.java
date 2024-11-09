package linzi.spring.restful.crud;

import linzi.spring.restful.crud.bean.Employee;
import linzi.spring.restful.crud.dao.EmployeeDao;
import linzi.spring.restful.crud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试类，用于测试 EmployeeDao 的 CRUD 操作。
 */
@SpringBootTest
class Springmvc02RestfulCrudApplicationTests {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;

    /**
     * 测试 EmployeeDao 的 CRUD 方法。
     */
    @Test
    void testEmployeeDao() {
        // 测试根据ID获取员工信息
        Employee getById = employeeDao.getEmployeeById(4);
        System.out.println(getById);

        // 创建一个新的 Employee 对象，并设置测试值
        Employee toBeAdded = new Employee();
        toBeAdded.setName("John Doe");
        toBeAdded.setAge(30);
        toBeAdded.setEmail("johndoe@example.com");
        toBeAdded.setGender("Male");
        toBeAdded.setAddress("123 Main St, Springfield");
        toBeAdded.setSalary(50000.00);

        // 测试添加员工
        employeeDao.addEmployee(toBeAdded); // 取消注释以测试添加员工

        // 测试更新员工信息
        //employeeDao.updateEmployee(toBeAdded);

        // 测试删除员工
        //employeeDao.deleteEmployee(8);
    }

    @Test
    void testEmployeeService() {
        Employee toBeAdded = new Employee();
        toBeAdded.setId(10L);
        toBeAdded.setName("New John Doe");
        toBeAdded.setAddress("90 Shore St, SD");
        toBeAdded.setSalary(40000.00);

        employeeService.updateEmployee(toBeAdded);
        employeeService.deleteEmployee(10);
    }
}
