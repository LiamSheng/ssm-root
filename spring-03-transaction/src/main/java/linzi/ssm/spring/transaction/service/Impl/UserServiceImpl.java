package linzi.ssm.spring.transaction.service.Impl;

import linzi.ssm.spring.transaction.bean.Book;
import linzi.ssm.spring.transaction.dao.AccountDao;
import linzi.ssm.spring.transaction.dao.BookDao;
import linzi.ssm.spring.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    /**
     * checkout
     *
     * @param username 用户名
     * @param bookId   图书id
     * @param sold     卖出量
     */
    @Override
    public void checkout(String username, Integer bookId, Integer sold) {
        // 查询图书信息.
        Book book = bookDao.getBookById(bookId);
        // 扣减余额.
        accountDao.updateBalanceByUsername(username, book.getPrice().multiply(new BigDecimal(sold)));
        // 扣减库存.
        bookDao.updateStockById(bookId, sold);
    }

}
