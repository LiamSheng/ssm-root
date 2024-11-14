package linzi.mybatis.starter.mapper;

import linzi.mybatis.starter.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    // 按照 id 查询订单, 以及下单的客户的信息.
    Order getOrderByIdWithCustomer(Long id);

}
