package foo.bar.AOP1;

/**
 * @author roy.zhuo
 */
public class Main {
    public static void main(String[] args) {
        Calaculator calaculator = new CalaculatorImp();
        //如果想要对接口方法进行事物管理（如日志，参数验证等）需要用到aop（动态代理对象的实现）
        CalaculatorLoggingProfxy calaculatorLoggingProfxy = new CalaculatorLoggingProfxy(calaculator);
        Calaculator calaculator1 = calaculatorLoggingProfxy.getCalaculatorByProfxy();
        int result = calaculator1.chu(10, 1);
        System.out.println("result:" + result);
    }
}
