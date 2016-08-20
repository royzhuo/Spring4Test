package foo.bar.anotation.dao;

import foo.bar.anotation.Projo.TestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author roy.zhuo
 */
@Repository("springDaos")
public class SpringDaoImp implements SpringDao {
    @Autowired(required = false)//表示不是必须的，如果没有该实例返回null
        TestObj testObj;

    @Override
    public void save() {
        System.out.println("springdaoimp save....");
        System.out.println("save obj:" + testObj);
    }
}
