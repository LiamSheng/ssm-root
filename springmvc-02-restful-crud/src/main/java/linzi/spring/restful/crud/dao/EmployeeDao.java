package linzi.spring.restful.crud.dao;

import linzi.spring.restful.crud.bean.Employee;

/**
 * EmployeeDao 接口定义了基本的 CRUD 操作，用于管理 Employee 对象。
 */
public interface EmployeeDao {

    /**
     * 根据员工 ID 获取员工信息。
     * @param id 员工的唯一标识符
     * @return 对应的员工对象，如果未找到则返回 null
     */
    Employee getEmployeeById(int id);

    /**
     * 添加一个新的员工到系统中。
     * @param employee 要添加的员工对象
     */
    void addEmployee(Employee employee);

    /**
     * 更新现有员工的信息。
     * @param employee 包含更新信息的员工对象
     */
    void updateEmployee(Employee employee);

    /**
     * 根据员工 ID 删除员工。
     * @param id 员工的唯一标识符
     */
    void deleteEmployee(int id);

}
