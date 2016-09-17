package foo.bar.AOP2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roy.zhuo
 */
public class Main {
    public static void main(String[] args) {
        //加载IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringAOP.xml");
        //获取bean
        Calaculator calaculator = (Calaculator) applicationContext.getBean("calaculator");
        //test
        int result = calaculator.chu(10, 10);
        System.out.println("result:" + result);

        //返回通知
        int afterReturnResult = calaculator.add(20, 20);
        System.out.println("afterReturnResult:" + afterReturnResult);
        //异常通知

        //环绕通知
        int aroundResult = calaculator.cheng(10, 8);
        System.out.println("aroundResult:" + aroundResult);
    }
}
