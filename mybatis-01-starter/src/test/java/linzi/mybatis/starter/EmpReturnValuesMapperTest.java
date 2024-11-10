package linzi.mybatis.starter;

import linzi.mybatis.starter.bean.Emp;
import linzi.mybatis.starter.mapper.EmpReturnValuesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class EmpReturnValuesMapperTest {

    @Autowired
    private EmpReturnValuesMapper empReturnValuesMapper;

    /**
     * Test case for counting the number of employees.
     */
    @Test
    void testCountEmp() {
        // Prints the count of employees
        System.out.println(empReturnValuesMapper.countEmp());
    }

    /**
     * Test case for retrieving a map of all employees.
     */
    @Test
    void testGetEmpMap() {
        // Retrieves all employees as a map with employee IDs as keys
        Map<Integer, Emp> empMap = empReturnValuesMapper.getAll();
        // Prints the entire employee map
        System.out.println(empMap);
        // Prints the employee with ID 3
        System.out.println(empMap.get(3));
    }

    /**
     * Test case for retrieving an employee by ID.
     */
    @Test
    void testGetEmpById() {
        // Retrieves the employee with ID 1
        Emp emp = empReturnValuesMapper.getEmpById(1);
        // Prints the employee details
        System.out.println(emp);
    }
}
