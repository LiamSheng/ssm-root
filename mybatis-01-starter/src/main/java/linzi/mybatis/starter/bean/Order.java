package linzi.mybatis.starter.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Order entity class representing an order record.
 * Utilizes Lombok annotations for boilerplate code reduction.
 */
@Data
@Component
public class Order {

    /**
     * The unique identifier for the order.
     */
    private Long id;

    /**
     * The address associated with the order.
     */
    private String address;

    /**
     * The total amount for the order.
     */
    private BigDecimal amount;

    /**
     * The ID of the customer who placed the order.
     */
    private Long customerId;

    // 一对一, 订单对应的客户.
    private Customer customer;
}
