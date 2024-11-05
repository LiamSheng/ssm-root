package linzi.spring.restful.crud.dao.impl;

import linzi.spring.restful.crud.bean.Employee;
import linzi.spring.restful.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * EmployeeDaoImpl 类实现了 EmployeeDao 接口，提供了对 Employee 对象的数据库操作。
 */
@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据员工 ID 获取员工信息。
     *
     * @param id 员工的唯一标识符
     * @return 对应的员工对象，如果未找到则返回 null
     */
    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    /**
     * 添加一个新的员工到系统中。
     *
     * @param employee 要添加的员工对象
     */
    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, age, email, gender, address, salary) VALUES (?, ?, ?, ?, ?, ?)";
        int updatedRaws = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary());
        System.out.println("added " + updatedRaws + " row(s).");
    }

    /**
     * 更新现有员工的信息。
     * 注意: 修改时传入员工所有属性值. 不修改的传原始值, 否则代表旧值更新为 null.
     *
     * @param employee 包含更新信息的员工对象
     */
    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ? WHERE id = ?";
        int updatedRaws = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId());
        System.out.println("updated " + updatedRaws + " row(s).");
    }

    /**
     * 根据员工 ID 删除员工。
     *
     * @param id 员工的唯一标识符
     */
    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        int deletedRaw = jdbcTemplate.update(sql, id);
        System.out.println("deleted " + deletedRaw + " row.");
    }

}
