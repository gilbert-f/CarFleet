package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.hibernate.exception.ConstraintViolationException;

import rentalcars.model.Vehicle;
import rentalcars.repo.VehicleRepository;
import rentalcars.repo.interfaces.IVehicleRepository;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;

public class ManageVehiclesPanel extends JPanel {

   private static final long serialVersionUID = 1L;
   private JTabbedPane tabbedPane;
   private JTextField licenseTxt;
   private JTextField makeTxt;
   private JTextField modelTxt;
   private JTextField seatsTxt;
   private VehicleSelectDialog vehicleSelectDialog;
   private VehicleTypeComboBox vehicleTypeComboBox;
   private JSpinner odometerSpinner;
   
   private IVehicleRepository repo;
   private Vehicle vehicle;
   
   private JTextField colorTxt;
   private InsurancePicker insurancePicker;
   private BranchComboBox branchComboBox;
   private JCheckBox availabilityCheckBox;
   private JTextField lic;
   private JTextField make;
   private JTextField model;
   private JTextField color;
   private InsurancePicker insurance;
   private BranchComboBox branch;
   private VehicleTypeComboBox type;
   
   public ManageVehiclesPanel() {
      
      repo = new VehicleRepository();
      
      vehicleSelectDialog = new VehicleSelectDialog();
      vehicleSelectDialog.setModal(true);
      
      setLayout(new BorderLayout(0, 0));
      
      Box horizontalBox = Box.createHorizontalBox();
      add(horizontalBox, BorderLayout.NORTH);
      
      Component horizontalStrut = Box.createHorizontalStrut(10);
      horizontalBox.add(horizontalStrut);
      
      JLabel lblGetCarBy = new JLabel("Manage Vehicles");
      lblGetCarBy.setFont(new Font("Tahoma", Font.PLAIN, 32));
      horizontalBox.add(lblGetCarBy);
      
      Component horizontalGlue = Box.createHorizontalGlue();
      horizontalBox.add(horizontalGlue);
      
      ImageIcon hatchbackImageIcon = new ImageIcon(getClass().getResource("/icons/vehicles.png"));
      Image originalHatchbackImage = hatchbackImageIcon.getImage();
      Image resizedHatchbackImage = originalHatchbackImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
      hatchbackImageIcon = new ImageIcon(resizedHatchbackImage);
      JLabel hatchbackJLabel = new JLabel(hatchbackImageIcon);
      horizontalBox.add(hatchbackJLabel);
      
      Component horizontalStrut_1 = Box.createHorizontalStrut(10);
      horizontalBox.add(horizontalStrut_1);
      
      Component horizontalStrut_2 = Box.createHorizontalStrut(20);
      add(horizontalStrut_2, BorderLayout.WEST);
      
      Component horizontalStrut_3 = Box.createHorizontalStrut(20);
      add(horizontalStrut_3, BorderLayout.EAST);
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      add(tabbedPane, BorderLayout.CENTER);
      
      JPanel manageVehicles = new JPanel();
      tabbedPane.addTab("Manage Vehicles", null, manageVehicles, null);
      GridBagLayout gbl_manageVehicles = new GridBagLayout();
      gbl_manageVehicles.columnWidths = new int[]{116, 0, 0};
      gbl_manageVehicles.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, -69, 0, 0, 0, 0, 0};
      gbl_manageVehicles.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
      gbl_manageVehicles.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      manageVehicles.setLayout(gbl_manageVehicles);
      
      JLabel lblLicense = new JLabel("License");
      GridBagConstraints gbc_lblLicense = new GridBagConstraints();
      gbc_lblLicense.insets = new Insets(0, 0, 5, 5);
      gbc_lblLicense.anchor = GridBagConstraints.EAST;
      gbc_lblLicense.gridx = 0;
      gbc_lblLicense.gridy = 0;
      manageVehicles.add(lblLicense, gbc_lblLicense);
      
      licenseTxt = new JTextField();
      GridBagConstraints gbc_licenseTxt = new GridBagConstraints();
      gbc_licenseTxt.insets = new Insets(0, 0, 5, 0);
      gbc_licenseTxt.fill = GridBagConstraints.HORIZONTAL;
      gbc_licenseTxt.gridx = 1;
      gbc_licenseTxt.gridy = 0;
      manageVehicles.add(licenseTxt, gbc_licenseTxt);
      licenseTxt.setColumns(10);
      
      JLabel lblType = new JLabel("Type");
      GridBagConstraints gbc_lblType = new GridBagConstraints();
      gbc_lblType.anchor = GridBagConstraints.EAST;
      gbc_lblType.insets = new Insets(0, 0, 5, 5);
      gbc_lblType.gridx = 0;
      gbc_lblType.gridy = 1;
      manageVehicles.add(lblType, gbc_lblType);
      
      vehicleTypeComboBox = new VehicleTypeComboBox();
      vehicleTypeComboBox.populate();
      vehicleTypeComboBox.setSelectedIndex(-1);
      GridBagConstraints gbc_vehicleTypeComboBox = new GridBagConstraints();
      gbc_vehicleTypeComboBox.insets = new Insets(0, 0, 5, 0);
      gbc_vehicleTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
      gbc_vehicleTypeComboBox.gridx = 1;
      gbc_vehicleTypeComboBox.gridy = 1;
      manageVehicles.add(vehicleTypeComboBox, gbc_vehicleTypeComboBox);
      
      JLabel lblMake = new JLabel("Make");
      GridBagConstraints gbc_lblMake = new GridBagConstraints();
      gbc_lblMake.anchor = GridBagConstraints.EAST;
      gbc_lblMake.insets = new Insets(0, 0, 5, 5);
      gbc_lblMake.gridx = 0;
      gbc_lblMake.gridy = 2;
      manageVehicles.add(lblMake, gbc_lblMake);
      
      makeTxt = new JTextField();
      GridBagConstraints gbc_makeTxt = new GridBagConstraints();
      gbc_makeTxt.insets = new Insets(0, 0, 5, 0);
      gbc_makeTxt.fill = GridBagConstraints.HORIZONTAL;
      gbc_makeTxt.gridx = 1;
      gbc_makeTxt.gridy = 2;
      manageVehicles.add(makeTxt, gbc_makeTxt);
      makeTxt.setColumns(10);
      
      JLabel lblModel = new JLabel("Model");
      GridBagConstraints gbc_lblModel = new GridBagConstraints();
      gbc_lblModel.anchor = GridBagConstraints.EAST;
      gbc_lblModel.insets = new Insets(0, 0, 5, 5);
      gbc_lblModel.gridx = 0;
      gbc_lblModel.gridy = 3;
      manageVehicles.add(lblModel, gbc_lblModel);
      
      modelTxt = new JTextField();
      GridBagConstraints gbc_modelTxt = new GridBagConstraints();
      gbc_modelTxt.insets = new Insets(0, 0, 5, 0);
      gbc_modelTxt.fill = GridBagConstraints.HORIZONTAL;
      gbc_modelTxt.gridx = 1;
      gbc_modelTxt.gridy = 3;
      manageVehicles.add(modelTxt, gbc_modelTxt);
      modelTxt.setColumns(10);
      
      JLabel lblColor = new JLabel("Color");
      GridBagConstraints gbc_lblColor = new GridBagConstraints();
      gbc_lblColor.anchor = GridBagConstraints.EAST;
      gbc_lblColor.insets = new Insets(0, 0, 5, 5);
      gbc_lblColor.gridx = 0;
      gbc_lblColor.gridy = 4;
      manageVehicles.add(lblColor, gbc_lblColor);
      
      colorTxt = new JTextField();
      GridBagConstraints gbc_colorTxt = new GridBagConstraints();
      gbc_colorTxt.insets = new Insets(0, 0, 5, 0);
      gbc_colorTxt.fill = GridBagConstraints.HORIZONTAL;
      gbc_colorTxt.gridx = 1;
      gbc_colorTxt.gridy = 4;
      manageVehicles.add(colorTxt, gbc_colorTxt);
      colorTxt.setColumns(10);
      
      JLabel lblSeats = new JLabel("Seats");
      GridBagConstraints gbc_lblSeats = new GridBagConstraints();
      gbc_lblSeats.anchor = GridBagConstraints.EAST;
      gbc_lblSeats.insets = new Insets(0, 0, 5, 5);
      gbc_lblSeats.gridx = 0;
      gbc_lblSeats.gridy = 5;
      manageVehicles.add(lblSeats, gbc_lblSeats);
      
      seatsTxt = new JTextField();
      seatsTxt.setEditable(false);
      GridBagConstraints gbc_seatsTxt = new GridBagConstraints();
      gbc_seatsTxt.insets = new Insets(0, 0, 5, 0);
      gbc_seatsTxt.fill = GridBagConstraints.HORIZONTAL;
      gbc_seatsTxt.gridx = 1;
      gbc_seatsTxt.gridy = 5;
      manageVehicles.add(seatsTxt, gbc_seatsTxt);
      seatsTxt.setColumns(10);
      
      JLabel lblOdometer = new JLabel("Odometer");
      GridBagConstraints gbc_lblOdometer = new GridBagConstraints();
      gbc_lblOdometer.anchor = GridBagConstraints.EAST;
      gbc_lblOdometer.insets = new Insets(0, 0, 5, 5);
      gbc_lblOdometer.gridx = 0;
      gbc_lblOdometer.gridy = 6;
      manageVehicles.add(lblOdometer, gbc_lblOdometer);
      
      odometerSpinner = new JSpinner(new SpinnerNumberModel(0,0,999999,10));
      GridBagConstraints gbc_odometerSpinner = new GridBagConstraints();
      gbc_odometerSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_odometerSpinner.insets = new Insets(0, 0, 5, 0);
      gbc_odometerSpinner.gridx = 1;
      gbc_odometerSpinner.gridy = 6;
      manageVehicles.add(odometerSpinner, gbc_odometerSpinner);
      
      JLabel lblInsurance = new JLabel("Insurance");
      GridBagConstraints gbc_lblInsurance = new GridBagConstraints();
      gbc_lblInsurance.anchor = GridBagConstraints.EAST;
      gbc_lblInsurance.insets = new Insets(0, 0, 5, 5);
      gbc_lblInsurance.gridx = 0;
      gbc_lblInsurance.gridy = 7;
      manageVehicles.add(lblInsurance, gbc_lblInsurance);
      
      insurancePicker = new InsurancePicker();
      GridBagConstraints gbc_insurancePicker = new GridBagConstraints();
      gbc_insurancePicker.insets = new Insets(0, 0, 5, 0);
      gbc_insurancePicker.fill = GridBagConstraints.BOTH;
      gbc_insurancePicker.gridx = 1;
      gbc_insurancePicker.gridy = 7;
      manageVehicles.add(insurancePicker, gbc_insurancePicker);
      
      JLabel lblCurrentBranch = new JLabel("Current Branch");
      GridBagConstraints gbc_lblCurrentBranch = new GridBagConstraints();
      gbc_lblCurrentBranch.insets = new Insets(0, 0, 5, 5);
      gbc_lblCurrentBranch.anchor = GridBagConstraints.EAST;
      gbc_lblCurrentBranch.gridx = 0;
      gbc_lblCurrentBranch.gridy = 8;
      manageVehicles.add(lblCurrentBranch, gbc_lblCurrentBranch);
      
      branchComboBox = new BranchComboBox();
      branchComboBox.populate();
      branchComboBox.setSelectedIndex(-1);
      GridBagConstraints gbc_branchComboBox = new GridBagConstraints();
      gbc_branchComboBox.insets = new Insets(0, 0, 5, 0);
      gbc_branchComboBox.fill = GridBagConstraints.HORIZONTAL;
      gbc_branchComboBox.gridx = 1;
      gbc_branchComboBox.gridy = 8;
      manageVehicles.add(branchComboBox, gbc_branchComboBox);
      
      JLabel lblAvailable = new JLabel("Available");
      GridBagConstraints gbc_lblAvailable = new GridBagConstraints();
      gbc_lblAvailable.insets = new Insets(0, 0, 5, 5);
      gbc_lblAvailable.gridx = 0;
      gbc_lblAvailable.gridy = 9;
      manageVehicles.add(lblAvailable, gbc_lblAvailable);
      
      availabilityCheckBox = new JCheckBox("");
      GridBagConstraints gbc_availabilityCheckBox = new GridBagConstraints();
      gbc_availabilityCheckBox.insets = new Insets(0, 0, 5, 0);
      gbc_availabilityCheckBox.anchor = GridBagConstraints.WEST;
      gbc_availabilityCheckBox.gridx = 1;
      gbc_availabilityCheckBox.gridy = 9;
      manageVehicles.add(availabilityCheckBox, gbc_availabilityCheckBox);
      
      JButton btnSelectVehicle = new JButton("Select Vehicle");
      btnSelectVehicle.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            vehicleSelectDialog.setVisible(true);
            Vehicle v = vehicleSelectDialog.getSelectedVehicle();
            if (v != null) {
               vehicle = v;
               updateVehicleFields();
            }
         }
      });
      GridBagConstraints gbc_btnSelectVehicle = new GridBagConstraints();
      gbc_btnSelectVehicle.fill = GridBagConstraints.HORIZONTAL;
      gbc_btnSelectVehicle.insets = new Insets(0, 0, 0, 5);
      gbc_btnSelectVehicle.gridx = 0;
      gbc_btnSelectVehicle.gridy = 11;
      manageVehicles.add(btnSelectVehicle, gbc_btnSelectVehicle);
      
      JButton btnUpdateVehicle = new JButton("Update Vehicle");
      btnUpdateVehicle.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            vehicle.license = licenseTxt.getText().trim();
            vehicle.make = makeTxt.getText().trim();
            vehicle.model = modelTxt.getText().trim();
            vehicle.color = colorTxt.getText().trim();
            vehicle.type = vehicleTypeComboBox.get();
            vehicle.odometer = (int) odometerSpinner.getValue();
            vehicle.insurance = insurancePicker.getInsurance();
            vehicle.currentBranch = branchComboBox.get();
            vehicle.available = availabilityCheckBox.isSelected();
            
            repo.UpdateVehicle(vehicle);
         }
      });
      GridBagConstraints gbc_btnUpdateVehicle = new GridBagConstraints();
      gbc_btnUpdateVehicle.anchor = GridBagConstraints.WEST;
      gbc_btnUpdateVehicle.gridx = 1;
      gbc_btnUpdateVehicle.gridy = 11;
      manageVehicles.add(btnUpdateVehicle, gbc_btnUpdateVehicle);
      
      JPanel createVehicle = new JPanel();
      tabbedPane.addTab("Create Vehicle", null, createVehicle, null);
      GridBagLayout gbl_createVehicle = new GridBagLayout();
      gbl_createVehicle.columnWidths = new int[]{116, 0, 0};
      gbl_createVehicle.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, -69, 0, 0, 0, 0, 0};
      gbl_createVehicle.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
      gbl_createVehicle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      createVehicle.setLayout(gbl_createVehicle);
      
      JLabel label = new JLabel("License");
      GridBagConstraints gbc_label = new GridBagConstraints();
      gbc_label.anchor = GridBagConstraints.EAST;
      gbc_label.insets = new Insets(0, 0, 5, 5);
      gbc_label.gridx = 0;
      gbc_label.gridy = 0;
      createVehicle.add(label, gbc_label);
      
      lic = new JTextField();
      lic.setColumns(10);
      GridBagConstraints gbc_lic = new GridBagConstraints();
      gbc_lic.fill = GridBagConstraints.HORIZONTAL;
      gbc_lic.insets = new Insets(0, 0, 5, 0);
      gbc_lic.gridx = 1;
      gbc_lic.gridy = 0;
      createVehicle.add(lic, gbc_lic);
      
      JLabel label_1 = new JLabel("Type");
      GridBagConstraints gbc_label_1 = new GridBagConstraints();
      gbc_label_1.anchor = GridBagConstraints.EAST;
      gbc_label_1.insets = new Insets(0, 0, 5, 5);
      gbc_label_1.gridx = 0;
      gbc_label_1.gridy = 1;
      createVehicle.add(label_1, gbc_label_1);
      
      type = new VehicleTypeComboBox();
      type.populate();
      type.setSelectedIndex(-1);
      GridBagConstraints gbc_type = new GridBagConstraints();
      gbc_type.fill = GridBagConstraints.HORIZONTAL;
      gbc_type.insets = new Insets(0, 0, 5, 0);
      gbc_type.gridx = 1;
      gbc_type.gridy = 1;
      createVehicle.add(type, gbc_type);
      
      JLabel label_2 = new JLabel("Make");
      GridBagConstraints gbc_label_2 = new GridBagConstraints();
      gbc_label_2.anchor = GridBagConstraints.EAST;
      gbc_label_2.insets = new Insets(0, 0, 5, 5);
      gbc_label_2.gridx = 0;
      gbc_label_2.gridy = 2;
      createVehicle.add(label_2, gbc_label_2);
      
      make = new JTextField();
      make.setColumns(10);
      GridBagConstraints gbc_make = new GridBagConstraints();
      gbc_make.fill = GridBagConstraints.HORIZONTAL;
      gbc_make.insets = new Insets(0, 0, 5, 0);
      gbc_make.gridx = 1;
      gbc_make.gridy = 2;
      createVehicle.add(make, gbc_make);
      
      JLabel label_3 = new JLabel("Model");
      GridBagConstraints gbc_label_3 = new GridBagConstraints();
      gbc_label_3.anchor = GridBagConstraints.EAST;
      gbc_label_3.insets = new Insets(0, 0, 5, 5);
      gbc_label_3.gridx = 0;
      gbc_label_3.gridy = 3;
      createVehicle.add(label_3, gbc_label_3);
      
      model = new JTextField();
      model.setColumns(10);
      GridBagConstraints gbc_model = new GridBagConstraints();
      gbc_model.fill = GridBagConstraints.HORIZONTAL;
      gbc_model.insets = new Insets(0, 0, 5, 0);
      gbc_model.gridx = 1;
      gbc_model.gridy = 3;
      createVehicle.add(model, gbc_model);
      
      JLabel label_4 = new JLabel("Color");
      GridBagConstraints gbc_label_4 = new GridBagConstraints();
      gbc_label_4.anchor = GridBagConstraints.EAST;
      gbc_label_4.insets = new Insets(0, 0, 5, 5);
      gbc_label_4.gridx = 0;
      gbc_label_4.gridy = 4;
      createVehicle.add(label_4, gbc_label_4);
      
      color = new JTextField();
      color.setColumns(10);
      GridBagConstraints gbc_color = new GridBagConstraints();
      gbc_color.fill = GridBagConstraints.HORIZONTAL;
      gbc_color.insets = new Insets(0, 0, 5, 0);
      gbc_color.gridx = 1;
      gbc_color.gridy = 4;
      createVehicle.add(color, gbc_color);
      
      JLabel label_5 = new JLabel("Seats");
      GridBagConstraints gbc_label_5 = new GridBagConstraints();
      gbc_label_5.anchor = GridBagConstraints.EAST;
      gbc_label_5.insets = new Insets(0, 0, 5, 5);
      gbc_label_5.gridx = 0;
      gbc_label_5.gridy = 5;
      createVehicle.add(label_5, gbc_label_5);
      
      JSpinner seats = new JSpinner(new SpinnerNumberModel(1,1,8,1));
      GridBagConstraints gbc_seats = new GridBagConstraints();
      gbc_seats.fill = GridBagConstraints.HORIZONTAL;
      gbc_seats.insets = new Insets(0, 0, 5, 0);
      gbc_seats.gridx = 1;
      gbc_seats.gridy = 5;
      createVehicle.add(seats, gbc_seats);
      
      JLabel label_6 = new JLabel("Odometer");
      GridBagConstraints gbc_label_6 = new GridBagConstraints();
      gbc_label_6.anchor = GridBagConstraints.EAST;
      gbc_label_6.insets = new Insets(0, 0, 5, 5);
      gbc_label_6.gridx = 0;
      gbc_label_6.gridy = 6;
      createVehicle.add(label_6, gbc_label_6);
      
      JSpinner odometer = new JSpinner(new SpinnerNumberModel(0,0,400000,10000));
      GridBagConstraints gbc_odometer = new GridBagConstraints();
      gbc_odometer.fill = GridBagConstraints.HORIZONTAL;
      gbc_odometer.insets = new Insets(0, 0, 5, 0);
      gbc_odometer.gridx = 1;
      gbc_odometer.gridy = 6;
      createVehicle.add(odometer, gbc_odometer);
      
      JLabel label_7 = new JLabel("Insurance");
      GridBagConstraints gbc_label_7 = new GridBagConstraints();
      gbc_label_7.anchor = GridBagConstraints.EAST;
      gbc_label_7.insets = new Insets(0, 0, 5, 5);
      gbc_label_7.gridx = 0;
      gbc_label_7.gridy = 7;
      createVehicle.add(label_7, gbc_label_7);
      
      insurance = new InsurancePicker();
      GridBagLayout gbl_insurance = (GridBagLayout) insurance.getLayout();
      gbl_insurance.rowWeights = new double[]{0.0};
      gbl_insurance.rowHeights = new int[]{30};
      gbl_insurance.columnWeights = new double[]{1.0, 0.0};
      gbl_insurance.columnWidths = new int[]{126, 0};
      GridBagConstraints gbc_insurance = new GridBagConstraints();
      gbc_insurance.fill = GridBagConstraints.BOTH;
      gbc_insurance.insets = new Insets(0, 0, 5, 0);
      gbc_insurance.gridx = 1;
      gbc_insurance.gridy = 7;
      createVehicle.add(insurance, gbc_insurance);
      
      JLabel label_8 = new JLabel("Current Branch");
      GridBagConstraints gbc_label_8 = new GridBagConstraints();
      gbc_label_8.anchor = GridBagConstraints.EAST;
      gbc_label_8.insets = new Insets(0, 0, 5, 5);
      gbc_label_8.gridx = 0;
      gbc_label_8.gridy = 8;
      createVehicle.add(label_8, gbc_label_8);
      
      branch = new BranchComboBox();
      branch.populate();
      branch.setSelectedIndex(-1);
      GridBagConstraints gbc_branch = new GridBagConstraints();
      gbc_branch.fill = GridBagConstraints.HORIZONTAL;
      gbc_branch.insets = new Insets(0, 0, 5, 0);
      gbc_branch.gridx = 1;
      gbc_branch.gridy = 8;
      createVehicle.add(branch, gbc_branch);
      
      JLabel label_9 = new JLabel("Available");
      GridBagConstraints gbc_label_9 = new GridBagConstraints();
      gbc_label_9.insets = new Insets(0, 0, 5, 5);
      gbc_label_9.gridx = 0;
      gbc_label_9.gridy = 9;
      createVehicle.add(label_9, gbc_label_9);
      
      JCheckBox available = new JCheckBox("");
      GridBagConstraints gbc_available = new GridBagConstraints();
      gbc_available.anchor = GridBagConstraints.WEST;
      gbc_available.insets = new Insets(0, 0, 5, 0);
      gbc_available.gridx = 1;
      gbc_available.gridy = 9;
      createVehicle.add(available, gbc_available);
      
      JButton btnCreateVehicle = new JButton("Create Vehicle");
      btnCreateVehicle.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            if (!checkCreateVehicleFields())
               return;
            
            Vehicle v = new Vehicle();
            v.license = lic.getText().trim();
            v.make = make.getText().trim();
            v.model = model.getText().trim();
            v.color = color.getText().trim();
            v.insurance = insurance.getInsurance();
            v.seats = (int) seats.getValue();
            v.odometer = (int) odometer.getValue();
            v.type = type.get();
            v.currentBranch = branch.get();
            v.available = available.isSelected();
            
            try {
               repo.CreateVehicle(v);
               vehicle = v;
               updateVehicleFields();
               JOptionPane.showMessageDialog(null, "Successfully created vehicle", "Vehicle Creation Successful", JOptionPane.INFORMATION_MESSAGE);
               tabbedPane.setSelectedIndex(0);
            }
            catch (javax.persistence.PersistenceException pex) {
               ConstraintViolationException ex = (ConstraintViolationException) pex.getCause();
               JOptionPane.showMessageDialog(null, "A vehicle with that license already exists in the database.\n\nDetails:\nFailed to comply with database constraint ["
                  + ex.getConstraintName() + "]: " + ex.getCause().getMessage(), 
                  "Constraint Violation", JOptionPane.ERROR_MESSAGE);
            }
         }
      });
      GridBagConstraints gbc_btnCreateVehicle = new GridBagConstraints();
      gbc_btnCreateVehicle.fill = GridBagConstraints.HORIZONTAL;
      gbc_btnCreateVehicle.insets = new Insets(0, 0, 0, 5);
      gbc_btnCreateVehicle.gridx = 0;
      gbc_btnCreateVehicle.gridy = 11;
      createVehicle.add(btnCreateVehicle, gbc_btnCreateVehicle);

   }
   
   private boolean checkCreateVehicleFields() {
      if (lic.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(null, "Please input a license.");
         return false;
      }
      if (make.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(null, "Please input a make.");
         return false;
      }
      if (model.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(null, "Please input a model.");
         return false;
      }
      if (color.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(null, "Please input a color.");
         return false;
      }
      if (insurance.getInsurance() == null) {
         JOptionPane.showMessageDialog(null, "Please select an insurance.");
         return false;
      }
      if (type.get() == null) {
         JOptionPane.showMessageDialog(null, "Please select a type.");
         return false;
      }
      if (branch.get() == null) {
         JOptionPane.showMessageDialog(null, "Please select a current branch.");
         return false;
      }
      return true;
   }
   
   private void updateVehicleFields() {
      licenseTxt.setText(vehicle.license);
      makeTxt.setText(vehicle.make);
      modelTxt.setText(vehicle.model);
      colorTxt.setText(vehicle.color);
      seatsTxt.setText("" + vehicle.seats);
      odometerSpinner.setValue(vehicle.odometer);
      insurancePicker.setInsurance(vehicle.insurance);
      branchComboBox.set(vehicle.currentBranch);
      availabilityCheckBox.setSelected(vehicle.available);
      vehicleTypeComboBox.set(vehicle.type);
   }
}