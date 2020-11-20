package top.faroz.util;

import com.singularsys.jep.functions.Str;

import java.io.PushbackInputStream;
import java.util.HashSet;

/**
 * @ClassName NumUtil
 * @Description 字符工具，对字符串进行各种处理
 * @Author FARO_Z
 * @Date 2020/11/16 下午4:33
 * @Version 1.0
 **/
public class WordUtil {
    static String nums="0123456789";
    static String alps="abcdefghijklmnopqrstuvwxvz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String operators="+-*/=";

    /**
     * 判断该字符串是不是数字
     * 注意,只能判断单个字符
     * @param s
     * @return
     */
    public static boolean isNum(String s) {
        return nums.contains(s);
    }

    /**
     * 判断是否是字母
     * @param s
     * @return
     */
    public static boolean isAlp(String s) {
        return alps.contains(s);
    }

    public static boolean isOperator(String s) {
        return operators.contains(s);
    }
}
