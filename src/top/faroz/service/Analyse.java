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
public class Analyse {
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
                    taUp.append("\n     错误 , 请输入 \"help\"\n" +
                            "     阅读标准输入格式手册");
                    break;
            }
        } else { //否则就按照函数进行判断
            analyseFunction(ins);
        }
    }

    /**
     * 在analyseFunction中，发现指令不是基础指令
     * 则通过analyseFunction 来分析该函数指令
     * @param func Listener中，已经保证输入的指令头尾都没有空格
     */
    private static void analyseFunction(String func) {
        JTextArea taUp = MainPanel.getInstance().getTaUp();
        if (!isFunc(func)) {
            taUp.append("\n     错误 , 函数输入错误\n" +
                    "     请输入 \"help\"，阅读标准 函数 输入格式手册");
        }
        /**
         * 经过筛选后的函数，保证输入的函数
         * 头尾是左右括号
         * 头后面的第一个字符保证是 基本运算符  (=) (+) (-) ...
         */
        Parser.parseFunc(func);



    }

    /**
     * 判定是不是基础指令集
     * 具体判断是不是可用的基础指令集，不在这个函数判断之列
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
        s=s.replaceAll("\n","");

        if (s.length()<=2) return false;

        //判断函数头尾是不是左右括号
        String head = String.valueOf(s.charAt(0));
        String tail = String.valueOf(s.charAt(s.length() - 1));
        if (!head.equals("(") || !tail.equals(")")) return false;

        //去掉头尾括号
        s=s.substring(1);//subString包含头
        s=s.substring(0,s.length()-1);//但是subString不包含尾部

        //去掉空格,以保证获取的第一个元素不是空格
        s=s.trim();
        System.out.println(s);

        //最后通过第一个字符是不是基本运算符，来敲定是不是函数
        String CountInstruction = String.valueOf(s.charAt(0));
        return isCountInstruction(CountInstruction);
    }

    /**
     * 判断是否是基本运算符号
     * @param ins
     * @return
     */
    public static boolean isCountInstruction(String ins) {
        if ("=".equals(ins) ||
                "+".equals(ins) ||
                "-".equals(ins) ||
                "*".equals(ins) ||
                "/".equals(ins) )
            return true;
        return false;
    }
}
