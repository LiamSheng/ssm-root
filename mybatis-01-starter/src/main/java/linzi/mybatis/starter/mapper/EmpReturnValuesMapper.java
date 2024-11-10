package linzi.mybatis.starter.mapper;

import linzi.mybatis.starter.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpReturnValuesMapper {

    /**
     * Counts the number of employees.
     *
     * @return the total number of employees
     */
    Long countEmp();

    /**
     * Retrieves a list of all employees.
     *
     * @return a list containing all employee objects
     */
    List<Emp> getEmpList();

    /**
     * Retrieves all employees as a map with employee IDs as keys.
     *
     * @return a map where the key is the employee ID and the value is the employee object
     */
    @MapKey("id")
    Map<Integer, Emp> getAll();

    /**
     * Retrieves an employee by their ID.
     *
     * @param id the ID of the employee to retrieve
     * @return the employee object with the specified ID
     */
    Emp getEmpById(Integer id);
}
