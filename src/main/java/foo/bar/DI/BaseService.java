package foo.bar.DI;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author roy.zhuo
 */
public class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    public void add() {
        System.out.println("add");
    }
}
