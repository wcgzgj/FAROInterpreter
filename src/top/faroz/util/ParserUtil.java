package top.faroz.util;

/**
 * @ClassName ParserUtil
 * @Description 解释器工具类
 * @Author FARO_Z
 * @Date 2020/11/20 下午3:30
 * @Version 1.0
 **/
public class ParserUtil {
    /**
     * 将字符串转换为token字符流
     * 在token化的时候，自动去除字符头尾的 左右括号
     * @param str
     * @return
     */
    public static String[] toToken(String str) {
        str=str.trim();
        //去除头尾括号
        if (String.valueOf(str.charAt(0)).equals("("))
            str=str.substring(1);
        if (String.valueOf(str.charAt(str.length()-1)).equals(")"))
            str=str.substring(0,str.length()-1);

        //要将字符串中所有这些字符，全部带上前后空格
        //方便使用split函数进行分割
        String []blocks={"\\+","\\-","\\*","\\/","\\=","\\(","\\)"};

        for (String block : blocks) {
            String dir = " " + block + " ";
            str=str.replaceAll(block,dir);
        }

        //调用split函数，进行分割
        //要注意忽略空格的个数（使用正则表达式实现）
        String[] split = str.split("\\s+");
        return split;
    }
}
