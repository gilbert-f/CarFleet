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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.hibernate.exception.GenericJDBCException;

import rentalcars.repo.interfaces.*;
import rentalcars.repo.BookingRepository;
import com.github.lgooddatepicker.components.DatePicker;
import rentalcars.model.Booking;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import java.awt.Dimension;

public class ManageBookingsPanel extends JPanel {

   private static final long serialVersionUID = 1L;
   private IBookingRepository repo;
   
   private DatePicker pickupDate;
   private DatePicker dropoffDate;
   private JTextField txtCost;
   private JComboBox<String> paymentTypeComboBox;
   private BranchComboBox pickupBranchComboBox;
   private BranchComboBox dropoffBranchComboBox;
   private ClientPicker clientPicker;
   private VehiclePicker vehiclePicker;
   private JSpinner tankSpinner;
   private JSpinner odometerSpinner;
   private JTextField mBookingId;
   private JTextField mCost;
   private JTabbedPane tabbedPane;
   
   private BookingSelectDialog select;
   private Booking booking;
   private VehiclePicker mVehiclePicker;
   private ClientPicker mClientPicker;
   private JSpinner mStartOdoSpinner;
   private JSpinner mEndOdoSpinner;
   private JSpinner mStartTankSpinner;
   private JSpinner mEndTankSpinner;
   private BranchComboBox mPickupBranchComboBox;
   private DatePicker mPickupDatePicker;
   private BranchComboBox mDropoffBranchComboBox;
   private DatePicker mDropoffDatePicker;
   private JTextField mPaymentType;

   /**
    * Create the panel.
    */
   public ManageBookingsPanel() {
      setLayout(new BorderLayout(0, 0));
      
      select = new BookingSelectDialog();
      select.setModal(true);
      
      repo = new BookingRepository();
      
      Box headerBox = Box.createHorizontalBox();
      add(headerBox, BorderLayout.NORTH);
      
      Component horizontalStrut = Box.createHorizontalStrut(10);
      headerBox.add(horizontalStrut);
      
      JLabel lblCreateABooking = new JLabel("Manage Bookings");
      lblCreateABooking.setFont(new Font("Tahoma", Font.PLAIN, 32));
      headerBox.add(lblCreateABooking);
      
      Component horizontalGlue = Box.createHorizontalGlue();
      headerBox.add(horizontalGlue);
      
      ImageIcon bookingImageIcon = new ImageIcon(getClass().getResource("/icons/booking.png"));
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
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      add(tabbedPane, BorderLayout.CENTER);
      
      JPanel manageBookingsPanel = new JPanel();
      tabbedPane.addTab("Manage Bookings", null, manageBookingsPanel, null);
      GridBagLayout gbl_manageBookingsPanel = new GridBagLayout();
      gbl_manageBookingsPanel.columnWidths = new int[]{0, 209, 230, 0};
      gbl_manageBookingsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_manageBookingsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
      gbl_manageBookingsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      manageBookingsPanel.setLayout(gbl_manageBookingsPanel);
      
      JLabel lblBookingId = new JLabel("Booking ID");
      GridBagConstraints gbc_lblBookingId = new GridBagConstraints();
      gbc_lblBookingId.insets = new Insets(0, 0, 5, 5);
      gbc_lblBookingId.anchor = GridBagConstraints.EAST;
      gbc_lblBookingId.gridx = 0;
      gbc_lblBookingId.gridy = 0;
      manageBookingsPanel.add(lblBookingId, gbc_lblBookingId);
      
      mBookingId = new JTextField();
      mBookingId.setEnabled(false);
      mBookingId.setEditable(false);
      GridBagConstraints gbc_mBookingId = new GridBagConstraints();
      gbc_mBookingId.insets = new Insets(0, 0, 5, 5);
      gbc_mBookingId.fill = GridBagConstraints.HORIZONTAL;
      gbc_mBookingId.gridx = 1;
      gbc_mBookingId.gridy = 0;
      manageBookingsPanel.add(mBookingId, gbc_mBookingId);
      mBookingId.setColumns(10);
      
      JLabel lblVehicle = new JLabel("Vehicle");
      GridBagConstraints gbc_lblVehicle = new GridBagConstraints();
      gbc_lblVehicle.insets = new Insets(0, 0, 5, 5);
      gbc_lblVehicle.gridx = 0;
      gbc_lblVehicle.gridy = 1;
      manageBookingsPanel.add(lblVehicle, gbc_lblVehicle);
      
      mVehiclePicker = new VehiclePicker();
      for (Component c : mVehiclePicker.getComponents()) {
         c.setEnabled(false);
      }
      GridBagConstraints gbc_mVehiclePicker = new GridBagConstraints();
      gbc_mVehiclePicker.insets = new Insets(0, 0, 5, 5);
      gbc_mVehiclePicker.fill = GridBagConstraints.BOTH;
      gbc_mVehiclePicker.gridx = 1;
      gbc_mVehiclePicker.gridy = 1;
      manageBookingsPanel.add(mVehiclePicker, gbc_mVehiclePicker);
      
      JLabel lblClient = new JLabel("Client");
      GridBagConstraints gbc_lblClient = new GridBagConstraints();
      gbc_lblClient.insets = new Insets(0, 0, 5, 5);
      gbc_lblClient.gridx = 0;
      gbc_lblClient.gridy = 2;
      manageBookingsPanel.add(lblClient, gbc_lblClient);
      
      mClientPicker = new ClientPicker();
      for (Component c : mClientPicker.getComponents()) {
         c.setEnabled(false);
      }
      GridBagConstraints gbc_mClientPicker = new GridBagConstraints();
      gbc_mClientPicker.insets = new Insets(0, 0, 5, 5);
      gbc_mClientPicker.fill = GridBagConstraints.BOTH;
      gbc_mClientPicker.gridx = 1;
      gbc_mClientPicker.gridy = 2;
      manageBookingsPanel.add(mClientPicker, gbc_mClientPicker);
      
      JLabel lblStartOdometer = new JLabel("Start Odometer");
      GridBagConstraints gbc_lblStartOdometer = new GridBagConstraints();
      gbc_lblStartOdometer.insets = new Insets(0, 0, 5, 5);
      gbc_lblStartOdometer.gridx = 0;
      gbc_lblStartOdometer.gridy = 3;
      manageBookingsPanel.add(lblStartOdometer, gbc_lblStartOdometer);
      
      mStartOdoSpinner = new JSpinner(new SpinnerNumberModel(0,0,999999,100));
      GridBagConstraints gbc_mStartOdoSpinner = new GridBagConstraints();
      gbc_mStartOdoSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_mStartOdoSpinner.insets = new Insets(0, 0, 5, 5);
      gbc_mStartOdoSpinner.gridx = 1;
      gbc_mStartOdoSpinner.gridy = 3;
      manageBookingsPanel.add(mStartOdoSpinner, gbc_mStartOdoSpinner);
      
      JButton button_1 = new JButton("...");
      GridBagConstraints gbc_button_1 = new GridBagConstraints();
      gbc_button_1.anchor = GridBagConstraints.WEST;
      gbc_button_1.insets = new Insets(0, 0, 5, 0);
      gbc_button_1.gridx = 2;
      gbc_button_1.gridy = 3;
      manageBookingsPanel.add(button_1, gbc_button_1);
      
      JLabel lblEndOdometer = new JLabel("End Odometer");
      GridBagConstraints gbc_lblEndOdometer = new GridBagConstraints();
      gbc_lblEndOdometer.insets = new Insets(0, 0, 5, 5);
      gbc_lblEndOdometer.gridx = 0;
      gbc_lblEndOdometer.gridy = 4;
      manageBookingsPanel.add(lblEndOdometer, gbc_lblEndOdometer);
      
      mEndOdoSpinner = new JSpinner();
      GridBagConstraints gbc_mEndOdoSpinner = new GridBagConstraints();
      gbc_mEndOdoSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_mEndOdoSpinner.insets = new Insets(0, 0, 5, 5);
      gbc_mEndOdoSpinner.gridx = 1;
      gbc_mEndOdoSpinner.gridy = 4;
      manageBookingsPanel.add(mEndOdoSpinner, gbc_mEndOdoSpinner);
      
      JButton button_2 = new JButton("...");
      GridBagConstraints gbc_button_2 = new GridBagConstraints();
      gbc_button_2.anchor = GridBagConstraints.WEST;
      gbc_button_2.insets = new Insets(0, 0, 5, 0);
      gbc_button_2.gridx = 2;
      gbc_button_2.gridy = 4;
      manageBookingsPanel.add(button_2, gbc_button_2);
      
      JLabel lblStartTank = new JLabel("Start Tank");
      GridBagConstraints gbc_lblStartTank = new GridBagConstraints();
      gbc_lblStartTank.insets = new Insets(0, 0, 5, 5);
      gbc_lblStartTank.gridx = 0;
      gbc_lblStartTank.gridy = 5;
      manageBookingsPanel.add(lblStartTank, gbc_lblStartTank);
      
      mStartTankSpinner = new JSpinner();
      GridBagConstraints gbc_mStartTankSpinner = new GridBagConstraints();
      gbc_mStartTankSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_mStartTankSpinner.insets = new Insets(0, 0, 5, 5);
      gbc_mStartTankSpinner.gridx = 1;
      gbc_mStartTankSpinner.gridy = 5;
      manageBookingsPanel.add(mStartTankSpinner, gbc_mStartTankSpinner);
      
      JLabel lblEndTank = new JLabel("End Tank");
      GridBagConstraints gbc_lblEndTank = new GridBagConstraints();
      gbc_lblEndTank.insets = new Insets(0, 0, 5, 5);
      gbc_lblEndTank.gridx = 0;
      gbc_lblEndTank.gridy = 6;
      manageBookingsPanel.add(lblEndTank, gbc_lblEndTank);
      
      mEndTankSpinner = new JSpinner();
      GridBagConstraints gbc_mEndTankSpinner = new GridBagConstraints();
      gbc_mEndTankSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_mEndTankSpinner.insets = new Insets(0, 0, 5, 5);
      gbc_mEndTankSpinner.gridx = 1;
      gbc_mEndTankSpinner.gridy = 6;
      manageBookingsPanel.add(mEndTankSpinner, gbc_mEndTankSpinner);
      
      JLabel lblCost_1 = new JLabel("Cost");
      GridBagConstraints gbc_lblCost_1 = new GridBagConstraints();
      gbc_lblCost_1.anchor = GridBagConstraints.EAST;
      gbc_lblCost_1.insets = new Insets(0, 0, 5, 5);
      gbc_lblCost_1.gridx = 0;
      gbc_lblCost_1.gridy = 7;
      manageBookingsPanel.add(lblCost_1, gbc_lblCost_1);
      
      mCost = new JTextField();
      GridBagConstraints gbc_mCost = new GridBagConstraints();
      gbc_mCost.insets = new Insets(0, 0, 5, 5);
      gbc_mCost.fill = GridBagConstraints.HORIZONTAL;
      gbc_mCost.gridx = 1;
      gbc_mCost.gridy = 7;
      manageBookingsPanel.add(mCost, gbc_mCost);
      mCost.setColumns(10);
      
      JLabel lblPaymentType_1 = new JLabel("Payment Type");
      GridBagConstraints gbc_lblPaymentType_1 = new GridBagConstraints();
      gbc_lblPaymentType_1.anchor = GridBagConstraints.EAST;
      gbc_lblPaymentType_1.insets = new Insets(0, 0, 5, 5);
      gbc_lblPaymentType_1.gridx = 0;
      gbc_lblPaymentType_1.gridy = 8;
      manageBookingsPanel.add(lblPaymentType_1, gbc_lblPaymentType_1);
      
      mPaymentType = new JTextField();
      GridBagConstraints gbc_mPaymentType = new GridBagConstraints();
      gbc_mPaymentType.insets = new Insets(0, 0, 5, 5);
      gbc_mPaymentType.fill = GridBagConstraints.HORIZONTAL;
      gbc_mPaymentType.gridx = 1;
      gbc_mPaymentType.gridy = 8;
      manageBookingsPanel.add(mPaymentType, gbc_mPaymentType);
      mPaymentType.setColumns(10);
      
      JLabel lblPickupBranch_1 = new JLabel("Pickup");
      GridBagConstraints gbc_lblPickupBranch_1 = new GridBagConstraints();
      gbc_lblPickupBranch_1.anchor = GridBagConstraints.EAST;
      gbc_lblPickupBranch_1.insets = new Insets(0, 0, 5, 5);
      gbc_lblPickupBranch_1.gridx = 0;
      gbc_lblPickupBranch_1.gridy = 9;
      manageBookingsPanel.add(lblPickupBranch_1, gbc_lblPickupBranch_1);
      
      mPickupBranchComboBox = new BranchComboBox();
      mPickupBranchComboBox.populate();
      mPickupBranchComboBox.setSelectedIndex(-1);
      GridBagConstraints gbc_mPickupBranchComboBox = new GridBagConstraints();
      gbc_mPickupBranchComboBox.insets = new Insets(0, 0, 5, 5);
      gbc_mPickupBranchComboBox.fill = GridBagConstraints.HORIZONTAL;
      gbc_mPickupBranchComboBox.gridx = 1;
      gbc_mPickupBranchComboBox.gridy = 9;
      manageBookingsPanel.add(mPickupBranchComboBox, gbc_mPickupBranchComboBox);
      
      mPickupDatePicker = new DatePicker();
      GridBagConstraints gbc_mPickupDatePicker = new GridBagConstraints();
      gbc_mPickupDatePicker.insets = new Insets(0, 0, 5, 0);
      gbc_mPickupDatePicker.fill = GridBagConstraints.BOTH;
      gbc_mPickupDatePicker.gridx = 2;
      gbc_mPickupDatePicker.gridy = 9;
      manageBookingsPanel.add(mPickupDatePicker, gbc_mPickupDatePicker);
      
      JLabel lblDropffBranch = new JLabel("Dropoff");
      GridBagConstraints gbc_lblDropffBranch = new GridBagConstraints();
      gbc_lblDropffBranch.anchor = GridBagConstraints.EAST;
      gbc_lblDropffBranch.insets = new Insets(0, 0, 5, 5);
      gbc_lblDropffBranch.gridx = 0;
      gbc_lblDropffBranch.gridy = 10;
      manageBookingsPanel.add(lblDropffBranch, gbc_lblDropffBranch);
      
      mDropoffBranchComboBox = new BranchComboBox();
      mDropoffBranchComboBox.populate();
      mDropoffBranchComboBox.setSelectedIndex(-1);
      GridBagConstraints gbc_mDropoffBranchComboBox = new GridBagConstraints();
      gbc_mDropoffBranchComboBox.insets = new Insets(0, 0, 5, 5);
      gbc_mDropoffBranchComboBox.fill = GridBagConstraints.HORIZONTAL;
      gbc_mDropoffBranchComboBox.gridx = 1;
      gbc_mDropoffBranchComboBox.gridy = 10;
      manageBookingsPanel.add(mDropoffBranchComboBox, gbc_mDropoffBranchComboBox);
      
      mDropoffDatePicker = new DatePicker();
      GridBagConstraints gbc_mDropoffDatePicker = new GridBagConstraints();
      gbc_mDropoffDatePicker.insets = new Insets(0, 0, 5, 0);
      gbc_mDropoffDatePicker.fill = GridBagConstraints.BOTH;
      gbc_mDropoffDatePicker.gridx = 2;
      gbc_mDropoffDatePicker.gridy = 10;
      manageBookingsPanel.add(mDropoffDatePicker, gbc_mDropoffDatePicker);
      
      JButton btnSelectBooking = new JButton("Select Booking");
      btnSelectBooking.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            select.setVisible(true);
            if (select.get() != null) {
               booking = select.get();
               updateBookingFields();
            }
         }
      });
      GridBagConstraints gbc_btnSelectBooking = new GridBagConstraints();
      gbc_btnSelectBooking.insets = new Insets(0, 0, 0, 5);
      gbc_btnSelectBooking.gridx = 1;
      gbc_btnSelectBooking.gridy = 12;
      manageBookingsPanel.add(btnSelectBooking, gbc_btnSelectBooking);
      
      JButton btnUpdateBooking = new JButton("Update Booking");
      btnUpdateBooking.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            booking.odometerStart = ((int) mStartOdoSpinner.getValue());
            booking.odometerStart = ((int) mEndOdoSpinner.getValue());
            booking.tankStart = ((double) mStartTankSpinner.getValue());
            booking.tankEnd = ((double) mEndTankSpinner.getValue());
            booking.cost = Double.parseDouble(mCost.getText());
            booking.paymentType = mPaymentType.getText();
            booking.pickupBranch = mPickupBranchComboBox.get();
            booking.pickupDate = Date.from(mPickupDatePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            booking.dropoffBranch = mDropoffBranchComboBox.get();
            booking.dropoffDate = Date.from(mDropoffDatePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            try {
               repo.UpdateBooking(booking);
            } catch (GenericJDBCException ex) {
               JOptionPane.showMessageDialog(null, "Vehicle has already been booked for that time slot. Sorry!",
                     "Double Booking Detected", JOptionPane.ERROR_MESSAGE);
               return;
            }
            updateBookingFields();
            JOptionPane.showMessageDialog(null, "Successfully updated booking!");
         }
      });
      GridBagConstraints gbc_btnUpdateBooking = new GridBagConstraints();
      gbc_btnUpdateBooking.gridx = 2;
      gbc_btnUpdateBooking.gridy = 12;
      manageBookingsPanel.add(btnUpdateBooking, gbc_btnUpdateBooking);
      
      JPanel createBookingPanel = new JPanel();
      createBookingPanel.setToolTipText("");
      tabbedPane.addTab("Create Booking", null, createBookingPanel, null);
      GridBagLayout gbl_createBookingPanel = new GridBagLayout();
      gbl_createBookingPanel.columnWidths = new int[]{0, 244, 85, 31, 0, 0, 0};
      gbl_createBookingPanel.rowHeights = new int[]{20, 0, 17, 0, 0, 0, 0, 18, 0, 0};
      gbl_createBookingPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
      gbl_createBookingPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      createBookingPanel.setLayout(gbl_createBookingPanel);
      
      JLabel lblVehicleLicense = new JLabel("Vehicle");
      GridBagConstraints gbc_lblVehicleLicense = new GridBagConstraints();
      gbc_lblVehicleLicense.insets = new Insets(0, 0, 5, 5);
      gbc_lblVehicleLicense.anchor = GridBagConstraints.EAST;
      gbc_lblVehicleLicense.gridx = 0;
      gbc_lblVehicleLicense.gridy = 1;
      createBookingPanel.add(lblVehicleLicense, gbc_lblVehicleLicense);
      
      vehiclePicker = new VehiclePicker();
      GridBagConstraints gbc_vehiclePicker = new GridBagConstraints();
      gbc_vehiclePicker.insets = new Insets(0, 0, 5, 5);
      gbc_vehiclePicker.fill = GridBagConstraints.BOTH;
      gbc_vehiclePicker.gridx = 1;
      gbc_vehiclePicker.gridy = 1;
      createBookingPanel.add(vehiclePicker, gbc_vehiclePicker);
      
      JLabel lblCost = new JLabel("Cost");
      GridBagConstraints gbc_lblCost = new GridBagConstraints();
      gbc_lblCost.anchor = GridBagConstraints.EAST;
      gbc_lblCost.insets = new Insets(0, 0, 5, 5);
      gbc_lblCost.gridx = 2;
      gbc_lblCost.gridy = 1;
      createBookingPanel.add(lblCost, gbc_lblCost);
      
      txtCost = new JTextField();
      GridBagConstraints gbc_txtCost = new GridBagConstraints();
      gbc_txtCost.insets = new Insets(0, 0, 5, 5);
      gbc_txtCost.fill = GridBagConstraints.HORIZONTAL;
      gbc_txtCost.gridx = 3;
      gbc_txtCost.gridy = 1;
      createBookingPanel.add(txtCost, gbc_txtCost);
      txtCost.setColumns(10);
      
      JButton button = new JButton("...");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (vehiclePicker.getVehicle() == null) {
               JOptionPane.showMessageDialog(null, "Please select a vehicle first...");
               return;
            }
            if (!validateDates())
               return;
            long days = java.time.temporal.ChronoUnit.DAYS.between(pickupDate.getDate(), dropoffDate.getDate()) + 1;
            double cost = vehiclePicker.getVehicle().type.rate * days;
            txtCost.setText("" + cost);
         }
      });
      button.setToolTipText("Calculate cost.");
      button.setPreferredSize(new Dimension(26, 20));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 4;
      gbc_button.gridy = 1;
      createBookingPanel.add(button, gbc_button);
      
      JLabel lblClientLicenseNumber = new JLabel("Client");
      GridBagConstraints gbc_lblClientLicenseNumber = new GridBagConstraints();
      gbc_lblClientLicenseNumber.anchor = GridBagConstraints.EAST;
      gbc_lblClientLicenseNumber.insets = new Insets(0, 0, 5, 5);
      gbc_lblClientLicenseNumber.gridx = 0;
      gbc_lblClientLicenseNumber.gridy = 2;
      createBookingPanel.add(lblClientLicenseNumber, gbc_lblClientLicenseNumber);
      
      clientPicker = new ClientPicker();
      clientPicker.setAlignmentY(0.0f);
      clientPicker.setAlignmentX(0.0f);
      GridBagConstraints gbc_clientPicker = new GridBagConstraints();
      gbc_clientPicker.insets = new Insets(0, 0, 5, 5);
      gbc_clientPicker.anchor = GridBagConstraints.NORTH;
      gbc_clientPicker.fill = GridBagConstraints.HORIZONTAL;
      gbc_clientPicker.gridx = 1;
      gbc_clientPicker.gridy = 2;
      createBookingPanel.add(clientPicker, gbc_clientPicker);
      
      JLabel lblPaymentType = new JLabel("Payment Type");
      GridBagConstraints gbc_lblPaymentType = new GridBagConstraints();
      gbc_lblPaymentType.anchor = GridBagConstraints.EAST;
      gbc_lblPaymentType.insets = new Insets(0, 0, 5, 5);
      gbc_lblPaymentType.gridx = 2;
      gbc_lblPaymentType.gridy = 2;
      createBookingPanel.add(lblPaymentType, gbc_lblPaymentType);
      
      paymentTypeComboBox = new JComboBox<String>();
      paymentTypeComboBox.addItem("CASH");
      paymentTypeComboBox.addItem("DEBIT");
      paymentTypeComboBox.addItem("CREDIT");
      paymentTypeComboBox.addItem("BITCOIN");
      GridBagConstraints gbc_paymentTypeComboBox = new GridBagConstraints();
      gbc_paymentTypeComboBox.gridwidth = 2;
      gbc_paymentTypeComboBox.insets = new Insets(0, 0, 5, 5);
      gbc_paymentTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
      gbc_paymentTypeComboBox.gridx = 3;
      gbc_paymentTypeComboBox.gridy = 2;
      createBookingPanel.add(paymentTypeComboBox, gbc_paymentTypeComboBox);
      
      JLabel lblStartingOdometer = new JLabel("Starting Odometer");
      GridBagConstraints gbc_lblStartingOdometer = new GridBagConstraints();
      gbc_lblStartingOdometer.anchor = GridBagConstraints.EAST;
      gbc_lblStartingOdometer.insets = new Insets(0, 0, 5, 5);
      gbc_lblStartingOdometer.gridx = 0;
      gbc_lblStartingOdometer.gridy = 3;
      createBookingPanel.add(lblStartingOdometer, gbc_lblStartingOdometer);
      
      JPanel panel = new JPanel();
      GridBagConstraints gbc_panel = new GridBagConstraints();
      gbc_panel.insets = new Insets(0, 0, 5, 5);
      gbc_panel.fill = GridBagConstraints.BOTH;
      gbc_panel.gridx = 1;
      gbc_panel.gridy = 3;
      createBookingPanel.add(panel, gbc_panel);
      GridBagLayout gbl_panel = new GridBagLayout();
      gbl_panel.columnWidths = new int[]{29, 19, 0};
      gbl_panel.rowHeights = new int[]{23, 0};
      gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
      gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
      panel.setLayout(gbl_panel);
      
      odometerSpinner = new JSpinner(new SpinnerNumberModel(-1,-1,999999,100));
      GridBagConstraints gbc_StartOdoSpinner = new GridBagConstraints();
      gbc_StartOdoSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_StartOdoSpinner.insets = new Insets(0, 0, 0, 5);
      gbc_StartOdoSpinner.gridx = 0;
      gbc_StartOdoSpinner.gridy = 0;
      panel.add(odometerSpinner, gbc_StartOdoSpinner);
      
      JButton odometerFromVehicleButton = new JButton("...");
      odometerFromVehicleButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (vehiclePicker.getVehicle() != null)
               odometerSpinner.setValue(vehiclePicker.getVehicle().odometer);
            else 
               JOptionPane.showMessageDialog(null, "No vehicle selected...");
         }
      });
      odometerFromVehicleButton.setToolTipText("Get current reading from selected vehicle.");
      odometerFromVehicleButton.setPreferredSize(new Dimension(26, 20));
      GridBagConstraints gbc_odometerFromVehicleButton = new GridBagConstraints();
      gbc_odometerFromVehicleButton.anchor = GridBagConstraints.NORTHWEST;
      gbc_odometerFromVehicleButton.gridx = 1;
      gbc_odometerFromVehicleButton.gridy = 0;
      panel.add(odometerFromVehicleButton, gbc_odometerFromVehicleButton);
      
      JLabel lblStartingTank = new JLabel("Starting Tank");
      GridBagConstraints gbc_lblStartingTank = new GridBagConstraints();
      gbc_lblStartingTank.anchor = GridBagConstraints.EAST;
      gbc_lblStartingTank.insets = new Insets(0, 0, 5, 5);
      gbc_lblStartingTank.gridx = 0;
      gbc_lblStartingTank.gridy = 4;
      createBookingPanel.add(lblStartingTank, gbc_lblStartingTank);
      
      tankSpinner = new JSpinner(new SpinnerNumberModel(-1.0, -1.0, 32.0, 0.1));
      GridBagConstraints gbc_EndTankSpinner = new GridBagConstraints();
      gbc_EndTankSpinner.fill = GridBagConstraints.HORIZONTAL;
      gbc_EndTankSpinner.insets = new Insets(0, 0, 5, 5);
      gbc_EndTankSpinner.gridx = 1;
      gbc_EndTankSpinner.gridy = 4;
      createBookingPanel.add(tankSpinner, gbc_EndTankSpinner);
      
      JLabel lblPickupDate = new JLabel("Pickup Date");
      GridBagConstraints gbc_lblPickupDate = new GridBagConstraints();
      gbc_lblPickupDate.anchor = GridBagConstraints.EAST;
      gbc_lblPickupDate.insets = new Insets(0, 0, 5, 5);
      gbc_lblPickupDate.gridx = 0;
      gbc_lblPickupDate.gridy = 5;
      createBookingPanel.add(lblPickupDate, gbc_lblPickupDate);
      
      pickupDate = new DatePicker();
      GridBagConstraints gbc_pickupDate = new GridBagConstraints();
      gbc_pickupDate.fill = GridBagConstraints.HORIZONTAL;
      gbc_pickupDate.insets = new Insets(0, 0, 5, 5);
      gbc_pickupDate.gridx = 1;
      gbc_pickupDate.gridy = 5;
      createBookingPanel.add(pickupDate, gbc_pickupDate);
      
      JLabel lblPickupBranch = new JLabel("Pickup Branch");
      GridBagConstraints gbc_lblPickupBranch = new GridBagConstraints();
      gbc_lblPickupBranch.anchor = GridBagConstraints.EAST;
      gbc_lblPickupBranch.insets = new Insets(0, 0, 5, 5);
      gbc_lblPickupBranch.gridx = 2;
      gbc_lblPickupBranch.gridy = 5;
      createBookingPanel.add(lblPickupBranch, gbc_lblPickupBranch);
      
      pickupBranchComboBox = new BranchComboBox();
      pickupBranchComboBox.populate();
      pickupBranchComboBox.setSelectedIndex(-1);
      
            GridBagConstraints gbc_pickupBranchComboBox = new GridBagConstraints();
            gbc_pickupBranchComboBox.gridwidth = 2;
            gbc_pickupBranchComboBox.insets = new Insets(0, 0, 5, 5);
            gbc_pickupBranchComboBox.fill = GridBagConstraints.HORIZONTAL;
            gbc_pickupBranchComboBox.gridx = 3;
            gbc_pickupBranchComboBox.gridy = 5;
            createBookingPanel.add(pickupBranchComboBox, gbc_pickupBranchComboBox);
            
            JLabel lblDropoffDate = new JLabel("Dropoff Date");
            GridBagConstraints gbc_lblDropoffDate = new GridBagConstraints();
            gbc_lblDropoffDate.anchor = GridBagConstraints.EAST;
            gbc_lblDropoffDate.insets = new Insets(0, 0, 5, 5);
            gbc_lblDropoffDate.gridx = 0;
            gbc_lblDropoffDate.gridy = 6;
            createBookingPanel.add(lblDropoffDate, gbc_lblDropoffDate);
            dropoffDate = new DatePicker();
            GridBagConstraints gbc_dropoffDate = new GridBagConstraints();
            gbc_dropoffDate.fill = GridBagConstraints.HORIZONTAL;
            gbc_dropoffDate.insets = new Insets(0, 0, 5, 5);
            gbc_dropoffDate.gridx = 1;
            gbc_dropoffDate.gridy = 6;
            createBookingPanel.add(dropoffDate, gbc_dropoffDate);
            
            JLabel lblDropoffBranch = new JLabel("Dropoff Branch");
            GridBagConstraints gbc_lblDropoffBranch = new GridBagConstraints();
            gbc_lblDropoffBranch.anchor = GridBagConstraints.EAST;
            gbc_lblDropoffBranch.insets = new Insets(0, 0, 5, 5);
            gbc_lblDropoffBranch.gridx = 2;
            gbc_lblDropoffBranch.gridy = 6;
            createBookingPanel.add(lblDropoffBranch, gbc_lblDropoffBranch);
            
            JButton btnCreateBooking = new JButton("Create booking!");
            btnCreateBooking.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  if (!validateDates())
                     return;
                  Booking b  = createBookingFromFields();
                  try {
                     repo.CreateBooking(b);
                  } catch (GenericJDBCException ex) {
                     JOptionPane.showMessageDialog(null, "Vehicle has already been booked for that time slot. Sorry!",
                           "Double Booking Detected", JOptionPane.ERROR_MESSAGE);
                     return;
                  }
                  booking = b;
                  updateBookingFields();
                  tabbedPane.setSelectedIndex(0);
               }
            });
            
            dropoffBranchComboBox = new BranchComboBox();
            dropoffBranchComboBox.populate();
            dropoffBranchComboBox.setSelectedIndex(-1);
            
            GridBagConstraints gbc_dropoffBranchComboBox = new GridBagConstraints();
            gbc_dropoffBranchComboBox.gridwidth = 2;
            gbc_dropoffBranchComboBox.insets = new Insets(0, 0, 5, 5);
            gbc_dropoffBranchComboBox.fill = GridBagConstraints.HORIZONTAL;
            gbc_dropoffBranchComboBox.gridx = 3;
            gbc_dropoffBranchComboBox.gridy = 6;
            createBookingPanel.add(dropoffBranchComboBox, gbc_dropoffBranchComboBox);
            GridBagConstraints gbc_btnCreateBooking = new GridBagConstraints();
            gbc_btnCreateBooking.insets = new Insets(0, 0, 0, 5);
            gbc_btnCreateBooking.gridx = 1;
            gbc_btnCreateBooking.gridy = 8;
            createBookingPanel.add(btnCreateBooking, gbc_btnCreateBooking);
   }
   
   private void updateBookingFields() {
      mBookingId.setText("" + booking.id);
      mVehiclePicker.setVehicle(booking.vehicle);
      mClientPicker.setClient(booking.client);
      if (booking.odometerStart != null)
         mStartOdoSpinner.setValue(booking.odometerStart);
      if (booking.odometerStart != null)
         mEndOdoSpinner.setValue(booking.odometerEnd);
      if (booking.tankStart != null)
         mStartTankSpinner.setValue(booking.tankStart);
      if (booking.tankEnd != null)
         mEndTankSpinner.setValue(booking.tankEnd);
      mCost.setText("" + booking.cost);
      mPaymentType.setText(booking.paymentType);
      for (int i = 0; i < mPickupBranchComboBox.getItemCount(); i++)
         if (mPickupBranchComboBox.getItemAt(i).id == booking.pickupBranch.id)
            mPickupBranchComboBox.setSelectedIndex(i);
      for (int i = 0; i < mDropoffBranchComboBox.getItemCount(); i++)
         if (mDropoffBranchComboBox.getItemAt(i).id == booking.dropoffBranch.id)
            mDropoffBranchComboBox.setSelectedIndex(i);
      mPickupDatePicker.setDate(Instant.ofEpochMilli(booking.pickupDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
      mDropoffDatePicker.setDate(Instant.ofEpochMilli(booking.dropoffDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
   }
   
   private Booking createBookingFromFields() {
      Booking b = new Booking();
      b.vehicle = vehiclePicker.getVehicle();
      b.pickupBranch = pickupBranchComboBox.get();
      b.dropoffBranch = dropoffBranchComboBox.get();
      b.client = clientPicker.getClient();
      b.cost = Double.parseDouble(txtCost.getText());
      b.paymentType = (String) paymentTypeComboBox.getSelectedItem();
      b.cost = Double.parseDouble(txtCost.getText());
      if ((int) odometerSpinner.getValue() < 0)
         b.odometerStart = ((int) odometerSpinner.getValue());
      else 
         b.odometerStart = null;
      if ((double) tankSpinner.getValue() < 0)
         b.tankStart = ((double) tankSpinner.getValue());
      else
         b.tankStart = null;
      b.pickupDate = Date.from(pickupDate.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
      b.dropoffDate = Date.from(dropoffDate.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
      
      return b;
   }
   
   private boolean validateDates() {
      if (pickupDate.getDate() == null || dropoffDate.getDate() == null) {
         JOptionPane.showMessageDialog(null, "Please select a pickup and dropoff date first...");
         return false;
      }
      if (java.time.temporal.ChronoUnit.DAYS.between(pickupDate.getDate(), dropoffDate.getDate()) <= 0) {
         JOptionPane.showMessageDialog(null, "Dropoff Date must be after pickup date...");
         return false;
      }
      return true;
   }
}
