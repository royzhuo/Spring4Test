package foo.bar.AOP2;

import org.springframework.stereotype.Component;

/**
 * @author roy.zhuo
 */

@Component("calaculator")
public class CalaculatorImp implements Calaculator {
    CalaculatorImp() {
        System.out.println("CalacutorImp");
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int div(int a, int b) {
        return a - b;
    }

    @Override
    public int cheng(int a, int b) {
        return a * b;
    }

    @Override
    public int chu(int a, int b) {
        return a / b;
    }


}
