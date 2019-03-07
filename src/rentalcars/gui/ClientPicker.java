package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Dimension;
import rentalcars.model.Client;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ClientPicker extends JPanel {
   private JTextField clientLicenseNumberTxtField;
   private JButton clientPickerButton;
   
   private Client client;
   
   public ClientPicker() {
      setAlignmentY(0.0f);
      setAlignmentX(0.0f);
           
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{126, 0, 0};
      gridBagLayout.rowHeights = new int[]{30, 0};
      gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
      setLayout(gridBagLayout);
      
      clientLicenseNumberTxtField = new JTextField();
      clientLicenseNumberTxtField.setEditable(false);
      clientLicenseNumberTxtField.setAlignmentY(0.0f);
      clientLicenseNumberTxtField.setAlignmentX(0.0f);
      GridBagConstraints gbc_clientLicenseNumberTxtField = new GridBagConstraints();
      gbc_clientLicenseNumberTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_clientLicenseNumberTxtField.insets = new Insets(0, 0, 0, 5);
      gbc_clientLicenseNumberTxtField.gridx = 0;
      gbc_clientLicenseNumberTxtField.gridy = 0;
      add(clientLicenseNumberTxtField, gbc_clientLicenseNumberTxtField);
      clientLicenseNumberTxtField.setColumns(10);
      
      clientPickerButton = new JButton("...");
      clientPickerButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            ClientSelectDialog clientSelectDialog = new ClientSelectDialog();
            clientSelectDialog.setModal(true);
            clientSelectDialog.setVisible(true);
            Client c = clientSelectDialog.getSelectedClient();
            if (c != null) {
               client = c;
               updateClientTxt();
            }
         }
      });
      clientPickerButton.setPreferredSize(new Dimension(26, 20));
      clientPickerButton.setMinimumSize(new Dimension(26, 20));
      clientPickerButton.setMaximumSize(new Dimension(26, 20));
      GridBagConstraints gbc_clientPickerButton = new GridBagConstraints();
      gbc_clientPickerButton.gridx = 1;
      gbc_clientPickerButton.gridy = 0;
      add(clientPickerButton, gbc_clientPickerButton);

   }
   
   private void updateClientTxt() {
      if (client != null) clientLicenseNumberTxtField.setText(client.toString());
      else clientLicenseNumberTxtField.setText("");
   }

   public void setClient(Client c) {
      client = c;
      updateClientTxt();
   }
   
   public Client getClient() {
      return client;
   }
}
