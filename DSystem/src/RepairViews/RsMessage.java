/*
 * Created by JFormDesigner on Tue May 28 14:09:24 CST 2024
 */

package RepairViews;


import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class RsMessage extends JFrame {
    public RsMessage() {
        initComponents();
        displayUserInfo();
    }

    private void displayUserInfo() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT id, name, age FROM repair LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("<html>编号\t姓名\t年龄<br>");

            while (resultSet.next()) {

              
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
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
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private JLabel labelInfo;


}
