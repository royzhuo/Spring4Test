package foo.bar.anotation.service;

import foo.bar.anotation.dao.SpringDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author roy.zhuo
 */
@Service
public class SpringService {
    @Resource
    // @Qualifier() 当有两个实现类的时候可以用这个注解区分
    private SpringDao springDao;


    public void excute() {
        System.out.println("spring service....");
        springDao.save();
    }
}
