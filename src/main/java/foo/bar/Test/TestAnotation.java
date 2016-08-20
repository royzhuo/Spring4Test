package foo.bar.Test;

import foo.bar.anotation.Controller.SpringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roy.zhuo
 */
public class TestAnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springAnotation.xml");
        SpringController springController = (foo.bar.anotation.Controller.SpringController) applicationContext.getBean("springController");
        springController.excute();
    }
}
