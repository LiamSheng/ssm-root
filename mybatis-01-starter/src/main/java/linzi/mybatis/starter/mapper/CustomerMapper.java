package linzi.mybatis.starter.mapper;

import linzi.mybatis.starter.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {

    Customer selectCustomerAndAllOrdersById(Integer id);

}
