package foo.bar.Test;

import foo.bar.domain.Address;
import foo.bar.domain.Car;
import foo.bar.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roy.zhuo
 */
public class TestSpel {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
        Address address = (Address) context.getBean("address2");
        System.out.println(address);
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
