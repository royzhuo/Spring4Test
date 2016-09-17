package foo.bar.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @author roy.zhuo
 *         如果集成jdbcdaosupport必须配置数据源，用jdbc模版实现sql
 */
@Repository
public class IndentityDao extends JdbcDaoSupport {
    @Autowired
    void setDataSource2(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public Indentity getIndentity(Integer id) {
        String sql = "select did id,name from DepartMent where did=?";
        RowMapper<Indentity> rowMapper = new BeanPropertyRowMapper<Indentity>(Indentity.class);
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);
    }
}
