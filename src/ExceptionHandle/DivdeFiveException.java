package ExceptionHandle;

/**
 * @Author: YHQ
 * @Date: 2019/11/27 21:29
 */
public class DivdeFiveException extends ArithmeticException {
    public DivdeFiveException() {
        super("除五也不行");
    }

    public DivdeFiveException(String s) {
        super(s);
    }
}
