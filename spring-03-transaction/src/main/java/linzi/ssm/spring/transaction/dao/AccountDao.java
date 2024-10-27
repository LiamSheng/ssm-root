package linzi.ssm.spring.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 按照 username 扣减账户余额.
     * @param username 用户名
     * @param spent 需要扣减的金额.
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBalanceByUsername(String username, BigDecimal spent) {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, spent, username);
    }
}
