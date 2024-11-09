package linzi.mybatis.starter;

import linzi.mybatis.starter.dao.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mybatis01StarterApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    void testMybatisSearch() {
        System.out.println(empMapper.getEmpById(1));
    }

}
