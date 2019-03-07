package rentalcars.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.CardLayout;
import java.awt.Dimension;

public class MainGUI {

   private JFrame frmCarRentalsCss;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               MainGUI window = new MainGUI();
               window.frmCarRentalsCss.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public MainGUI() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frmCarRentalsCss = new JFrame();
      frmCarRentalsCss.setTitle("Car Rentals CSS475");
      frmCarRentalsCss.setBounds(100, 100, 600, 560);
      frmCarRentalsCss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frmCarRentalsCss.setMinimumSize(new Dimension(600, 560));
      frmCarRentalsCss.getContentPane().setLayout(new CardLayout(0, 0));
      
      // Create SubPanelContainer
      SubPanelContainer subPanelContainer = new SubPanelContainer(frmCarRentalsCss.getContentPane());

      // Create WelcomePanel
      WelcomePanel welcomePanel = new WelcomePanel(subPanelContainer);
      
      // Add them to the 
      frmCarRentalsCss.getContentPane().add(welcomePanel, "WelcomePanel");
      frmCarRentalsCss.getContentPane().add(subPanelContainer, "SubPanelContainer");
      
      // Add sub panels to the subPanelContainer
      subPanelContainer.addSubPanel(new ManageVehiclesPanel(), "ManageVehiclesPanel");
      subPanelContainer.addSubPanel(new ManageBookingsPanel(), "ManageBookingsPanel");
      subPanelContainer.addSubPanel(new ManageClientsPanel(), "ManageClientsPanel");
      subPanelContainer.addSubPanel(new ManageRatesPanel(), "ManageRatesPanel");
      subPanelContainer.addSubPanel(new AboutPanel(), "AboutCarRental");
      subPanelContainer.addSubPanel(new EditSettingsPanel(), "EditSettingsPanel");
   }
}