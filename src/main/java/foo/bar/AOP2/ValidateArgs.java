package foo.bar.AOP2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author roy.zhuo
 */
@Order(1)  //该注解表示切面的优先级，值越低，优先级越高
@Aspect
@Component
public class ValidateArgs {

    @Before("CalaculatorAOP.declareJoinPointExpression()")
    public void validateArgsForCal(JoinPoint joinPoint) {
        System.out.println("---->validate:" + joinPoint.getSignature().getName() + "  args:" + Arrays.asList(joinPoint.getArgs()));
    }
}
