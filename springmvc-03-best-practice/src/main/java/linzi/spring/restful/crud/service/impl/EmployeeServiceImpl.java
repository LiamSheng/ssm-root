package linzi.spring.restful.crud.service.impl;

import linzi.spring.restful.crud.bean.Employee;
import linzi.spring.restful.crud.dao.EmployeeDao;
import linzi.spring.restful.crud.exception.BusinessException;
import linzi.spring.restful.crud.exception.BusinessExceptionEnum;
import linzi.spring.restful.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 员工服务实现类，提供员工相关的业务逻辑。
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;
    private JdbcTemplate jdbcTemplate;

    /**
     * 注入JdbcTemplate依赖
     *
     * @param jdbcTemplate Spring提供的JdbcTemplate
     */
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 注入EmployeeDao依赖
     *
     * @param employeeDao 员工数据访问对象
     */
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * 根据员工ID获取员工信息
     *
     * @param id 员工ID
     * @return 员工对象
     */
    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    /**
     * 保存员工信息
     *
     * @param employee 员工对象
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    /**
     * 更新员工信息
     *
     * @param employee 员工对象
     */
    @Override
    public void updateEmployee(Employee employee) {
        // 判空处理, 否则更新时会将原有的值设置为 null.
        if (employee.getId() == null) {
            // 中断业务的时候, 要抛出异常, 通过异常机制让上层感知到业务终止的原因.
            throw new BusinessException(BusinessExceptionEnum.USER_UPDATE_FAIL);
        }

        Employee employeeGetById = this.employeeDao.getEmployeeById(employee.getId().intValue());

        // 只用页面带来的值覆盖原来的值, 否则保持原来的值.
        if (StringUtils.hasText(employee.getName())) { // 判断 name 不是空串.
            employeeGetById.setName(employee.getName().trim());
        }
        if (employee.getAge() != null) { // 判断 age 不是空
            employeeGetById.setAge(employee.getAge());
        }
        if (StringUtils.hasText(employee.getEmail())) { // 判断 email 不是空串
            employeeGetById.setEmail(employee.getEmail().trim());
        }
        if (StringUtils.hasText(employee.getGender())) { // 判断 gender 不是空串
            employeeGetById.setGender(employee.getGender().trim());
        }
        if (StringUtils.hasText(employee.getAddress())) { // 判断 address 不是空串
            employeeGetById.setAddress(employee.getAddress().trim());
        }
        if (employee.getSalary() != null) { // 判断 salary 不是空
            employeeGetById.setSalary(employee.getSalary());
        }

        employeeDao.updateEmployee(employeeGetById); // 更新数据库中的员工信息.
    }

    /**
     * 根据员工ID删除员工
     *
     * @param id 员工ID
     */
    @Override
    public void deleteEmployee(int id) {
        try {
            employeeDao.deleteEmployee(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取所有员工信息
     *
     * @return 员工列表
     */
    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

}