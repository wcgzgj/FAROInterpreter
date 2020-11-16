package top.faroz.util;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

/**
 * @ClassName TextAreaUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 上午11:44
 * @Version 1.0
 **/
public class TextAreaUtil {
    /**
     * 获取JTextArea中的最后一行的文字
     * @param str
     * @return
     */
    public static String getLastLine(String str) {
        String[] split = str.split("\n");
        for (int i = 0; i < split.length; i++) {
            split[i]=split[i].replaceAll(">","");
            split[i]=split[i].trim();
        }
        return split[split.length-1];
    }
}
