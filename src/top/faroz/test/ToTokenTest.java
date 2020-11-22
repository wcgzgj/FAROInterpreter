package top.faroz.test;

import top.faroz.util.ParserUtil;

import java.util.Arrays;

/**
 * @ClassName ToTokenTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/20 下午4:02
 * @Version 1.0
 **/
public class ToTokenTest {
    public static void main(String[] args) {
        String str = "(+(* b 3.141)(/14 a))";
        String[] strings = ParserUtil.toToken(str);
        System.out.println(Arrays.toString(strings));

    }
}
