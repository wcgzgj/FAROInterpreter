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
    static String alps="abcdefghijklmnopqrstuvwxvz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String operators="+-*/=";
    static String Bracket="()";


    /**
     * 判断该字符串是不是数字
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        if (str==null || str.length()==0) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {

            try {
                Double.parseDouble(str);
                return true;

            } catch (NumberFormatException ex) {

                try {
                    Float.parseFloat(str);
                    return true;
                } catch (NumberFormatException exx) {
                    return false;
                }
            }
        }
    }

    /**
     * 判断是否是字母
     * @param s
     * @return
     */
    public static boolean isAlp(String s) {
        return alps.contains(s);
    }

    /**
     * 判断是不是运算符
     * @param s
     * @return
     */
    public static boolean isOperator(String s) {
        return operators.contains(s);
    }

    public static boolean isBracket(String s) {
        return Bracket.contains(s);
    }
}
