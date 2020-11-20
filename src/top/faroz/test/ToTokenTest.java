package top.faroz.test;

import top.faroz.util.ParserUtil;

/**
 * @ClassName ToTokenTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/20 下午4:02
 * @Version 1.0
 **/
public class ToTokenTest {
    public static void main(String[] args) {
        String str = "(+(* b 2)(/4 a))";
        String[] strings = ParserUtil.toToken(str);
        for (String string : strings) {
            System.out.println(string);
        }
        for (String string : strings) {
            if (string.equals("(")) {
                System.out.println("hahaha");
            }
        }
    }
}
