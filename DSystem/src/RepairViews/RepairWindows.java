/*
 * Created by JFormDesigner on Sat May 25 17:28:19 CST 2024
 */

package RepairViews;

import SysViews.DeleteDorm;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * @author 86191
 */
public class RepairWindows extends JFrame {
    public RepairWindows() {
        initComponents();
    }

    private  void button1ActionPerformed(ActionEvent e){
        new RsMessage().setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4e2a\u4eba\u4fe1\u606f");
        contentPane.add(button1);
        button1.setBounds(35, 25, 120, 45);
        button1.addActionListener(e -> button1ActionPerformed(e));
        //---- button2 ----
        button2.setText("\u67e5\u770b\u9700\u8981\u4fee\u7406\u5bbf\u820d");
        contentPane.add(button2);
        button2.setBounds(30, 105, 145, 40);

        //---- button3 ----
        button3.setText("\u4fee\u7406\u5b8c\u540e\u6d88\u9664");
        contentPane.add(button3);
        button3.setBounds(35, 180, 140, 40);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
