package foo.bar.AOP1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * @author roy.zhuo
 */
//动态代理对象
public class CalaculatorLoggingProfxy {
    //代理的目标对象
    private Calaculator tagter;

    public CalaculatorLoggingProfxy(Calaculator calaculator) {
        this.tagter = calaculator;
    }

    //动态代理方法
    public Calaculator getCalaculatorByProfxy() {
        Calaculator calaculator = null;
        //　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
        ClassLoader loader = tagter.getClass().getClassLoader();
        //一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，
        // 那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
        Class<Calaculator>[] interfaces = new Class[]{Calaculator.class};
        //一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
        InvocationHandler h = new InvocationHandler() {
            /*
            *
            * 1.proxy我们所代理的那个真实对象
            * 2.method我们所要调用真实对象的某个方法的Method对象
            * 3.args 调用真实对象某个方法时接受的参数
            * */

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //方法名
                String methodName = method.getName();
                //参数
                List params = Arrays.asList(args);
                System.out.println("方法名:" + methodName + " 参数:" + params);

                int result = 0;
                try {
                    //方法执行(方法执行前的操作也称作aop的前置通知)
                    result = (Integer) method.invoke(tagter, args);
                    //方法顺利进行则称作aop返回通知

                } catch (Exception e) {
                    //aop的异常通知
                    System.out.println("出异常了" + e.getMessage());
                }

                return result;
            }
        };
        //aop的后置通知，不管有没有异常都会执行，首页没有返回值
        calaculator = (Calaculator) Proxy.newProxyInstance(loader, interfaces, h);
        return calaculator;
    }

}
