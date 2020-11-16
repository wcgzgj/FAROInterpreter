package top.faroz.util;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import top.faroz.gui.panel.MainPanel;

import javax.swing.*;
import java.util.List;

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

    public static void analyseInstruction(String ins) {
        MainPanel mainPanel = MainPanel.getInstance();
        JTextArea taUp = mainPanel.taUp;
        switch (ins) {
            case "cls":
                taUp.setText("");
                break;
            case "help":
                appendToTaUp(FileUtil.readFIle("help"));
                break;
            case "copyright":
                appendToTaUp(FileUtil.readFIle("copyright"));
                break;
            case "format":
                appendToTaUp(FileUtil.readFIle("format"));
                break;
            default:
                taUp.append("\n     error , please input \"help\"\n" +
                        "     to read standard input format");
                break;
        }
    }

    public static void analyseFunction(String func) {

    }

    public static void appendToTaUp(List<String> list) {
        JTextArea taUp = MainPanel.getInstance().getTaUp();
        for (String s : list) {
            taUp.append(s+"\n");
        }
    }
}
