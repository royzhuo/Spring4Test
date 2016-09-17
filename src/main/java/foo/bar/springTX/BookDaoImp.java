package foo.bar.springTX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author roy.zhuo
 */
@Repository("bookDao")
public class BookDaoImp implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateBookStroge(int bookId) {
        String sql = "update bookStroge set bstroge=bstroge-1 where bno=?";
        String sql2 = "select bstroge from bookStroge where bno=?";
        int bookStroge = jdbcTemplate.queryForObject(sql2, Integer.class, bookId);
        if (bookStroge <= 0) {
            throw new BookStrockException("库存不足");
        }
        jdbcTemplate.update(sql, bookId);
    }

    @Override
    public void updatePersonPrice(String name, int bookPrice) {
        String sql = "update Person set prices=prices-? where name=?";
        String sql2 = "select prices from Person where name=?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, "roy");
        if (balance < bookPrice) {
            throw new AccountException("余额不足");
        }
        jdbcTemplate.update(sql, bookPrice, name);
    }

    @Override
    public int getBookPrice(int bookId) {
        String sql = "select bPrice from bookStroge where bno=? ";
        return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
    }
}
