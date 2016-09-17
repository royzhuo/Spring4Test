package foo.bar.springTX;

/**
 * @author roy.zhuo
 */
public interface BookDao {

    //减库存
    public void updateBookStroge(int bookId);

    //更新余额
    void updatePersonPrice(String name, int bookPrice);

    //获取书的单价
    int getBookPrice(int bookId);

}
