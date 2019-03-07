package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;

import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import rentalcars.repo.VehicleTypeRepository;
import rentalcars.repo.interfaces.IVehicleTypeRepository;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ManageRatesPanel extends JPanel {

   private IVehicleTypeRepository repo;
   private VehicleTypeComboBox vehicleTypeComboBox;
   private JSpinner rateSpinner;
   
   public ManageRatesPanel() {
      setLayout(new BorderLayout(0, 0));
      
      repo = new VehicleTypeRepository();
            
      Box headerBox = Box.createHorizontalBox();
      add(headerBox, BorderLayout.NORTH);
      
      Component horizontalStrut = Box.createHorizontalStrut(10);
      headerBox.add(horizontalStrut);
      
      JLabel lblCreateABooking = new JLabel("Adjust Rates");
      lblCreateABooking.setFont(new Font("Tahoma", Font.PLAIN, 32));
      headerBox.add(lblCreateABooking);
      
      Component horizontalGlue = Box.createHorizontalGlue();
      headerBox.add(horizontalGlue);
      
      ImageIcon bookingImageIcon = new ImageIcon(getClass().getResource("/icons/rate.png"));
      Image originalBookingImage = bookingImageIcon.getImage();
      Image resizedBookingImage = originalBookingImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
      bookingImageIcon = new ImageIcon(resizedBookingImage);
      JLabel hatchbackJLabel = new JLabel(bookingImageIcon);
      headerBox.add(hatchbackJLabel);
      
      Component horizontalStrut_1 = Box.createHorizontalStrut(10);
      headerBox.add(horizontalStrut_1);
      
      Component horizontalStrut_2 = Box.createHorizontalStrut(20);
      add(horizontalStrut_2, BorderLayout.WEST);
      
      Component horizontalStrut_3 = Box.createHorizontalStrut(20);
      add(horizontalStrut_3, BorderLayout.EAST);
      
      JPanel panel = new JPanel();
      add(panel, BorderLayout.CENTER);
      GridBagLayout gbl_panel = new GridBagLayout();
      gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
      gbl_panel.rowHeights = new int[]{60, 0, 0, 0, 0};
      gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
      gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      panel.setLayout(gbl_panel);
      
      JLabel lblVehicleType = new JLabel("Vehicle Type");
      GridBagConstraints gbc_lblVehicleType = new GridBagConstraints();
      gbc_lblVehicleType.anchor = GridBagConstraints.EAST;
      gbc_lblVehicleType.insets = new Insets(0, 0, 5, 5);
      gbc_lblVehicleType.gridx = 1;
      gbc_lblVehicleType.gridy = 1;
      panel.add(lblVehicleType, gbc_lblVehicleType);
      
      vehicleTypeComboBox = new VehicleTypeComboBox();
      vehicleTypeComboBox.populate();
      vehicleTypeComboBox.setSelectedIndex(-1);
      vehicleTypeComboBox.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            rateSpinner.setValue(vehicleTypeComboBox.get().rate);
         }
      });
      GridBagConstraints gbc_vehicleTypeComboBox = new GridBagConstraints();
      gbc_vehicleTypeComboBox.insets = new Insets(0, 0, 5, 5);
      gbc_vehicleTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
      gbc_vehicleTypeComboBox.gridx = 2;
      gbc_vehicleTypeComboBox.gridy = 1;
      panel.add(vehicleTypeComboBox, gbc_vehicleTypeComboBox);
      
      JLabel lblRate = new JLabel("Rate");
      GridBagConstraints gbc_lblRate = new GridBagConstraints();
      gbc_lblRate.insets = new Insets(0, 0, 5, 5);
      gbc_lblRate.gridx = 1;
      gbc_lblRate.gridy = 2;
      panel.add(lblRate, gbc_lblRate);
      
      rateSpinner = new JSpinner();
      rateSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, 999.0, 10.0));
      GridBagConstraints gbc_rateSpinner = new GridBagConstraints();
      gbc_rateSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_rateSpinner.insets = new Insets(0, 0, 5, 5);
      gbc_rateSpinner.gridx = 2;
      gbc_rateSpinner.gridy = 2;
      panel.add(rateSpinner, gbc_rateSpinner);
      
      JButton btnUpdate = new JButton("Update");
      btnUpdate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (vehicleTypeComboBox.get() == null) {
               JOptionPane.showMessageDialog(null, "Must select a rate!!!");
               return;
            }
            vehicleTypeComboBox.get().rate = (double) rateSpinner.getValue();
            repo.UpdateVehicleType(vehicleTypeComboBox.get());
            JOptionPane.showMessageDialog(null, "Updated.");
         }
      });
      GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
      gbc_btnUpdate.anchor = GridBagConstraints.EAST;
      gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
      gbc_btnUpdate.gridx = 2;
      gbc_btnUpdate.gridy = 3;
      panel.add(btnUpdate, gbc_btnUpdate);
   }
   
}
