package linzi.ssm.spring.transaction.service;

public interface UserService {

    void checkout(String username, Integer bookId, Integer sold) throws InterruptedException;

}
