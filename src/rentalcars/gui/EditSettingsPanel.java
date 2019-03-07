package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class EditSettingsPanel extends JPanel {

   private static final long serialVersionUID = 1L;
   private JTextField textFieldUserName;
   private JPasswordField passwordField;

   /**
    * Create the panel.
    */
   public EditSettingsPanel() {
      setLayout(new BorderLayout(0, 0));
      
      Box headerBox = Box.createHorizontalBox();
      add(headerBox, BorderLayout.NORTH);
      
      Component horizontalStrut = Box.createHorizontalStrut(10);
      headerBox.add(horizontalStrut);
      
      JLabel lblNewLabel = new JLabel("Settings");
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
      headerBox.add(lblNewLabel);
      
      ImageIcon hatchbackImageIcon = new ImageIcon(getClass().getResource("/icons/gear.png"));
      Image originalHatchbackImage = hatchbackImageIcon.getImage();
      Image resizedHatchbackImage = originalHatchbackImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
      hatchbackImageIcon = new ImageIcon(resizedHatchbackImage);
      
      Component horizontalGlue = Box.createHorizontalGlue();
      headerBox.add(horizontalGlue);
      JLabel hatchbackJLabel = new JLabel(hatchbackImageIcon);
      headerBox.add(hatchbackJLabel);
      
      Component horizontalStrut_2 = Box.createHorizontalStrut(10);
      headerBox.add(horizontalStrut_2);
      
      Component horizontalStrut_1 = Box.createHorizontalStrut(20);
      add(horizontalStrut_1, BorderLayout.WEST);
      
      Box settingsPanelsBox = Box.createVerticalBox();
      add(settingsPanelsBox, BorderLayout.CENTER);
      
      JPanel databaseUrlPanel = new JPanel();
      settingsPanelsBox.add(databaseUrlPanel);
      FlowLayout fl_databaseUrlPanel = new FlowLayout(FlowLayout.LEFT, 5, 5);
      databaseUrlPanel.setLayout(fl_databaseUrlPanel);
      
      JLabel lblDatabaseUrl = new JLabel("Database URL");
      databaseUrlPanel.add(lblDatabaseUrl);
      
      JFormattedTextField txtDatabaseUrl = new JFormattedTextField();
      txtDatabaseUrl.setColumns(40);
      databaseUrlPanel.add(txtDatabaseUrl);
      
      JPanel usernamePasswordPanel = new JPanel();
      FlowLayout fl_usernamePasswordPanel = (FlowLayout) usernamePasswordPanel.getLayout();
      fl_usernamePasswordPanel.setAlignment(FlowLayout.LEFT);
      settingsPanelsBox.add(usernamePasswordPanel);
      
      Box verticalBox = Box.createVerticalBox();
      usernamePasswordPanel.add(verticalBox);
      
      JPanel panel = new JPanel();
      FlowLayout flowLayout = (FlowLayout) panel.getLayout();
      flowLayout.setVgap(0);
      flowLayout.setHgap(0);
      flowLayout.setAlignment(FlowLayout.LEFT);
      verticalBox.add(panel);
      
      JCheckBox chckbxSupplyUsername = new JCheckBox("Supply Username and Pasword");
      chckbxSupplyUsername.setHorizontalAlignment(SwingConstants.LEFT);
      panel.add(chckbxSupplyUsername);
      
      JPanel panel_1 = new JPanel();
      FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
      flowLayout_2.setVgap(0);
      flowLayout_2.setAlignment(FlowLayout.LEFT);
      verticalBox.add(panel_1);
      
      JLabel lblUsername = new JLabel("Username");
      panel_1.add(lblUsername);
      
      textFieldUserName = new JTextField();
      panel_1.add(textFieldUserName);
      textFieldUserName.setColumns(20);
      
      JLabel lblPassword = new JLabel("Password");
      panel_1.add(lblPassword);
      
      passwordField = new JPasswordField();
      passwordField.setColumns(20);
      panel_1.add(passwordField);
      
      JPanel testConnectionPanel = new JPanel();
      settingsPanelsBox.add(testConnectionPanel);
      
      JButton btnTestConnect = new JButton("Test Connection");
      testConnectionPanel.add(btnTestConnect);
   }
}