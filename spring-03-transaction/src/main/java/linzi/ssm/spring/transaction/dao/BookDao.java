package linzi.ssm.spring.transaction.dao;

import linzi.ssm.spring.transaction.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.MANDATORY)
    public BigDecimal getBookPriceById(Integer BookId) {
        String sql = "select price from book where id = ?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, BookId);
    }

    @Transactional(readOnly = true)
    public Book getBookById(int id) {
        // 定义查询图书的 sql.
        String sql = "select * from book where id = ?";
        //执行查询

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    public void addBook(Book book) {
        String sql = "insert into book(bookName,price,stock) values(?,?,?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock());
    }

    /**
     *按照图书id更新图书的库存.
     * @param BookId 图书的id.
     * @param sold 卖出去的本数.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateStockById(Integer BookId, Integer sold) {
        String sql = "update book set stock = stock-? where id = ?";
        jdbcTemplate.update(sql, sold, BookId);
    }

    public void deleteBookById(Integer BookId) {
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql, BookId);
    }

}
