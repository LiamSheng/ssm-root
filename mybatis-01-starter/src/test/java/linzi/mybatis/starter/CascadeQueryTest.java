package linzi.mybatis.starter;

import linzi.mybatis.starter.mapper.CustomerMapper;
import linzi.mybatis.starter.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CascadeQueryTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void getOrderAndCustomerByOrderId() {
        System.out.println(orderMapper.getOrderByIdWithCustomer(1L));
        System.out.println(orderMapper.getOrderByIdWithCustomer(2L));
        System.out.println(orderMapper.getOrderByIdWithCustomer(3L));
    }

    @Test
    void getCustomerAndAllOrdersById() {
        System.out.println(customerMapper.selectCustomerAndAllOrdersById(1));
    }

}
