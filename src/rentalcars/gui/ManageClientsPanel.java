package rentalcars.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import rentalcars.model.Client;
import rentalcars.repo.ClientRepository;
import rentalcars.repo.interfaces.IClientRepository;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ManageClientsPanel extends JPanel {

   private static final long serialVersionUID = 1L;
   
   private IClientRepository clientRepo;
   private JTextField firstNameTxtField;
   private JTextField lastNameTxtField;
   private JTextField licenseNumberTxtField;
   private JTextField emailTxtField;
   private JTextField phoneTxtField;
   private JTextField streetTxtField;
   private JTextField cityTxtField;
   private JTextField stateTxtField;
   private JTextField zipTxtField;
   private DatePicker dobPicker;
   
   private Client c;
   private JTextField fir;
   private JTextField las;
   private JTextField email;
   private JTextField pho;
   private JTextField str;
   private JTextField cit;
   private JTextField sta;
   private JTextField zip;
   private JTextField lic;
   private DatePicker dob;
   
   private ClientSelectDialog searchDialog;

   public ManageClientsPanel() {
      
      searchDialog = new ClientSelectDialog();
      searchDialog.setModal(true);
      
      clientRepo = new ClientRepository();
      setLayout(new BorderLayout(0, 0));
      
      Box headerBox = Box.createHorizontalBox();
      add(headerBox, BorderLayout.NORTH);
      
      Component horizontalStrut = Box.createHorizontalStrut(20);
      headerBox.add(horizontalStrut);
      
      JLabel lblClients = new JLabel("Manage Clients");
      lblClients.setFont(new Font("Tahoma", Font.PLAIN, 32));
      headerBox.add(lblClients);
      
      ImageIcon clientsImageIcon = new ImageIcon(getClass().getResource("/icons/client.png"));
      Image originalClientsImage = clientsImageIcon.getImage();
      Image resizedClientsImage = originalClientsImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
      clientsImageIcon = new ImageIcon(resizedClientsImage);
      
      Component horizontalGlue = Box.createHorizontalGlue();
      headerBox.add(horizontalGlue);
      JLabel clientsLabel = new JLabel(clientsImageIcon);
      headerBox.add(clientsLabel);
      
      Component horizontalStrut_1 = Box.createHorizontalStrut(20);
      headerBox.add(horizontalStrut_1);
      
      JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      add(tabbedPane);
      
      Properties p = new Properties();
      p.put("text.today", "today");
      p.put("text.month", "month");
      p.put("text.year", "year");
      
      JPanel manageClientPanel = new JPanel();
      tabbedPane.addTab("Manage", null, manageClientPanel, null);
      manageClientPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
      GridBagLayout gbl_manageClientPanel = new GridBagLayout();
      gbl_manageClientPanel.columnWidths = new int[]{36, 101, 437, 19, 0};
      gbl_manageClientPanel.rowHeights = new int[]{25, 0, 20, 0, 20, 20, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_manageClientPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
      gbl_manageClientPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      manageClientPanel.setLayout(gbl_manageClientPanel);
      
      Component verticalStrut_2 = Box.createVerticalStrut(20);
      GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
      gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
      gbc_verticalStrut_2.gridx = 2;
      gbc_verticalStrut_2.gridy = 0;
      manageClientPanel.add(verticalStrut_2, gbc_verticalStrut_2);
      
      JLabel label = new JLabel("License Number");
      GridBagConstraints gbc_label = new GridBagConstraints();
      gbc_label.anchor = GridBagConstraints.EAST;
      gbc_label.insets = new Insets(0, 0, 5, 5);
      gbc_label.gridx = 1;
      gbc_label.gridy = 1;
      manageClientPanel.add(label, gbc_label);
      
      licenseNumberTxtField = new JTextField();
      GridBagConstraints gbc_licenseNumberTxtField = new GridBagConstraints();
      gbc_licenseNumberTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_licenseNumberTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_licenseNumberTxtField.gridx = 2;
      gbc_licenseNumberTxtField.gridy = 1;
      manageClientPanel.add(licenseNumberTxtField, gbc_licenseNumberTxtField);
      licenseNumberTxtField.setColumns(20);
      
      JLabel firstNameLabel = new JLabel("First Name");
      GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
      gbc_firstNameLabel.anchor = GridBagConstraints.EAST;
      gbc_firstNameLabel.insets = new Insets(0, 0, 5, 5);
      gbc_firstNameLabel.gridx = 1;
      gbc_firstNameLabel.gridy = 2;
      manageClientPanel.add(firstNameLabel, gbc_firstNameLabel);
      
      firstNameTxtField = new JTextField();
      firstNameTxtField.setColumns(15);
      GridBagConstraints gbc_firstNameTxtField = new GridBagConstraints();
      gbc_firstNameTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_firstNameTxtField.anchor = GridBagConstraints.NORTH;
      gbc_firstNameTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_firstNameTxtField.gridx = 2;
      gbc_firstNameTxtField.gridy = 2;
      manageClientPanel.add(firstNameTxtField, gbc_firstNameTxtField);
      
      JLabel lastNameLabel = new JLabel("Last Name");
      GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
      gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
      gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
      gbc_lastNameLabel.gridx = 1;
      gbc_lastNameLabel.gridy = 3;
      manageClientPanel.add(lastNameLabel, gbc_lastNameLabel);
      
      lastNameTxtField = new JTextField();
      lastNameTxtField.setColumns(15);
      GridBagConstraints gbc_lastNameTxtField = new GridBagConstraints();
      gbc_lastNameTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_lastNameTxtField.anchor = GridBagConstraints.NORTH;
      gbc_lastNameTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_lastNameTxtField.gridx = 2;
      gbc_lastNameTxtField.gridy = 3;
      manageClientPanel.add(lastNameTxtField, gbc_lastNameTxtField);
      
      JLabel lblDoblabel = new JLabel("Date of Birth");
      GridBagConstraints gbc_lblDoblabel = new GridBagConstraints();
      gbc_lblDoblabel.anchor = GridBagConstraints.EAST;
      gbc_lblDoblabel.insets = new Insets(0, 0, 5, 5);
      gbc_lblDoblabel.gridx = 1;
      gbc_lblDoblabel.gridy = 4;
      manageClientPanel.add(lblDoblabel, gbc_lblDoblabel);
      
      dobPicker = new DatePicker();
      GridBagConstraints gbc_dobPicker = new GridBagConstraints();
      gbc_dobPicker.fill = GridBagConstraints.HORIZONTAL;
      gbc_dobPicker.anchor = GridBagConstraints.NORTH;
      gbc_dobPicker.insets = new Insets(0, 0, 5, 5);
      gbc_dobPicker.gridx = 2;
      gbc_dobPicker.gridy = 4;
      manageClientPanel.add(dobPicker, gbc_dobPicker);
      
      JLabel lblEmail = new JLabel("Email");
      GridBagConstraints gbc_lblEmail = new GridBagConstraints();
      gbc_lblEmail.anchor = GridBagConstraints.EAST;
      gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
      gbc_lblEmail.gridx = 1;
      gbc_lblEmail.gridy = 5;
      manageClientPanel.add(lblEmail, gbc_lblEmail);
      
      emailTxtField = new JTextField();
      GridBagConstraints gbc_emailTxtField = new GridBagConstraints();
      gbc_emailTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_emailTxtField.anchor = GridBagConstraints.NORTH;
      gbc_emailTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_emailTxtField.gridx = 2;
      gbc_emailTxtField.gridy = 5;
      manageClientPanel.add(emailTxtField, gbc_emailTxtField);
      emailTxtField.setColumns(30);
      
      JLabel lblPhone = new JLabel("Phone");
      GridBagConstraints gbc_lblPhone = new GridBagConstraints();
      gbc_lblPhone.anchor = GridBagConstraints.EAST;
      gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
      gbc_lblPhone.gridx = 1;
      gbc_lblPhone.gridy = 6;
      manageClientPanel.add(lblPhone, gbc_lblPhone);
      
      phoneTxtField = new JTextField();
      GridBagConstraints gbc_phoneTxtField = new GridBagConstraints();
      gbc_phoneTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_phoneTxtField.anchor = GridBagConstraints.NORTH;
      gbc_phoneTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_phoneTxtField.gridx = 2;
      gbc_phoneTxtField.gridy = 6;
      manageClientPanel.add(phoneTxtField, gbc_phoneTxtField);
      phoneTxtField.setColumns(10);
      
      JLabel streetLabel = new JLabel("Street");
      GridBagConstraints gbc_streetLabel = new GridBagConstraints();
      gbc_streetLabel.anchor = GridBagConstraints.EAST;
      gbc_streetLabel.insets = new Insets(0, 0, 5, 5);
      gbc_streetLabel.gridx = 1;
      gbc_streetLabel.gridy = 7;
      manageClientPanel.add(streetLabel, gbc_streetLabel);
      
      streetTxtField = new JTextField();
      streetTxtField.setColumns(10);
      GridBagConstraints gbc_streetTxtField = new GridBagConstraints();
      gbc_streetTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_streetTxtField.anchor = GridBagConstraints.NORTH;
      gbc_streetTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_streetTxtField.gridx = 2;
      gbc_streetTxtField.gridy = 7;
      manageClientPanel.add(streetTxtField, gbc_streetTxtField);
      
      JLabel cityLabel = new JLabel("City");
      GridBagConstraints gbc_cityLabel = new GridBagConstraints();
      gbc_cityLabel.anchor = GridBagConstraints.EAST;
      gbc_cityLabel.insets = new Insets(0, 0, 5, 5);
      gbc_cityLabel.gridx = 1;
      gbc_cityLabel.gridy = 8;
      manageClientPanel.add(cityLabel, gbc_cityLabel);
      
      cityTxtField = new JTextField();
      cityTxtField.setColumns(10);
      GridBagConstraints gbc_cityTxtField = new GridBagConstraints();
      gbc_cityTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_cityTxtField.anchor = GridBagConstraints.NORTH;
      gbc_cityTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_cityTxtField.gridx = 2;
      gbc_cityTxtField.gridy = 8;
      manageClientPanel.add(cityTxtField, gbc_cityTxtField);
      
      JLabel stateLabel = new JLabel("State");
      GridBagConstraints gbc_stateLabel = new GridBagConstraints();
      gbc_stateLabel.anchor = GridBagConstraints.EAST;
      gbc_stateLabel.insets = new Insets(0, 0, 5, 5);
      gbc_stateLabel.gridx = 1;
      gbc_stateLabel.gridy = 9;
      manageClientPanel.add(stateLabel, gbc_stateLabel);
      
      stateTxtField = new JTextField();
      stateTxtField.setColumns(10);
      GridBagConstraints gbc_stateTxtField = new GridBagConstraints();
      gbc_stateTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_stateTxtField.anchor = GridBagConstraints.NORTH;
      gbc_stateTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_stateTxtField.gridx = 2;
      gbc_stateTxtField.gridy = 9;
      manageClientPanel.add(stateTxtField, gbc_stateTxtField);
      
      JLabel lblZip = new JLabel("Zip");
      GridBagConstraints gbc_lblZip = new GridBagConstraints();
      gbc_lblZip.anchor = GridBagConstraints.EAST;
      gbc_lblZip.insets = new Insets(0, 0, 5, 5);
      gbc_lblZip.gridx = 1;
      gbc_lblZip.gridy = 10;
      manageClientPanel.add(lblZip, gbc_lblZip);
      
      zipTxtField = new JTextField();
      zipTxtField.setColumns(10);
      GridBagConstraints gbc_zipTxtField = new GridBagConstraints();
      gbc_zipTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_zipTxtField.anchor = GridBagConstraints.NORTH;
      gbc_zipTxtField.insets = new Insets(0, 0, 5, 5);
      gbc_zipTxtField.gridx = 2;
      gbc_zipTxtField.gridy = 10;
      manageClientPanel.add(zipTxtField, gbc_zipTxtField);
      
      JButton btnSelectClient = new JButton("Select Client");
      GridBagConstraints gbc_btnSelectClient = new GridBagConstraints();
      gbc_btnSelectClient.fill = GridBagConstraints.HORIZONTAL;
      gbc_btnSelectClient.insets = new Insets(0, 0, 0, 5);
      gbc_btnSelectClient.gridx = 1;
      gbc_btnSelectClient.gridy = 12;
      manageClientPanel.add(btnSelectClient, gbc_btnSelectClient);
      
      JButton btnUpdateClient = new JButton("Update Client");
      GridBagConstraints gbc_btnUpdateClient = new GridBagConstraints();
      gbc_btnUpdateClient.anchor = GridBagConstraints.WEST;
      gbc_btnUpdateClient.insets = new Insets(0, 0, 0, 5);
      gbc_btnUpdateClient.gridx = 2;
      gbc_btnUpdateClient.gridy = 12;
      manageClientPanel.add(btnUpdateClient, gbc_btnUpdateClient);
      btnUpdateClient.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (c != null) {
               updateClientModel();
               clientRepo.UpdateClient(c);
               System.out.println("Updated client model...");
            } else {
               System.out.println("no client is currently loaded");
            }
         }
      });
      btnSelectClient.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            searchDialog.setVisible(true);
            Client client = searchDialog.getSelectedClient();
            if (client != null) {
               updateFields(client);
               c = client;
            }
         }
      });
      
      JPanel createClientPanel = new JPanel();
      tabbedPane.addTab("Create", null, createClientPanel, null);
      createClientPanel.setLayout(new BorderLayout(0, 0));
      
      JPanel panel_2 = new JPanel();
      panel_2.setAlignmentY(1.0f);
      createClientPanel.add(panel_2);
      GridBagLayout gbl_panel_2 = new GridBagLayout();
      gbl_panel_2.columnWidths = new int[]{36, 101, 249, 21, 0};
      gbl_panel_2.rowHeights = new int[]{0, 0, 20, 0, 20, 20, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
      gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      panel_2.setLayout(gbl_panel_2);
      
      Component verticalStrut = Box.createVerticalStrut(20);
      GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
      gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
      gbc_verticalStrut.gridx = 2;
      gbc_verticalStrut.gridy = 0;
      panel_2.add(verticalStrut, gbc_verticalStrut);
      
      JLabel label_1 = new JLabel("License Number");
      GridBagConstraints gbc_label_1 = new GridBagConstraints();
      gbc_label_1.anchor = GridBagConstraints.EAST;
      gbc_label_1.insets = new Insets(0, 0, 5, 5);
      gbc_label_1.gridx = 1;
      gbc_label_1.gridy = 1;
      panel_2.add(label_1, gbc_label_1);
      
      lic = new JTextField();
      GridBagConstraints gbc_lic = new GridBagConstraints();
      gbc_lic.insets = new Insets(0, 0, 5, 5);
      gbc_lic.fill = GridBagConstraints.HORIZONTAL;
      gbc_lic.gridx = 2;
      gbc_lic.gridy = 1;
      panel_2.add(lic, gbc_lic);
      lic.setColumns(10);
      
      JLabel label_2 = new JLabel("First Name");
      GridBagConstraints gbc_label_2 = new GridBagConstraints();
      gbc_label_2.anchor = GridBagConstraints.EAST;
      gbc_label_2.insets = new Insets(0, 0, 5, 5);
      gbc_label_2.gridx = 1;
      gbc_label_2.gridy = 2;
      panel_2.add(label_2, gbc_label_2);
      
      fir = new JTextField();
      fir.setColumns(15);
      GridBagConstraints gbc_fir = new GridBagConstraints();
      gbc_fir.fill = GridBagConstraints.HORIZONTAL;
      gbc_fir.anchor = GridBagConstraints.NORTH;
      gbc_fir.insets = new Insets(0, 0, 5, 5);
      gbc_fir.gridx = 2;
      gbc_fir.gridy = 2;
      panel_2.add(fir, gbc_fir);
      
      JLabel label_3 = new JLabel("Last Name");
      GridBagConstraints gbc_label_3 = new GridBagConstraints();
      gbc_label_3.anchor = GridBagConstraints.EAST;
      gbc_label_3.insets = new Insets(0, 0, 5, 5);
      gbc_label_3.gridx = 1;
      gbc_label_3.gridy = 3;
      panel_2.add(label_3, gbc_label_3);
      
      las = new JTextField();
      las.setColumns(15);
      GridBagConstraints gbc_las = new GridBagConstraints();
      gbc_las.fill = GridBagConstraints.HORIZONTAL;
      gbc_las.anchor = GridBagConstraints.NORTH;
      gbc_las.insets = new Insets(0, 0, 5, 5);
      gbc_las.gridx = 2;
      gbc_las.gridy = 3;
      panel_2.add(las, gbc_las);
      
      JLabel label_4 = new JLabel("Date of Birth");
      GridBagConstraints gbc_label_4 = new GridBagConstraints();
      gbc_label_4.anchor = GridBagConstraints.EAST;
      gbc_label_4.insets = new Insets(0, 0, 5, 5);
      gbc_label_4.gridx = 1;
      gbc_label_4.gridy = 4;
      panel_2.add(label_4, gbc_label_4);
      
      dob = new DatePicker();
      GridBagConstraints gbc_dob = new GridBagConstraints();
      gbc_dob.fill = GridBagConstraints.HORIZONTAL;
      gbc_dob.anchor = GridBagConstraints.NORTH;
      gbc_dob.insets = new Insets(0, 0, 5, 5);
      gbc_dob.gridx = 2;
      gbc_dob.gridy = 4;
      panel_2.add(dob, gbc_dob);
      
      JLabel label_5 = new JLabel("Email");
      GridBagConstraints gbc_label_5 = new GridBagConstraints();
      gbc_label_5.anchor = GridBagConstraints.EAST;
      gbc_label_5.insets = new Insets(0, 0, 5, 5);
      gbc_label_5.gridx = 1;
      gbc_label_5.gridy = 5;
      panel_2.add(label_5, gbc_label_5);
      
      email = new JTextField();
      email.setColumns(30);
      GridBagConstraints gbc_email = new GridBagConstraints();
      gbc_email.fill = GridBagConstraints.HORIZONTAL;
      gbc_email.anchor = GridBagConstraints.NORTH;
      gbc_email.insets = new Insets(0, 0, 5, 5);
      gbc_email.gridx = 2;
      gbc_email.gridy = 5;
      panel_2.add(email, gbc_email);
      
      JLabel label_6 = new JLabel("Phone");
      GridBagConstraints gbc_label_6 = new GridBagConstraints();
      gbc_label_6.anchor = GridBagConstraints.EAST;
      gbc_label_6.insets = new Insets(0, 0, 5, 5);
      gbc_label_6.gridx = 1;
      gbc_label_6.gridy = 6;
      panel_2.add(label_6, gbc_label_6);
      
      pho = new JTextField();
      pho.setColumns(10);
      GridBagConstraints gbc_pho = new GridBagConstraints();
      gbc_pho.fill = GridBagConstraints.HORIZONTAL;
      gbc_pho.anchor = GridBagConstraints.NORTH;
      gbc_pho.insets = new Insets(0, 0, 5, 5);
      gbc_pho.gridx = 2;
      gbc_pho.gridy = 6;
      panel_2.add(pho, gbc_pho);
      
      JLabel label_7 = new JLabel("Street");
      GridBagConstraints gbc_label_7 = new GridBagConstraints();
      gbc_label_7.anchor = GridBagConstraints.EAST;
      gbc_label_7.insets = new Insets(0, 0, 5, 5);
      gbc_label_7.gridx = 1;
      gbc_label_7.gridy = 7;
      panel_2.add(label_7, gbc_label_7);
      
      str = new JTextField();
      str.setColumns(10);
      GridBagConstraints gbc_str = new GridBagConstraints();
      gbc_str.fill = GridBagConstraints.HORIZONTAL;
      gbc_str.anchor = GridBagConstraints.NORTH;
      gbc_str.insets = new Insets(0, 0, 5, 5);
      gbc_str.gridx = 2;
      gbc_str.gridy = 7;
      panel_2.add(str, gbc_str);
      
      JLabel label_8 = new JLabel("City");
      GridBagConstraints gbc_label_8 = new GridBagConstraints();
      gbc_label_8.anchor = GridBagConstraints.EAST;
      gbc_label_8.insets = new Insets(0, 0, 5, 5);
      gbc_label_8.gridx = 1;
      gbc_label_8.gridy = 8;
      panel_2.add(label_8, gbc_label_8);
      
      cit = new JTextField();
      cit.setColumns(10);
      GridBagConstraints gbc_cit = new GridBagConstraints();
      gbc_cit.fill = GridBagConstraints.HORIZONTAL;
      gbc_cit.anchor = GridBagConstraints.NORTH;
      gbc_cit.insets = new Insets(0, 0, 5, 5);
      gbc_cit.gridx = 2;
      gbc_cit.gridy = 8;
      panel_2.add(cit, gbc_cit);
      
      JLabel label_9 = new JLabel("State");
      GridBagConstraints gbc_label_9 = new GridBagConstraints();
      gbc_label_9.anchor = GridBagConstraints.EAST;
      gbc_label_9.insets = new Insets(0, 0, 5, 5);
      gbc_label_9.gridx = 1;
      gbc_label_9.gridy = 9;
      panel_2.add(label_9, gbc_label_9);
      
      sta = new JTextField();
      sta.setColumns(10);
      GridBagConstraints gbc_sta = new GridBagConstraints();
      gbc_sta.fill = GridBagConstraints.HORIZONTAL;
      gbc_sta.anchor = GridBagConstraints.NORTH;
      gbc_sta.insets = new Insets(0, 0, 5, 5);
      gbc_sta.gridx = 2;
      gbc_sta.gridy = 9;
      panel_2.add(sta, gbc_sta);
      
      JLabel label_10 = new JLabel("Zip");
      GridBagConstraints gbc_label_10 = new GridBagConstraints();
      gbc_label_10.anchor = GridBagConstraints.EAST;
      gbc_label_10.insets = new Insets(0, 0, 5, 5);
      gbc_label_10.gridx = 1;
      gbc_label_10.gridy = 10;
      panel_2.add(label_10, gbc_label_10);
      
      zip = new JTextField();
      zip.setColumns(10);
      GridBagConstraints gbc_zip = new GridBagConstraints();
      gbc_zip.fill = GridBagConstraints.HORIZONTAL;
      gbc_zip.anchor = GridBagConstraints.NORTH;
      gbc_zip.insets = new Insets(0, 0, 5, 5);
      gbc_zip.gridx = 2;
      gbc_zip.gridy = 10;
      panel_2.add(zip, gbc_zip);
      
      JButton btnCreate = new JButton("Create Client");
      btnCreate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Client model = createClientModel();
               clientRepo.CreateClient(createClientModel());
               c = model;
               updateFields(model);
            } catch (org.hibernate.exception.ConstraintViolationException e) {
               System.out.println("Cannot create duplicate entry!");
            }
         }
      });
      GridBagConstraints gbc_btnCreate = new GridBagConstraints();
      gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
      gbc_btnCreate.gridx = 1;
      gbc_btnCreate.gridy = 12;
      panel_2.add(btnCreate, gbc_btnCreate);
      
      Component horizontalStrut_2 = Box.createHorizontalStrut(20);
      add(horizontalStrut_2, BorderLayout.WEST);
      
      Component horizontalStrut_3 = Box.createHorizontalStrut(20);
      add(horizontalStrut_3, BorderLayout.EAST);
      
      Component verticalStrut_1 = Box.createVerticalStrut(20);
      add(verticalStrut_1, BorderLayout.SOUTH);
   }
   
   private void updateFields(Client client) {
      licenseNumberTxtField.setText(client.licenseNumber);
      firstNameTxtField.setText(client.firstName);
      lastNameTxtField.setText(client.lastName);
      dobPicker.setDate(Instant.ofEpochMilli(client.dob.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
      emailTxtField.setText(client.email);
      phoneTxtField.setText(client.phone);
      streetTxtField.setText(client.street);
      cityTxtField.setText(client.city);
      stateTxtField.setText(client.state);
      zipTxtField.setText(client.zip);
   }
   
   private void updateClientModel() {
      c.firstName = firstNameTxtField.getText();
      c.lastName = lastNameTxtField.getText();
      c.dob = Date.from(dobPicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
      c.email = emailTxtField.getText();
      c.phone = phoneTxtField.getText();
      c.street = streetTxtField.getText();
      c.city = cityTxtField.getText();
      c.state = stateTxtField.getText();
      c.zip = zipTxtField.getText();
   }
   
   private Client createClientModel() {
      Client client = new Client();
      client.licenseNumber = lic.getText();
      client.firstName = fir.getText();
      client.lastName = las.getText();
      client.dob = Date.from(dob.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
      client.email = email.getText();
      client.phone = pho.getText();
      client.street = str.getText();
      client.city = cit.getText();
      client.state = sta.getText();
      client.zip = zip.getText();
      return client;
   }
}
