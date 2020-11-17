package top.faroz.service;

import top.faroz.gui.panel.MainPanel;
import top.faroz.util.FileUtil;
import top.faroz.util.TextAreaUtil;

import javax.swing.*;

/**
 * @ClassName InstructionAnalyse
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 下午4:44
 * @Version 1.0
 **/
public class InstructionAnalyse {
    /**
     * 解析指令
     * 如果不是指令，调用解析函数的方法
     * @param ins
     */
    public static void analyseInstruction(String ins) {
        MainPanel mainPanel = MainPanel.getInstance();
        JTextArea taUp = mainPanel.taUp;
        if (isBasicInstruction(ins)) { //如果是指令集，按照指令集进行判断
            switch (ins) {
                case "cls":
                    taUp.setText("");
                    break;
                case "help":
                    TextAreaUtil.appendToTaUp(FileUtil.readFile("help"));
                    break;
                case "copyright":
                    TextAreaUtil.appendToTaUp(FileUtil.readFile("copyright"));
                    break;
                case "format":
                    TextAreaUtil.appendToTaUp(FileUtil.readFile("format"));
                    break;
                case "":
                    break;
                default:
                    taUp.append("\n     error , please input \"help\"\n" +
                            "     to read standard input format");
                    break;
            }
        } else { //否则就按照函数进行判断
            analyseFunction(ins);
        }
    }

    /**
     * 在analyseFunction中，发现指令不是基础指令
     * 则通过analyseFunction 来分析该函数指令
     * @param func
     */
    private static void analyseFunction(String func) {
        // if ()

    }

    /**
     * 判定是不是基础指令集
     * @param s
     * @return
     */
    public static boolean isBasicInstruction(String s) {
        //指令集中不会出现空格和括号
        if (s.indexOf(" ")!=-1 || s.indexOf("(")!=-1 || s.indexOf(")")!=-1) return false;
        return true;
    }

    /**
     * 通过前、后 是不是括号，粗略判断是不是函数
     * @param s
     * @return
     */
    public static boolean isFunc(String s) {
        if (s.length()<=2) return false;
        String head = String.valueOf(s.charAt(0));
        s.charAt(s.length()-1);


        return true;
    }
}
