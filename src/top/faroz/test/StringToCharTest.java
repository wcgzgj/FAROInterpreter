package top.faroz.test;

/**
 * @ClassName StringToCharTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 下午2:59
 * @Version 1.0
 **/
public class StringToCharTest {
    public static void main(String[] args) {
        String s = "  Abcd  e12  34  5";
        s=s.replaceAll(" ","");
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}
