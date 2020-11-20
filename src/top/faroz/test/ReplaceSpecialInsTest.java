package top.faroz.test;

import javax.xml.transform.Source;

/**
 * @ClassName ReplaceSpecialInsTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/20 下午4:05
 * @Version 1.0
 **/
public class ReplaceSpecialInsTest {
    public static void main(String[] args) {
        String s = "/";
        s=s.replaceAll("/","*");
        System.out.println(s);
    }
}
