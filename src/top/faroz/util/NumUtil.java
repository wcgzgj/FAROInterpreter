package top.faroz.util;

import java.io.PushbackInputStream;
import java.util.HashSet;

/**
 * @ClassName NumUtil
 * @Description 数字工具，对字符串进行各种处理
 * @Author FARO_Z
 * @Date 2020/11/16 下午4:33
 * @Version 1.0
 **/
public class NumUtil {
    private static HashSet<String> numSet=new HashSet<>();
    static {
        numSet.add("1");  numSet.add("2");  numSet.add("3");
        numSet.add("4");  numSet.add("5");  numSet.add("6");
        numSet.add("7");  numSet.add("8");  numSet.add("9");
        numSet.add("0");
    }

    /**
     * 判断该字符串是不是数字
     * 注意,只能判断单个字符
     * @param s
     * @return
     */
    public static boolean isNum(String s) {
        return numSet.contains(s);
    }
}
