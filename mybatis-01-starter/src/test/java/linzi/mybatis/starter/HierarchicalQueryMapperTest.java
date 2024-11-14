package linzi.mybatis.starter;

import linzi.mybatis.starter.bean.Customer;
import linzi.mybatis.starter.bean.Order;
import linzi.mybatis.starter.mapper.HierarchicalQueryMapper;
import linzi.mybatis.starter.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HierarchicalQueryMapperTest {

    @Autowired
    private Customer customer;

    @Autowired
    private Order order;

    @Autowired
    private HierarchicalQueryMapper hierarchicalQueryMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void getCustomerByIdTest() {
        System.out.println(hierarchicalQueryMapper.getCustomerById(1L));
    }

    @Test
    void getAllOrdersTest() {
        System.out.println(hierarchicalQueryMapper.getAllOrders(1L));
    }

    @Test
    void setAllOrdersForCustomerTest() {
        customer = hierarchicalQueryMapper.getCustomerById(1L);
        List<Order> orders = hierarchicalQueryMapper.getAllOrders(1L);
        customer.setOrders(orders);
        System.out.println(customer);
    }

    @Test
    void getCustomerAndAllOrdersByIdTest() {
        System.out.println(hierarchicalQueryMapper.getCustomerAndAllOrdersById(1L));
    }

    @Test
    void getOrderByIdAndCustomer() {
        System.out.println(hierarchicalQueryMapper.getOrderByIdAndCustomer(1L));
    }

    @Test
    void findAllOrdersByOneOrderIdTest() {
        order = hierarchicalQueryMapper.getOrderByIdAndCustomer(1L);
        customer = hierarchicalQueryMapper.getCustomerAndAllOrdersById(order.getCustomerId());
        List<Order> orders = hierarchicalQueryMapper.getAllOrders(customer.getId());
        order.setCustomer(customer);
        order.getCustomer().setOrders(orders);
        System.out.println(order);
    }

    @Test
    void lazyLoadingTest() throws InterruptedException {
        order = hierarchicalQueryMapper.getOrderByIdAndCustomer(1L);
        System.out.println(order); // 延迟加载不会生效, 因为 Customer 依赖 Order.
        System.out.println(order.getAddress());
        Thread.sleep(3000);
        System.out.println(order.getCustomer());
    }

    @Test
    void getAllCustomersAllOrdersTest() {
        System.out.println(hierarchicalQueryMapper.getAllCustomers());
    }

}
