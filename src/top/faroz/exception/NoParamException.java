package top.faroz.exception;

/**
 * @ClassName NoParamException
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/21 下午3:13
 * @Version 1.0
 **/
public class NoParamException extends Exception{
    public NoParamException() {
        super("存在未初始化的变量");
    }
}
