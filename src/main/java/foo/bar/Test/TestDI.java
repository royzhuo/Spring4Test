package foo.bar.Test;

import foo.bar.DI.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roy.zhuo
 */
public class TestDI {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("springDI.xml");
        UserService service= (UserService) context.getBean("userService");
        service.add();
    }
}
