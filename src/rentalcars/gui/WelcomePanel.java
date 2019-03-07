package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePanel extends JPanel {

   private static final long serialVersionUID = 1L;
   
   private SubPanelContainer subPanelContainer;
   
   public WelcomePanel(SubPanelContainer subPanelContainer) {
      this();
      this.subPanelContainer = subPanelContainer;
   }

   public WelcomePanel() {
      setLayout(new BorderLayout(0, 0));
      
      Box horizontalBox = Box.createHorizontalBox();
      add(horizontalBox, BorderLayout.NORTH);
      
      Component horizontalStrut = Box.createHorizontalStrut(10);
      horizontalBox.add(horizontalStrut);
      
      JLabel label = new JLabel("Welcome");
      horizontalBox.add(label);
      label.setFont(new Font("Tahoma", Font.PLAIN, 32));
      
      Component horizontalGlue = Box.createHorizontalGlue();
      horizontalBox.add(horizontalGlue);

      ImageIcon hatchbackImageIcon = new ImageIcon(getClass().getResource("/icons/hatchback.png"));
      Image originalHatchbackImage = hatchbackImageIcon.getImage();
      Image resizedHatchbackImage = originalHatchbackImage.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
      hatchbackImageIcon = new ImageIcon(resizedHatchbackImage);
      JLabel hatchbackJLabel = new JLabel(hatchbackImageIcon);
      horizontalBox.add(hatchbackJLabel);
      
      Component horizontalStrut_1 = Box.createHorizontalStrut(10);
      horizontalBox.add(horizontalStrut_1);
      
      Component horizontalStrut_2 = Box.createHorizontalStrut(20);
      add(horizontalStrut_2, BorderLayout.WEST);
      
      Component horizontalStrut_3 = Box.createHorizontalStrut(36);
      add(horizontalStrut_3, BorderLayout.EAST);
      
      Box actionPanelsBox = Box.createVerticalBox();
      add(actionPanelsBox, BorderLayout.CENTER);
      
      Box aboutButton = Box.createHorizontalBox();
      actionPanelsBox.add(aboutButton);
      
      JLabel lblNewLabel = new JLabel("Please select an action from below:");
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
      aboutButton.add(lblNewLabel);
      lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
      
      Component horizontalGlue_2 = Box.createHorizontalGlue();
      aboutButton.add(horizontalGlue_2);
      
      Component verticalStrut = Box.createVerticalStrut(10);
      actionPanelsBox.add(verticalStrut);
      
      Box getVehicleByLicenseHorizontalBox = Box.createHorizontalBox();
      actionPanelsBox.add(getVehicleByLicenseHorizontalBox);
      
      ImageIcon licensePlateImageIcon = new ImageIcon(getClass().getResource("/icons/vehicles.png"));
      Image originalLicensePlateImage = licensePlateImageIcon.getImage();
      Image resizedLicensePlateImage = originalLicensePlateImage.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      licensePlateImageIcon = new ImageIcon(resizedLicensePlateImage);
      JButton btnGetVehicleByLicense = new JButton(licensePlateImageIcon);
      btnGetVehicleByLicense.setPreferredSize(new Dimension(80, 48));
      btnGetVehicleByLicense.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            subPanelContainer.showSubPanel("ManageVehiclesPanel");
         }
      });
      getVehicleByLicenseHorizontalBox.add(btnGetVehicleByLicense);
      
      JLabel lblGetVehicleByLicense = new JLabel(" Manage Vehicles...");
      lblGetVehicleByLicense.setFont(new Font("Tahoma", Font.PLAIN, 14));
      getVehicleByLicenseHorizontalBox.add(lblGetVehicleByLicense);
      
      Component horizontalGlue_1 = Box.createHorizontalGlue();
      getVehicleByLicenseHorizontalBox.add(horizontalGlue_1);
      
      Component verticalStrut_1 = Box.createVerticalStrut(10);
      actionPanelsBox.add(verticalStrut_1);
      
      Box createBookingBox = Box.createHorizontalBox();
      actionPanelsBox.add(createBookingBox);
      
      ImageIcon bookingImageIcon = new ImageIcon(getClass().getResource("/icons/booking.png"));
      Image originalBookingImage = bookingImageIcon.getImage();
      Image resizedBookingImage = originalBookingImage.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      bookingImageIcon = new ImageIcon(resizedBookingImage);      
      JButton btnCreateBooking = new JButton(bookingImageIcon);
      btnCreateBooking.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            subPanelContainer.showSubPanel("ManageBookingsPanel");
         }
      });
      
      btnCreateBooking.setPreferredSize(new Dimension(80, 48));
      createBookingBox.add(btnCreateBooking);
      
      JLabel lblCreateBooking = new JLabel(" Manage Bookings...");
      lblCreateBooking.setFont(new Font("Tahoma", Font.PLAIN, 14));
      createBookingBox.add(lblCreateBooking);
      
      Component horizontalGlue_3 = Box.createHorizontalGlue();
      createBookingBox.add(horizontalGlue_3);
      
      Component verticalStrutAboveACR = Box.createVerticalStrut(10);
      actionPanelsBox.add(verticalStrutAboveACR);  
      
      Box horizontalBox_1 = Box.createHorizontalBox();
      actionPanelsBox.add(horizontalBox_1);
      
      ImageIcon clientsImageIcon = new ImageIcon(getClass().getResource("/icons/client.png"));
      Image originalClientsImage = clientsImageIcon.getImage();
      Image resizedClientsImage = originalClientsImage.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      clientsImageIcon = new ImageIcon(resizedClientsImage);

      JButton button = new JButton(clientsImageIcon);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            subPanelContainer.showSubPanel("ManageClientsPanel");
         }
      });
      button.setPreferredSize(new Dimension(80, 48));
      horizontalBox_1.add(button);
      
      JLabel lblManageClients = new JLabel(" Manage Clients...");
      lblManageClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
      horizontalBox_1.add(lblManageClients);
      
      Component horizontalGlue_6 = Box.createHorizontalGlue();
      horizontalBox_1.add(horizontalGlue_6);
      
      Component verticalStrut_3 = Box.createVerticalStrut(10);
      actionPanelsBox.add(verticalStrut_3);
      
      Box horizontalBox_2 = Box.createHorizontalBox();
      actionPanelsBox.add(horizontalBox_2);
      
      ImageIcon ratesImageIcon = new ImageIcon(getClass().getResource("/icons/rate.png"));
      Image originalRatesImage = ratesImageIcon.getImage();
      Image resizedRatesImage = originalRatesImage.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      ratesImageIcon = new ImageIcon(resizedRatesImage);
      JButton button_1 = new JButton(ratesImageIcon);
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            subPanelContainer.showSubPanel("ManageRatesPanel");
         }
      });
      button_1.setPreferredSize(new Dimension(80, 48));
      horizontalBox_2.add(button_1);
      
      JLabel lblAdjustRates = new JLabel(" Adjust Rates...");
      lblAdjustRates.setFont(new Font("Tahoma", Font.PLAIN, 14));
      horizontalBox_2.add(lblAdjustRates);
      
      Component horizontalGlue_7 = Box.createHorizontalGlue();
      horizontalBox_2.add(horizontalGlue_7);
      
      Component verticalStrut_4 = Box.createVerticalStrut(10);
      actionPanelsBox.add(verticalStrut_4);
      
      Box aboutCarRentalBox = Box.createHorizontalBox();
      actionPanelsBox.add(aboutCarRentalBox);
      
      ImageIcon aboutImageIcon = new ImageIcon(getClass().getResource("/icons/about.png"));
      Image originalAboutImage = aboutImageIcon.getImage();
      Image resizedAboutImage = originalAboutImage.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      aboutImageIcon = new ImageIcon(resizedAboutImage);
      JButton btnAbout = new JButton(aboutImageIcon);
      btnAbout.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		subPanelContainer.showSubPanel("AboutCarRental");
      	}
      });
      
      btnAbout.setPreferredSize(new Dimension(80, 48));
      aboutCarRentalBox.add(btnAbout);
      
      
      
      JLabel lblAboutCarRental = new JLabel(" About Car Rental");
      lblAboutCarRental.setFont(new Font("Tahoma", Font.PLAIN, 14));
      aboutCarRentalBox.add(lblAboutCarRental);
      
      Component verticalStrutBelowACR = Box.createVerticalStrut(10);
      actionPanelsBox.add(verticalStrutBelowACR);
      
      Component horizontalGlue_5 = Box.createHorizontalGlue();
      aboutCarRentalBox.add(horizontalGlue_5);
      
      Component verticalGlue = Box.createVerticalGlue();
      actionPanelsBox.add(verticalGlue);
      
      Box editSettingsBox = Box.createHorizontalBox();
      actionPanelsBox.add(editSettingsBox);
      
      ImageIcon editSettingsImageIcon = new ImageIcon(getClass().getResource("/icons/gear.png"));
      Image originalEditSettingsImage = editSettingsImageIcon.getImage();
      Image resizedEditSettingsImage = originalEditSettingsImage.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      editSettingsImageIcon = new ImageIcon(resizedEditSettingsImage);
      JButton btnEditSettings = new JButton(editSettingsImageIcon);
      btnEditSettings.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            subPanelContainer.showSubPanel("EditSettingsPanel");
         }
      });
      btnEditSettings.setPreferredSize(new Dimension(80, 48));
      editSettingsBox.add(btnEditSettings);
      
      JLabel lblEditSettings = new JLabel(" Edit Settings");
      lblEditSettings.setFont(new Font("Tahoma", Font.PLAIN, 14));
      editSettingsBox.add(lblEditSettings);
      
      Component horizontalGlue_4 = Box.createHorizontalGlue();
      editSettingsBox.add(horizontalGlue_4);
      
      Component verticalStrut_2 = Box.createVerticalStrut(10);
      actionPanelsBox.add(verticalStrut_2);
   }
}
