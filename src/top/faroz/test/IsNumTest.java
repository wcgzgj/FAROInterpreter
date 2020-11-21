package top.faroz.test;

import top.faroz.util.WordUtil;

/**
 * @ClassName IsNumTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/21 下午2:25
 * @Version 1.0
 **/
public class IsNumTest {
    public static void main(String[] args) {
        System.out.println(WordUtil.isNum("2.14"));
        System.out.println(WordUtil.isNum("2"));
        System.out.println(WordUtil.isNum("0"));
        System.out.println(WordUtil.isNum("."));
        System.out.println(WordUtil.isNum("A"));
        System.out.println(WordUtil.isNum(".14"));
        System.out.println(Float.parseFloat(".14"));
    }
}
