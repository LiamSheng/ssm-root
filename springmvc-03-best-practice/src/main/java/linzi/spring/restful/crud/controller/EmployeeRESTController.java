package linzi.spring.restful.crud.controller;

import jakarta.validation.Valid;
import linzi.spring.restful.crud.bean.Employee;
import linzi.spring.restful.crud.common.R;
import linzi.spring.restful.crud.service.EmployeeService;
import linzi.spring.restful.crud.vo.req.EmployeeAddVO;
import linzi.spring.restful.crud.vo.req.EmployeeUpdateVO;
import linzi.spring.restful.crud.vo.resp.EmployeeRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 复杂的跨域服务器会发送两个请求:
 * 1. options请求, 预检请求, 浏览器会发送 options 请求, 询问服务器是否允许跨域.
 * 2. 真正的请求.
 */
@CrossOrigin // 原理: 服务器给浏览器的响应头中添加字段: Access-Control-Allow-Origin = *
@RequestMapping(value = "/api/v1")
@RestController
public class EmployeeRESTController {

    /**
     * code：业务的状态码，200是成功，剩下都是失败；前后端将来会一起商定不同的业务状态码前端要显示不同效果。
     * msg：服务端返回给前端的提示消息
     * data:服务器返回给前端的数据
     * {
     * "code":300，
     * "msg"：“余额不足"，
     * "data":null
     * }
     * 前端统一处理：
     * 1、前端发送请求，接受服务器数据
     * 2、判断状态码，成功就显示数据，失败就显示提示消息（或者执行其他操作）。
     */

    EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public R<Object> getEmployee(@PathVariable("id") int id) {
        Employee employeeById = employeeService.getEmployeeById(id);
//        R<Object> r = new R<>();
//        r.setCode(200);
//        r.setMsg("ok");
//        r.setData(employeeById);
        return R.ok();
    }

    @DeleteMapping(value = "/employee/{id}")
    public R<Employee> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return R.ok();
    }

    @PostMapping("/employee")
    public R<EmployeeAddVO> addEmployee(@RequestBody @Validated EmployeeAddVO employeeVO) {
        // 将获取前端数据并封装起来的 VO 对象, 转换为直接和数据库操作的 DO 对象.
        Employee employeeDO = new Employee();
//        employeeDO.setId(employeeVO.getId());
//        employeeDO.setName(employeeVO.getName());
//        employeeDO.setAge(employeeVO.getAge());
//        employeeDO.setEmail(employeeVO.getEmail());
//        employeeDO.setGender(employeeVO.getGender());
//        employeeDO.setAddress(employeeVO.getAddress());
//        employeeDO.setSalary(employeeVO.getSalary());

        // Spring 提供了专门的工具转换对象. 属性对拷.
        BeanUtils.copyProperties(employeeVO, employeeDO);
        employeeService.saveEmployee(employeeDO);
        return R.ok();
    }

    /**
     * 没有使用全局异常处理器处理验证异常的情况.
     */
    @PutMapping("/employee")
    public R<Object> updateEmployee(@RequestBody @Validated EmployeeUpdateVO employeeUpdateVO) {
//        if (!bindingResult.hasErrors()) {
        System.out.println("updateEmployee...");
        Employee employeeDO = new Employee();
        BeanUtils.copyProperties(employeeUpdateVO, employeeDO);
        employeeService.updateEmployee(employeeDO);
        return R.ok();
//        }
//        else {
//            Map<String, String> errors = new HashMap<String, String>();
//            // 拿到所有属性错误的信息.
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                // 获取属性名
//                String field = fieldError.getField();
//                // 获取错误信息
//                String defaultMessage = fieldError.getDefaultMessage();
//                errors.put(field, defaultMessage);
//            }
//            return R.error(500, "校验失败", errors);
//        }
    }

    @GetMapping(value = "/employees")
    public R<List<EmployeeRespVO>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();

        List<EmployeeRespVO> collect = employees.stream().map(employee -> {
            EmployeeRespVO employeeRespVO = new EmployeeRespVO();
            BeanUtils.copyProperties(employee, employeeRespVO);
            return employeeRespVO;
        }).collect(Collectors.toList());

        return R.ok(collect);
    }

}
