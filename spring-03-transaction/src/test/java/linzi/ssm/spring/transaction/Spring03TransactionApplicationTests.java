package linzi.ssm.spring.transaction;

import linzi.ssm.spring.transaction.bean.Book;
import linzi.ssm.spring.transaction.dao.AccountDao;
import linzi.ssm.spring.transaction.dao.BookDao;
import linzi.ssm.spring.transaction.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;

@SpringBootTest
class Spring03TransactionApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate; // 和 QueryRunner 类似的功能.

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserService userService;

    @Test
    void testGetBookPriceById() {
        System.out.println(bookDao.getBookPriceById(4));
    }

    @Test
    void testCheckout() throws InterruptedException {
        userService.checkout("wangwu", 2, 4);
    }

    @Test
    void testConnection() {
        // com.zaxxer.hikari.pool.HikariProxyConnection 是最快的数据源.
        try {
            System.out.println(dataSource.getConnection().getClass());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFindBookById() {
        System.out.println(bookDao.getBookById(2));
    }

    @Test
    void testAddBook() {
        Book book = new Book();
        book.setBookName("西游记2");
        book.setPrice(new BigDecimal(20));
        book.setStock(30);
        bookDao.addBook(book);
    }

    @Test
    void testUpdateBookByIdAndStock() {
        bookDao.updateStockById(4, 2);
    }

    @Test
    void testDeleteBookById() {
        bookDao.deleteBookById(5);
    }

    @Test
    void testUpdateBalanceByUsername() {
        accountDao.updateBalanceByUsername("zhangsan", new BigDecimal(5));
    }

}
