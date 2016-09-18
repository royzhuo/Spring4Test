package foo.bar.hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author roy.zhuo
 */
public class TestSpringHibernate {

    private ApplicationContext context;
    private DataSource dataSource;

    {
        //获取IOC容器
        context = new ClassPathXmlApplicationContext("SpringHibernate.xml");
    }

    @Test
    public void testDataSource() {
        dataSource = (DataSource) context.getBean("dataSource");
        try {
            System.out.println("DataSource:" + dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
