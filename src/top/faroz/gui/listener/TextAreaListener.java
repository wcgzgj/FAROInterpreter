package top.faroz.gui.listener;

import top.faroz.gui.panel.MainPanel;
import top.faroz.util.TextAreaUtil;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @ClassName TextAreaListener
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 上午10:54
 * @Version 1.0
 **/
public class TextAreaListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        MainPanel mainPanel = MainPanel.getInstance();
        JTextArea textArea = mainPanel.getTextArea();
        int code = e.getKeyCode();


        switch (code) {
            case 10:
                int lineCount = textArea.getLineCount();
                System.out.println(TextAreaUtil.getLastLine(textArea.getText()));

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
