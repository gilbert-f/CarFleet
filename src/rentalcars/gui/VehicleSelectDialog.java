package rentalcars.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rentalcars.model.Vehicle;
import rentalcars.model.VehicleType;
import rentalcars.repo.VehicleRepository;
import rentalcars.repo.VehicleTypeRepository;
import rentalcars.repo.interfaces.IVehicleRepository;
import rentalcars.repo.interfaces.IVehicleTypeRepository;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class VehicleSelectDialog extends JDialog {

   private final JPanel contentPanel = new JPanel();
   
   private IVehicleTypeRepository typeRepo;
   private IVehicleRepository vehicleRepo;
   private Vehicle vehicle;
   
   private JTextField licenseTxt;
   private JTextField makeTxt;
   private JTextField modelTxt;
   private JList<Vehicle> resultsList;
   private JComboBox<VehicleType> vehicleTypeCombo;
   private JSpinner seatsSpinner;
   private JButton okButton;
   private JButton cancelButton;
   private BranchComboBox branchComboBox;
   private JButton btnSearch;
   private JLabel lblSelectAVehicle;
   private JLabel lblLicense;
   private JLabel lblVehicleType;
   private JLabel lblMake;
   private JLabel lblModel;
   private JLabel lblSeats;
   private JLabel lblBranch;
   private JLabel lblResults;
   private JPanel buttonPane;
   private JScrollPane scrollPane;

   public VehicleSelectDialog() {
      setMinimumSize(new Dimension(600, 485));
      
      vehicleRepo = new VehicleRepository();
      typeRepo = new VehicleTypeRepository();
      
      setBounds(100, 100, 626, 456);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      GridBagLayout gbl_contentPanel = new GridBagLayout();
      gbl_contentPanel.columnWidths = new int[]{0, 77, 0, 0, 0};
      gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
      gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
      contentPanel.setLayout(gbl_contentPanel);
      {
         lblSelectAVehicle = new JLabel("Select a Vehicle");
         lblSelectAVehicle.setFont(new Font("Tahoma", Font.PLAIN, 16));
         GridBagConstraints gbc_lblSelectAVehicle = new GridBagConstraints();
         gbc_lblSelectAVehicle.anchor = GridBagConstraints.WEST;
         gbc_lblSelectAVehicle.gridwidth = 2;
         gbc_lblSelectAVehicle.insets = new Insets(0, 0, 5, 5);
         gbc_lblSelectAVehicle.gridx = 1;
         gbc_lblSelectAVehicle.gridy = 0;
         contentPanel.add(lblSelectAVehicle, gbc_lblSelectAVehicle);
      }
      {
         lblLicense = new JLabel("License");
         GridBagConstraints gbc_lblLicense = new GridBagConstraints();
         gbc_lblLicense.anchor = GridBagConstraints.EAST;
         gbc_lblLicense.insets = new Insets(0, 0, 5, 5);
         gbc_lblLicense.gridx = 1;
         gbc_lblLicense.gridy = 1;
         contentPanel.add(lblLicense, gbc_lblLicense);
      }
      {
         licenseTxt = new JTextField();
         GridBagConstraints gbc_licenseTxt = new GridBagConstraints();
         gbc_licenseTxt.insets = new Insets(0, 0, 5, 5);
         gbc_licenseTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_licenseTxt.gridx = 2;
         gbc_licenseTxt.gridy = 1;
         contentPanel.add(licenseTxt, gbc_licenseTxt);
         licenseTxt.setColumns(10);
      }
      {
         lblVehicleType = new JLabel("Vehicle Type");
         GridBagConstraints gbc_lblVehicleType = new GridBagConstraints();
         gbc_lblVehicleType.anchor = GridBagConstraints.EAST;
         gbc_lblVehicleType.insets = new Insets(0, 0, 5, 5);
         gbc_lblVehicleType.gridx = 1;
         gbc_lblVehicleType.gridy = 2;
         contentPanel.add(lblVehicleType, gbc_lblVehicleType);
      }
      {
         vehicleTypeCombo = new JComboBox<VehicleType>();
         for (VehicleType type : typeRepo.GetAllVehicleTypes())
            vehicleTypeCombo.addItem(type);
         vehicleTypeCombo.setSelectedIndex(-1);
         GridBagConstraints gbc_vehicleTypeCombo = new GridBagConstraints();
         gbc_vehicleTypeCombo.insets = new Insets(0, 0, 5, 5);
         gbc_vehicleTypeCombo.fill = GridBagConstraints.HORIZONTAL;
         gbc_vehicleTypeCombo.gridx = 2;
         gbc_vehicleTypeCombo.gridy = 2;
         contentPanel.add(vehicleTypeCombo, gbc_vehicleTypeCombo);
      }
      {
         lblMake = new JLabel("Make");
         GridBagConstraints gbc_lblMake = new GridBagConstraints();
         gbc_lblMake.anchor = GridBagConstraints.EAST;
         gbc_lblMake.insets = new Insets(0, 0, 5, 5);
         gbc_lblMake.gridx = 1;
         gbc_lblMake.gridy = 3;
         contentPanel.add(lblMake, gbc_lblMake);
      }
      {
         makeTxt = new JTextField();
         GridBagConstraints gbc_makeTxt = new GridBagConstraints();
         gbc_makeTxt.insets = new Insets(0, 0, 5, 5);
         gbc_makeTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_makeTxt.gridx = 2;
         gbc_makeTxt.gridy = 3;
         contentPanel.add(makeTxt, gbc_makeTxt);
         makeTxt.setColumns(10);
      }
      {
         lblModel = new JLabel("Model");
         GridBagConstraints gbc_lblModel = new GridBagConstraints();
         gbc_lblModel.anchor = GridBagConstraints.EAST;
         gbc_lblModel.insets = new Insets(0, 0, 5, 5);
         gbc_lblModel.gridx = 1;
         gbc_lblModel.gridy = 4;
         contentPanel.add(lblModel, gbc_lblModel);
      }
      {
         modelTxt = new JTextField();
         GridBagConstraints gbc_modelTxt = new GridBagConstraints();
         gbc_modelTxt.insets = new Insets(0, 0, 5, 5);
         gbc_modelTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_modelTxt.gridx = 2;
         gbc_modelTxt.gridy = 4;
         contentPanel.add(modelTxt, gbc_modelTxt);
         modelTxt.setColumns(10);
      }
      {
         lblSeats = new JLabel("Seats");
         GridBagConstraints gbc_lblSeats = new GridBagConstraints();
         gbc_lblSeats.anchor = GridBagConstraints.EAST;
         gbc_lblSeats.insets = new Insets(0, 0, 5, 5);
         gbc_lblSeats.gridx = 1;
         gbc_lblSeats.gridy = 5;
         contentPanel.add(lblSeats, gbc_lblSeats);
      }
      {
         seatsSpinner = new JSpinner(new SpinnerNumberModel(1,1,8,1));
         GridBagConstraints gbc_seatsSpinner = new GridBagConstraints();
         gbc_seatsSpinner.fill = GridBagConstraints.HORIZONTAL;
         gbc_seatsSpinner.insets = new Insets(0, 0, 5, 5);
         gbc_seatsSpinner.gridx = 2;
         gbc_seatsSpinner.gridy = 5;
         contentPanel.add(seatsSpinner, gbc_seatsSpinner);
      }
      {
         lblBranch = new JLabel("Branch");
         GridBagConstraints gbc_lblBranch = new GridBagConstraints();
         gbc_lblBranch.anchor = GridBagConstraints.EAST;
         gbc_lblBranch.insets = new Insets(0, 0, 5, 5);
         gbc_lblBranch.gridx = 1;
         gbc_lblBranch.gridy = 6;
         contentPanel.add(lblBranch, gbc_lblBranch);
      }
      {
         branchComboBox = new BranchComboBox();
         branchComboBox.populate();
         branchComboBox.setSelectedIndex(-1);
         
         GridBagConstraints gbc_comboBox = new GridBagConstraints();
         gbc_comboBox.insets = new Insets(0, 0, 5, 5);
         gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
         gbc_comboBox.gridx = 2;
         gbc_comboBox.gridy = 6;
         contentPanel.add(branchComboBox, gbc_comboBox);
      }
      {
         btnSearch = new JButton("Search");
         btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Vehicle v = new Vehicle();
               v.license = licenseTxt.getText().trim();
               v.make = makeTxt.getText().trim();
               v.model = modelTxt.getText().trim();
               v.seats = ((Integer) seatsSpinner.getValue()).intValue();
               v.type = (VehicleType) vehicleTypeCombo.getSelectedItem();
               v.currentBranch = branchComboBox.get();
               List<Vehicle> results = vehicleRepo.SearchVehicles(v);
               if (results != null) {
                  lblResults.setText("Results (" + results.size() + ")");
                  DefaultListModel<Vehicle> model = new DefaultListModel<Vehicle>();
                  for (Vehicle result : results)
                     model.addElement(result);
                  resultsList.setModel(model);
               }
                  
            }
         });
         GridBagConstraints gbc_btnSearch = new GridBagConstraints();
         gbc_btnSearch.fill = GridBagConstraints.HORIZONTAL;
         gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
         gbc_btnSearch.gridx = 1;
         gbc_btnSearch.gridy = 7;
         contentPanel.add(btnSearch, gbc_btnSearch);
      }
      {
         lblResults = new JLabel("Results");
         lblResults.setFont(new Font("Tahoma", Font.PLAIN, 16));
         GridBagConstraints gbc_lblResults = new GridBagConstraints();
         gbc_lblResults.anchor = GridBagConstraints.WEST;
         gbc_lblResults.gridwidth = 2;
         gbc_lblResults.insets = new Insets(0, 0, 5, 5);
         gbc_lblResults.gridx = 1;
         gbc_lblResults.gridy = 8;
         contentPanel.add(lblResults, gbc_lblResults);
      }
      {
         scrollPane = new JScrollPane();
         GridBagConstraints gbc_scrollPane = new GridBagConstraints();
         gbc_scrollPane.gridwidth = 2;
         gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
         gbc_scrollPane.fill = GridBagConstraints.BOTH;
         gbc_scrollPane.gridx = 1;
         gbc_scrollPane.gridy = 9;
         contentPanel.add(scrollPane, gbc_scrollPane);
      }
      {
         resultsList = new JList<Vehicle>();
         resultsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
               vehicle = (Vehicle) resultsList.getSelectedValue();
            }
         });
         GridBagConstraints gbc_list = new GridBagConstraints();
         gbc_list.gridwidth = 2;
         gbc_list.insets = new Insets(0, 0, 0, 5);
         gbc_list.fill = GridBagConstraints.BOTH;
         gbc_list.gridx = 1;
         gbc_list.gridy = 9;
         //contentPanel.add(resultsList, gbc_list);
         scrollPane.setViewportView(resultsList);
      }
      {
         buttonPane = new JPanel();
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  dispose();
               }
            });
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
         }
         {
            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  vehicle = null;
                  dispose();
               }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
         }
         buttonPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{okButton, cancelButton}));
      }
      setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{licenseTxt, vehicleTypeCombo, makeTxt, modelTxt, seatsSpinner, branchComboBox, btnSearch, okButton, cancelButton}));
   }

   public Vehicle getSelectedVehicle() {
      return vehicle;
   }
}
