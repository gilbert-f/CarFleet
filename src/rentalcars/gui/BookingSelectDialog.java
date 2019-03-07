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

import rentalcars.model.Booking;
import rentalcars.repo.BookingRepository;
import rentalcars.repo.interfaces.IBookingRepository;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import com.github.lgooddatepicker.components.DatePicker;

@SuppressWarnings("serial")
public class BookingSelectDialog extends JDialog {

   private final JPanel contentPanel = new JPanel();

   private Booking booking = null;
   private JList<Booking> resultsList;
   
   private IBookingRepository repo;
   private JButton searchButton;
   private JButton okButton;
   private JButton cancelButton;
   private JLabel lblFindAndSelect;
   private JLabel lblLicense;
   private JLabel lblVehicle;
   private JLabel lblResults;
   private JScrollPane scrollPane;
   private JPanel buttonPane;
   private JLabel lblPickupDate;
   private JLabel lblDropoff;
   private BranchComboBox pickupBranchCombo;
   private BranchComboBox dropoffBranchCombo;
   private DatePicker pickupDatePicker;
   private DatePicker dropoffDatePicker;
   private VehiclePicker vehiclePicker;
   private ClientPicker clientPicker;

   public BookingSelectDialog() {
      
      repo = new BookingRepository();
      
      setMinimumSize(new Dimension(600, 485));
      setBounds(100, 100, 412, 328);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      GridBagLayout gbl_contentPanel = new GridBagLayout();
      gbl_contentPanel.columnWidths = new int[]{0, 92, 164, 173, 0, 0};
      gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
      gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
      contentPanel.setLayout(gbl_contentPanel);
      {
         lblFindAndSelect = new JLabel("Find and Select a Booking");
         lblFindAndSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));
         GridBagConstraints gbc_lblFindAndSelect = new GridBagConstraints();
         gbc_lblFindAndSelect.anchor = GridBagConstraints.WEST;
         gbc_lblFindAndSelect.gridwidth = 2;
         gbc_lblFindAndSelect.insets = new Insets(0, 0, 5, 5);
         gbc_lblFindAndSelect.gridx = 1;
         gbc_lblFindAndSelect.gridy = 0;
         contentPanel.add(lblFindAndSelect, gbc_lblFindAndSelect);
      }
      {
         lblLicense = new JLabel("Client");
         GridBagConstraints gbc_lblLicense = new GridBagConstraints();
         gbc_lblLicense.anchor = GridBagConstraints.EAST;
         gbc_lblLicense.insets = new Insets(0, 0, 5, 5);
         gbc_lblLicense.gridx = 1;
         gbc_lblLicense.gridy = 1;
         contentPanel.add(lblLicense, gbc_lblLicense);
      }
      {
         clientPicker = new ClientPicker();
         GridBagConstraints gbc_clientPicker = new GridBagConstraints();
         gbc_clientPicker.gridwidth = 2;
         gbc_clientPicker.insets = new Insets(0, 0, 5, 5);
         gbc_clientPicker.fill = GridBagConstraints.BOTH;
         gbc_clientPicker.gridx = 2;
         gbc_clientPicker.gridy = 1;
         contentPanel.add(clientPicker, gbc_clientPicker);
      }
      {
         lblVehicle = new JLabel("Vehicle");
         GridBagConstraints gbc_lblVehicle = new GridBagConstraints();
         gbc_lblVehicle.anchor = GridBagConstraints.EAST;
         gbc_lblVehicle.insets = new Insets(0, 0, 5, 5);
         gbc_lblVehicle.gridx = 1;
         gbc_lblVehicle.gridy = 2;
         contentPanel.add(lblVehicle, gbc_lblVehicle);
      }
      {
         searchButton = new JButton("Search");
         searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Booking query = new Booking();
               query.client = clientPicker.getClient();
               query.vehicle = vehiclePicker.getVehicle();
               query.pickupBranch = pickupBranchCombo.get();
               if (pickupDatePicker.getDate() != null)
                  query.pickupDate = Date.from(pickupDatePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
               query.dropoffBranch = dropoffBranchCombo.get();
               if (dropoffDatePicker.getDate() != null)
                  query.dropoffDate = Date.from(dropoffDatePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
               List<Booking> results = repo.SearchBookings(query);
               if (results != null) {
                  DefaultListModel<Booking> model = new DefaultListModel<Booking>();
                  for (Booking result : results) {
                     model.addElement(result);
                  }
                  resultsList.setModel(model);
               }
            }
         });
         {
            vehiclePicker = new VehiclePicker();
            GridBagConstraints gbc_vehiclePicker = new GridBagConstraints();
            gbc_vehiclePicker.gridwidth = 2;
            gbc_vehiclePicker.insets = new Insets(0, 0, 5, 5);
            gbc_vehiclePicker.fill = GridBagConstraints.BOTH;
            gbc_vehiclePicker.gridx = 2;
            gbc_vehiclePicker.gridy = 2;
            contentPanel.add(vehiclePicker, gbc_vehiclePicker);
         }
         {
            lblPickupDate = new JLabel("Pickup");
            GridBagConstraints gbc_lblPickupDate = new GridBagConstraints();
            gbc_lblPickupDate.anchor = GridBagConstraints.EAST;
            gbc_lblPickupDate.insets = new Insets(0, 0, 5, 5);
            gbc_lblPickupDate.gridx = 1;
            gbc_lblPickupDate.gridy = 3;
            contentPanel.add(lblPickupDate, gbc_lblPickupDate);
         }
         {
            pickupBranchCombo = new BranchComboBox();
            pickupBranchCombo.populate();
            pickupBranchCombo.setSelectedIndex(-1);
            GridBagConstraints gbc_pickupBranchCombo = new GridBagConstraints();
            gbc_pickupBranchCombo.insets = new Insets(0, 0, 5, 5);
            gbc_pickupBranchCombo.fill = GridBagConstraints.HORIZONTAL;
            gbc_pickupBranchCombo.gridx = 2;
            gbc_pickupBranchCombo.gridy = 3;
            contentPanel.add(pickupBranchCombo, gbc_pickupBranchCombo);
         }
         {
            pickupDatePicker = new DatePicker();
            GridBagConstraints gbc_pickupDatePicker = new GridBagConstraints();
            gbc_pickupDatePicker.insets = new Insets(0, 0, 5, 5);
            gbc_pickupDatePicker.fill = GridBagConstraints.BOTH;
            gbc_pickupDatePicker.gridx = 3;
            gbc_pickupDatePicker.gridy = 3;
            contentPanel.add(pickupDatePicker, gbc_pickupDatePicker);
         }
         {
            lblDropoff = new JLabel("Dropoff");
            GridBagConstraints gbc_lblDropoff = new GridBagConstraints();
            gbc_lblDropoff.anchor = GridBagConstraints.EAST;
            gbc_lblDropoff.insets = new Insets(0, 0, 5, 5);
            gbc_lblDropoff.gridx = 1;
            gbc_lblDropoff.gridy = 4;
            contentPanel.add(lblDropoff, gbc_lblDropoff);
         }
         {
            dropoffBranchCombo = new BranchComboBox();
            dropoffBranchCombo.populate();
            dropoffBranchCombo.setSelectedIndex(-1);
            GridBagConstraints gbc_dropoffBranchCombo = new GridBagConstraints();
            gbc_dropoffBranchCombo.insets = new Insets(0, 0, 5, 5);
            gbc_dropoffBranchCombo.fill = GridBagConstraints.HORIZONTAL;
            gbc_dropoffBranchCombo.gridx = 2;
            gbc_dropoffBranchCombo.gridy = 4;
            contentPanel.add(dropoffBranchCombo, gbc_dropoffBranchCombo);
         }
         {
            dropoffDatePicker = new DatePicker();
            GridBagConstraints gbc_dropoffDatePicker = new GridBagConstraints();
            gbc_dropoffDatePicker.insets = new Insets(0, 0, 5, 5);
            gbc_dropoffDatePicker.fill = GridBagConstraints.BOTH;
            gbc_dropoffDatePicker.gridx = 3;
            gbc_dropoffDatePicker.gridy = 4;
            contentPanel.add(dropoffDatePicker, gbc_dropoffDatePicker);
         }
         GridBagConstraints gbc_searchButton = new GridBagConstraints();
         gbc_searchButton.fill = GridBagConstraints.HORIZONTAL;
         gbc_searchButton.insets = new Insets(0, 0, 5, 5);
         gbc_searchButton.gridx = 1;
         gbc_searchButton.gridy = 6;
         contentPanel.add(searchButton, gbc_searchButton);
      }
      {
         lblResults = new JLabel("Results");
         lblResults.setFont(new Font("Tahoma", Font.PLAIN, 16));
         GridBagConstraints gbc_lblResults = new GridBagConstraints();
         gbc_lblResults.anchor = GridBagConstraints.WEST;
         gbc_lblResults.gridwidth = 2;
         gbc_lblResults.insets = new Insets(0, 0, 5, 5);
         gbc_lblResults.gridx = 1;
         gbc_lblResults.gridy = 7;
         contentPanel.add(lblResults, gbc_lblResults);
      }
      {
         scrollPane = new JScrollPane();
         GridBagConstraints gbc_scrollPane = new GridBagConstraints();
         gbc_scrollPane.gridwidth = 3;
         gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
         gbc_scrollPane.fill = GridBagConstraints.BOTH;
         gbc_scrollPane.gridx = 1;
         gbc_scrollPane.gridy = 8;
         contentPanel.add(scrollPane, gbc_scrollPane);
         resultsList = new JList<Booking>();
         resultsList.setFont(new Font("Courier New", resultsList.getFont().getStyle(), resultsList.getFont().getSize()));
         resultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         resultsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
               booking = (Booking) resultsList.getSelectedValue();
            }
         });
         GridBagConstraints gbc_resultsList = new GridBagConstraints();
         gbc_resultsList.gridwidth = 2;
         gbc_resultsList.insets = new Insets(0, 0, 0, 5);
         gbc_resultsList.fill = GridBagConstraints.BOTH;
         gbc_resultsList.gridx = 1;
         gbc_resultsList.gridy = 7;
         //contentPanel.add(resultsList, gbc_resultsList);
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
                  booking = null;
                  dispose();
               }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
         }
      }
      setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{searchButton, okButton, cancelButton}));
   }

   public Booking get() {
      return booking;
   }
}
