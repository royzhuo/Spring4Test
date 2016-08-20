package foo.bar.anotation.Projo;

import org.springframework.stereotype.Component;

/**
 * @author roy.zhuo
 */
@Component
public class TestObj {
    private String name;

    public TestObj() {
        System.out.println("testobj constructor..");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
