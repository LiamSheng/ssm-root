package linzi.ssm.spring.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 造作数据库:
 * 1. 导入包.
 * 2. application.properties 中导入 spring.datasource.*
 * 3. 直接使用 DataSource 和 JdbcTemplate.
 */
@EnableTransactionManagement // 开启基于注释的自动事务管理
@SpringBootApplication
public class Spring03TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring03TransactionApplication.class, args);
	}

}
