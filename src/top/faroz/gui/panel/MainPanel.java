package top.faroz.gui.panel;

import sun.applet.Main;
import top.faroz.gui.listener.TextAreaListener;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;

/**
 * @ClassName MainPanel
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 上午10:17
 * @Version 1.0
 **/
public class MainPanel extends JPanel {
    private static MainPanel instance=new MainPanel();
    //上半部分只读，只能显示
    public JTextArea taUp =new JTextArea();
    public JScrollPane spUp=new JScrollPane(taUp);

    //下半部分可以写指令
    public JTextArea taDown =new JTextArea();
    public JScrollPane spDown=new JScrollPane(taDown);

    public Font font=new Font("SF Mono Regular 11", Font.PLAIN, 15);


    public static MainPanel getInstance() {
        return instance;
    }

    public MainPanel() {


        this.setLayout(new BorderLayout());
        taUp.setForeground(Color.WHITE);
        taUp.setCaretColor(Color.WHITE);
        taUp.setFont(font);
        //将文本域设为灰色，以模仿Bash的风格
        taUp.setBackground(Color.GRAY);
        taUp.setLineWrap(true);
        taUp.setEditable(false);

        taDown.setForeground(Color.WHITE);
        taDown.setCaretColor(Color.WHITE);
        taDown.setFont(font);
        //将文本域设为灰色，以模仿Bash的风格
        taDown.setBackground(Color.GRAY);
        taDown.setLineWrap(true);


        this.add(spUp,BorderLayout.CENTER);
        this.add(spDown,BorderLayout.SOUTH);

        taDown.setPreferredSize(new Dimension(500,100));



        //增加键盘监听
        taDown.addKeyListener(new TextAreaListener());

    }

    public JTextArea getTextArea() {
        return taDown;
    }
}
