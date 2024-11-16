package linzi.mybatis.starter.mapper;

import linzi.mybatis.starter.bean.Customer;
import linzi.mybatis.starter.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HierarchicalQueryMapper {

    // [自动分布查询机制] 由 客户id 查找出客户, 以及这个客户所有的订单信息.
    Customer getCustomerAndAllOrdersById(Long id);

    // [自动分步查询] 由 订单 id 查找出订单, 以及下单的客户信息.
    Order getOrderByIdAndCustomer(Long id);

    // 查询所有的客户
    List<Customer> getAllCustomers();

    // 查询所有订单
    List<Order> getOrders();

    // [超级分步查询的坑] 由 订单 id 查找出订单, 以及下单的客户信息, 再超找出这个客户的所有订单.

    // 以上查询可以分解为:
    // 1. 按照 用户id 查找出用户:
    Customer getCustomerById(Long id);

    // 2. 按照 用户id 查找出所有订单:
    List<Order> getAllOrders(Long id);

    // 3. 封装客户的订单, 依靠用户和订单之间的依赖关系.
    // 需要我们自己手动调用两次查询.

}
