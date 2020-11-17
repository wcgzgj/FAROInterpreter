package top.faroz.test;

/**
 * @ClassName SplitByBlankTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/17 下午12:54
 * @Version 1.0
 **/
public class SplitByBlankTest {
    public static void main(String[] args) {
        String s = "  a   b       da     d";
        s=s.trim();
        String[] s1 = s.split("\\s+");//通过正则表达式进行分配
        for (String s2 : s1) {
            System.out.println(s2);
        }

        String s2 = "(a+b)";
        s2=s2.replaceAll("\\("," * ");


    }
}
