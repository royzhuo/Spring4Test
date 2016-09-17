package foo.bar.springTX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author roy.zhuo
 */
@Service("bookService")
public class BookServiceImp implements BookService {
    @Autowired
    BookDao bookDao;

    /*
    * Isolation:事物隔离级别 READ_COMMITTED 表示一个事物可以读取另一个事物已经提交的数据。该级别可以防止读取
    * 脏数据。推荐这个
    * rollbackFor:            Class对象数组，必须继承自Throwable 导致事务回滚的异常类数组
    * rollbackForClassName:   类名数组，必须继承自Throwable 导致事务回滚的异常类名字数组
    * noRollbackFor:          Class对象数组，必须继承自Throwable	不会导致事务回滚的异常类数组
    * noRollbackForClassName: 类名数组，必须继承自Throwable	不会导致事务回滚的异常类名字数组
    *timeout                  int 超时时间 s
    * readOnly                 boolean      读写或只读事务，默认读写
    * value                   String    可选的限定描述符，指定使用的事务管理器
    * */


    @Override
    /*@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED,
        rollbackFor = {RuntimeException.class})*/
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED,
        rollbackFor = {RuntimeException.class}, readOnly = false,
        timeout = 5)
    public void buyBook(String username, Integer bno) {

        try {
            Thread.sleep(5000);
            //每买一次库存减一
            bookDao.updateBookStroge(bno);
            //更新账户余额
            bookDao.updatePersonPrice(username, bookDao.getBookPrice(bno));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
