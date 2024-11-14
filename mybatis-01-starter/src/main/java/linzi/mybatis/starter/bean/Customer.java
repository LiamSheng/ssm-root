package linzi.mybatis.starter.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Customer entity class representing a customer record.
 * Uses Lombok annotations for boilerplate code reduction.
 */
@Data
@Component
public class Customer {

    /**
     * The unique identifier for the customer.
     */
    private Long id;

    /**
     * The name of the customer.
     */
    private String customerName;

    /**
     * The phone number of the customer.
     */
    private String phone;

    /**
     * A list all orders made by this customer.
     */
    private List<Order> orders;

}
