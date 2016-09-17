package foo.bar.springTX;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author roy.zhuo
 */
public class TestSpringTx {

    private JdbcTemplate jdbcTemplate = null;
    private DataSource dataSource = null;
    private ApplicationContext context = null;
    private BookDao bookDao = null;

    private BookService bookService = null;
    private ProgationService progationService;




    {
        //加载ioc容器
        context = new ClassPathXmlApplicationContext("springTX.xml");
        //获取bean
        bookDao = (BookDao) context.getBean("bookDao");
        bookService = context.getBean(BookService.class);
        progationService = context.getBean(ProgationService.class);
    }

    @Test
    public void testConnection() {
        dataSource = context.getBean(DataSource.class);

        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBookDao() {
        //更新库存
        bookDao.updateBookStroge(1);
        int price = bookDao.getBookPrice(1);
        System.out.println("price:" + price);
        bookDao.updatePersonPrice("roy", price);
    }

    @Test
    public void testBookService() {
        bookService.buyBook("roy", 1);
    }

    @Test
    public void testProgationService() {
        progationService.buyBooks("roy", Arrays.asList(2, 1));
    }
}
