package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rentalcars.model.Vehicle;

@SuppressWarnings("serial")
public class VehiclePicker extends JPanel {
   private JTextField vehicleTxtField;
   private JButton vehiclePickerButton;
   private VehicleSelectDialog dialog;
   
   private Vehicle vehicle;
   
   public VehiclePicker() {
      dialog = new VehicleSelectDialog();
      dialog.setModal(true);

      
      setAlignmentY(0.0f);
      setAlignmentX(0.0f);
           
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{126, 0, 0};
      gridBagLayout.rowHeights = new int[]{30, 0};
      gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
      setLayout(gridBagLayout);
      
      vehicleTxtField = new JTextField();
      vehicleTxtField.setEditable(false);
      vehicleTxtField.setAlignmentY(0.0f);
      vehicleTxtField.setAlignmentX(0.0f);
      GridBagConstraints gbc_clientLicenseNumberTxtField = new GridBagConstraints();
      gbc_clientLicenseNumberTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_clientLicenseNumberTxtField.insets = new Insets(0, 0, 0, 5);
      gbc_clientLicenseNumberTxtField.gridx = 0;
      gbc_clientLicenseNumberTxtField.gridy = 0;
      add(vehicleTxtField, gbc_clientLicenseNumberTxtField);
      vehicleTxtField.setColumns(10);
      
      vehiclePickerButton = new JButton("...");
      vehiclePickerButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            // Create vehicle selection dialog
            dialog.setVisible(true);
            Vehicle v = dialog.getSelectedVehicle();
            if (v != null) {
               vehicle = v;
               updateVehicleTxt();
            }
         }
      });
      vehiclePickerButton.setPreferredSize(new Dimension(26, 20));
      vehiclePickerButton.setMinimumSize(new Dimension(26, 20));
      vehiclePickerButton.setMaximumSize(new Dimension(26, 20));
      GridBagConstraints gbc_clientPickerButton = new GridBagConstraints();
      gbc_clientPickerButton.gridx = 1;
      gbc_clientPickerButton.gridy = 0;
      add(vehiclePickerButton, gbc_clientPickerButton);

   }
   
   private void updateVehicleTxt() {
      if (vehicle != null) vehicleTxtField.setText(vehicle.toString());
      else vehicleTxtField.setText("");
   }

   public void setVehicle(Vehicle v) {
      vehicle = v;
      updateVehicleTxt();
   }
   
   public Vehicle getVehicle() {
      return vehicle;
   }
}
