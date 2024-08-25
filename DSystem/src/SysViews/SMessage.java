package SysViews;

import cn.login.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SMessage extends JFrame {
    private String username;
    private String password;
    private JLabel labelInfo;

    public SMessage(String username, String password) {
        this.username = username;
        this.password = password;
        initComponents();
        displayUserInfo(username, password);
    }

    private void displayUserInfo(String username, String password) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT name, id, age FROM sys WHERE username = ? and password =?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("<html>编号\t姓名\t年龄<br>");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");

                sb.append(id).append("\t");
                sb.append(name).append("\t");
                sb.append(age).append("<br>");
            }
            sb.append("</html>");

            labelInfo.setText(sb.toString());

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        labelInfo = new JLabel();
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.add(labelInfo, BorderLayout.CENTER);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
