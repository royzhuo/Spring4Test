package foo.bar.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author roy.zhuo
 */
public class TestProperties {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties.xml");
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) context.getBean("dataSource");
        try {
            System.out.println("dataSource" + comboPooledDataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
