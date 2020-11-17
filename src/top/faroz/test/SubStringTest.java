package top.faroz.test;

/**
 * @ClassName SubStringTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/17 上午8:33
 * @Version 1.0
 **/
public class SubStringTest {
    public static void main(String[] args) {
        String abcd = "abcd";
        /**
         * substring包含当点index
         */
        System.out.println(abcd.substring(1));

        String str = "abc(abc)abc)";
        System.out.println(str.substring(3).indexOf(")"));
    }
}
