package foo.bar.Test;

import foo.bar.domain.Address;
import foo.bar.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roy.zhuo
 */
public class TestSpring {


    public static void main(String[] args) {
        /*
        //配置ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //获取bean 1.可以通过id来获取bean实例 2.可以采用类来获取bean实例，但是ioc容器中bean实例必须是唯一的
        Person person = (Person) context.getBean("person");
        Person person2 = (Person) context.getBean("person6");
        //Person person=context.getBean(Person.class);


        //打印
        System.out.println("person----" + person);
        System.out.println("person2----" + person2);
        System.out.println("----------------------------------------");
        */
//bean的自动装配 autowire
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Person person = applicationContext.getBean(Person.class);
        System.out.println("person:" + person);

        Address address2 = (Address) applicationContext.getBean("address7");
        System.out.println(address2);
        address2 = (Address) applicationContext.getBean("address8");
        System.out.println(address2);



    }

}
