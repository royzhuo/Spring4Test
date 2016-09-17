package foo.bar.jdbcTemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author roy.zhuo
 */
public class TestJdbcTmp {

    private ApplicationContext applicationContext = null;
    private JdbcTemplate jdbcTemplate = null;
    private EmployeeDao employeeDao;
    private IndentityDao indentityDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        applicationContext = new ClassPathXmlApplicationContext("spring-jdbcTmp.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        employeeDao = applicationContext.getBean(EmployeeDao.class);
        indentityDao = applicationContext.getBean(IndentityDao.class);
        namedParameterJdbcTemplate = applicationContext.getBean(NamedParameterJdbcTemplate.class);
    }

    @Test
    public void testDataSource() {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {
        String sql = "update employee set name=?,pwd=? where eid = ?";
        jdbcTemplate.update(sql, "RoyWWWW", 3344, 2);
    }

    /*
    * 批量更新：insert update delete
    * */
    @Test
    public void testBatchUpdate() {
        String sql = "insert into employee(name,pwd,grade) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"roy1", 3393, 2});
        batchArgs.add(new Object[]{"roy2", 3493, 2});
        batchArgs.add(new Object[]{"roy3", 339, 1});
        batchArgs.add(new Object[]{"roy4", 393, 1});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /*获取一个实例,支持别名，不支持orm框架，本质jdbc
    * */
    @Test
    public void getObject() {
        String sql = "select eid id,name,dept_id \"indentity.id\" from Employee where  eid=? ";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println("user:" + employee);
    }

    /*多记录查询*/
    @Test
    public void testListObjs() {
        String sql = "select eid id ,name ,dept_id \"indentity.id\" from Employee where eid>=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 2);
        System.out.println("list:" + employees);
    }

    /*查询计数*/
    @Test
    public void testCount() {
        String sql = "select count(*) from employee ";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("count:" + count);
    }

    @Test
    public void testEmpDao() {
        Employee employee = employeeDao.getEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    public void testDepartDao() {
        Indentity indentity = indentityDao.getIndentity(1);
        System.out.println(indentity);
    }

    /*用命名jdbc模版类进行jdbc操作
    * 1.优点：不不按照顺序，缺点：麻烦*/
    @Test
    public void addEmp() {
        String sql = "insert into Employee(name,pwd,grade) values(:name,:pwd,:grade)";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "roys");
        map.put("pwd", 123);
        map.put("grade", 1);
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(map);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Test
    public void addEmpByObj() {
        System.out.println("");
        String sql = "insert into Employee(name,pwd,grade) values(:name,:pwd,:grade)";
        Employee employee = new Employee();
        employee.setName("royss1");
        employee.setPwd("123333");
        employee.setGrade(1);
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }
}
