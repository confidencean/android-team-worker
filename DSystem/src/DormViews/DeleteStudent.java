/*
 * Created by JFormDesigner on Sat May 25 20:06:42 CST 2024
 */

package DormViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 86191
 */
public class DeleteStudent extends JFrame {
    public DeleteStudent() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8f93\u5165\u5b66\u751f\u7684\u5b66\u53f7");
        contentPane.add(label1);
        label1.setBounds(25, 55, 115, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(135, 50, 135, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u5220\u9664");
        contentPane.add(button1);
        button1.setBounds(60, 115, 95, button1.getPreferredSize().height);
        button1.addActionListener(e -> deleteStudent(textField1.getText())); // 绑定动作监听器
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void deleteStudent(String studentId) {
        try {
            // Get database connection
            Connection connection = DatabaseConnection.getConnection();

            // Prepare SQL delete statement
            String query = "DELETE FROM student WHERE id = ?";

            // Create PreparedStatement object
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameter
            statement.setString(1, studentId);

            // Execute update (delete) operation
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "学生信息删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "未找到要删除的学生信息");
            }

            // Close resources
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败: " + ex.getMessage());
        }
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}