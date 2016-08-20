package foo.bar.AOP1;

/**
 * @author roy.zhuo
 */
public class CalaculatorImp implements Calaculator {

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
