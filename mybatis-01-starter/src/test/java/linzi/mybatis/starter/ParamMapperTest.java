package linzi.mybatis.starter;

import linzi.mybatis.starter.bean.Emp;
import linzi.mybatis.starter.mapper.EmpParamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ParamMapperTest {

    @Autowired
    private EmpParamMapper empParamMapper;

    @Test
    void testGetEmp() {
        System.out.println(empParamMapper.getEmpById((1L)));
    }

    @Test
    void testGetEmpList() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(5L);
        System.out.println(empParamMapper.getTheSecondEmpByIdList(list));
    }

    @Test
    void testGetEmpList2() {
        Map<String, String> map = new HashMap<>();
        map.put("tableName", "t_emp");
        System.out.println(empParamMapper.getEmpMap(map));
    }

    @Test
    void testGetEmpByIdAndName() {
        System.out.println(empParamMapper.getEmpByNameAndId(3L, "andy"));
    }

    @Test
    void testGetEmpByAgeAndName() {
        System.out.println(empParamMapper.getEmpByNameAndAge(20L, "andy"));
    }

    @Test
    void testGetEmpByEverything() {
        Map<String, Object> map = new HashMap<>();
        map.put("nameFromMap", "andy");
        List<Long> ageList = new ArrayList<>();
        ageList.add(2L);
        ageList.add(20L);
        Emp emp = new Emp();
        emp.setEmpSalary(777.77);
        System.out.println(empParamMapper.getEmpByEverything(3L, map, ageList, emp));
    }

}
