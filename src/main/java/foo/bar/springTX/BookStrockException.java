package foo.bar.springTX;

/**
 * @author roy.zhuo
 */
public class BookStrockException extends RuntimeException {

    public BookStrockException() {
    }

    public BookStrockException(String message) {
        super(message);
    }

    public BookStrockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStrockException(Throwable cause) {
        super(cause);
    }

    public BookStrockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
