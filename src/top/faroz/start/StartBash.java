package top.faroz.start;

import top.faroz.gui.frame.MainFrame;
import top.faroz.gui.panel.MainPanel;

import javax.swing.*;

/**
 * @ClassName StartBash
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 上午10:34
 * @Version 1.0
 **/
public class StartBash {
    static {
        JTextArea taUp = MainPanel.getInstance().getTaUp();
        taUp.append("   Hello ， 欢迎使用 FARO_Z 的解释器" +
                "\n   使用 help 命令，以查看帮助手册" +
                "\n   选择下方窗口,以输入指令\n\n\n");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame.getInstance().setVisible(true);
            }
        });
    }
}
