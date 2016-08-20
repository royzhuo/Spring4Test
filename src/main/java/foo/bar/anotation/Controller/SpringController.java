package foo.bar.anotation.Controller;

import foo.bar.anotation.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author roy.zhuo
 */
@Controller
public class SpringController {
    @Autowired()
    SpringService springService;

    public void excute() {
        System.out.println("controller excute...");
        springService.excute();
    }
}
