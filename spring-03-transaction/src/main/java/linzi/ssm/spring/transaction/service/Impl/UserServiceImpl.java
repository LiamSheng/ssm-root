package linzi.ssm.spring.transaction.service.Impl;

import linzi.ssm.spring.transaction.bean.Book;
import linzi.ssm.spring.transaction.dao.AccountDao;
import linzi.ssm.spring.transaction.dao.BookDao;
import linzi.ssm.spring.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    /**
     * checkout, 用户结账期间抛出异常, 账户余额回滚, 库存不回滚.
     *
     * @param username 用户名
     * @param bookId   图书id
     * @param sold     卖出量
     */
    @Transactional()
    @Override
    public void checkout(String username, Integer bookId, Integer sold) throws InterruptedException {
        // 查询图书信息.
        Book book = bookDao.getBookById(bookId);

        // 模拟超时
        Thread.sleep(4000); // 放在末尾事务不会回滚.

        // 扣减余额 - REQUIRED
        accountDao.updateBalanceByUsername(username, book.getPrice().multiply(new BigDecimal(sold)));

        // 扣减库存 - REQUIRES_NEW
        bookDao.updateStockById(bookId, sold);

        int i = 1/0;
    }

}
