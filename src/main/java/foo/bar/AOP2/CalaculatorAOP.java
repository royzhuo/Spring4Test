package foo.bar.AOP2;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author roy.zhuo
 *         SpringAop事物管理通过AspectJ
 *         切面:横切（如日志，验证切面等）关注点被模块化的特殊对象
 *         通知：切面必须完成的工作（如数据验证等）
 *         连接点(JoinPoint):程序执行的某个特定位置，如某个方法执行前，执行后，抛出异常后
 *         切点（pointcut）：每个类拥有多个连接点。如calImp类的所有方法实际上都是连接点，连接点是程序类中客观存在的事物
 *         ，aop通过切点定位到特定的连接点。如：连接点相当于数据库中的记录，切点相当于查询条件。一个切点可以有多个连接点。
 */
@Order(2)
@Aspect
@Component
public class CalaculatorAOP {

    /*
    * execution(* com.lei.service..*.*(..))表示切入点是com.lei.sevice包中的任意一个类的任意方法
    *
    *
    *execution(public * com.lei.demo.aop.aspectj.CustomerBo.addCustomer(..))"是Aspect的切入点表达式，
    * 其中，*代表返回类型，
    * 后边的就要定义要拦截的方法名，
    * 这里写的的是com.lei.demo.aop.aspectj.CustomerBo.addCustomer表示拦截CustomerBo中的addCustomer方法，
    * (..)代表参数匹配，此处表示匹配任意数量的参数，可以是0个也可以是多个，如果你确定这个方法不需要使用参数可以直接用()，
    * 还可以使用(*)来匹配一个任意类型的参数，还可以使用 (* , String)，
    * 这样代表匹配两个参数，第二个参数必须是String 类型的参数
    *
    * */


    /*重用切入点表达式
    * 1.定义一个方法，声明切入点表达式，一般方法不用添加其它代码
    * 2.用@PointCut来声明切入点表达式
    * */

    @Pointcut("execution(* foo.bar.AOP2.Calaculator.*(..))")
    public void declareJoinPointExpression() {
    }

    //before(前置通知) :在目标方法执行前执行,可以做参数验证等情况
    @Before("execution(public int foo.bar.AOP2.Calaculator.chu(int,int))")
    public void testChuBefore(JoinPoint joinPoint) {
        System.out.println("Before-->除法方法了");
        System.out.println("方法名:" + joinPoint.getSignature().getName() + "before");
        System.out.println("参数:" + Arrays.asList(joinPoint.getArgs()));
    }

    //后置通知:目标方法执行到最后开始执行的，不管有没有异常都会执行到，但是没有返回值
    @After("execution(int foo.bar.AOP2..*.chu(..))")
    public void testChuAfter(JoinPoint joinPoint) {
        System.out.println("After-->除法");
        System.out.println("method Name:" + joinPoint.getSignature().getName() + "---ends");    //joinPoint.getSignature().getName();
    }


    //返回通知：目标方法执行后，不报错，且有返回值
    @AfterReturning(value = "execution(* foo.bar.AOP2.Calaculator.add(..))", returning = "result")//foo前那个＊表示任意修饰符，任意返回值
    public void testAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("返回通知:(方法名)" + joinPoint.getSignature().getName() + "返回值:" + result);
    }

    //异常通知:目标方法异常时报出的
    @AfterThrowing(value = "declareJoinPointExpression()", throwing = "e")
    public void testAfterTrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("异常通知:(方法名):" + joinPoint.getSignature().getName() + "   exception:" + e);
    }

    //环绕通知:方法最健全 目标方法执行全过程包括执行前执行后以及异常。所以有返回值，要用到ProceedingJoinPoint这个形参
    @Around(value = "execution(* foo.bar.AOP2.Calaculator.cheng(..))")
    public void testAround(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知");
        Object object = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        try {
            System.out.println("前置通知:(方法名)" + methodName + " 参数:" + Arrays.asList(proceedingJoinPoint.getArgs()));
            object = (Object) proceedingJoinPoint.proceed();
            System.out.println("返回通知:(结果)" + object);
        } catch (Throwable e) {

            throw new RuntimeException(e);
        }
        System.out.println("后置通知");

    }
}
