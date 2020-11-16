package top.faroz.gui.frame;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/16 上午9:38
 * @Version 1.0
 **/
public class MainFrame extends JFrame {
    private static MainFrame instance=new MainFrame();

    public static MainFrame getInstance() {
        return instance;
    }

    public MainFrame() throws HeadlessException {
        this.setTitle("MyList 解释器");
        this.setLayout(new BorderLayout());
        // this.setBounds();
    }
}
