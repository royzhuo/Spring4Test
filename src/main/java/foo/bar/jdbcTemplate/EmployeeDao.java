package foo.bar.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author roy.zhuo
 */
@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Employee getEmployeeById(Integer id) {
        String sql = "select eid id,name,dept_id \"indentity.id\" from Employee where  eid=? ";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
