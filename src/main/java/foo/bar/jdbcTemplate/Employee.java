package foo.bar.jdbcTemplate;

/**
 * @author roy.zhuo
 */
public class Employee {

    private Integer id;
    private String name;
    private Indentity indentity;
    private int grade;
    private String pwd;

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", indentity=" + indentity +
            ", grade=" + grade +
            ", pwd='" + pwd + '\'' +
            '}';
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Indentity getIndentity() {
        return indentity;
    }

    public void setIndentity(Indentity indentity) {
        this.indentity = indentity;
    }

}
