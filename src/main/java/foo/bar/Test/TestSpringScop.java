package foo.bar.Test;

import foo.bar.domain.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roy.zhuo
 */
public class TestSpringScop {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml");
        Address address = context.getBean(Address.class);
    }
}
