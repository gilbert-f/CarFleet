package rentalcars.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;

public class SubPanelContainer extends JPanel {
   
   private static final long serialVersionUID = 1L;
   
   private Container parentContainer;
   private CardLayout parentCardLayout;
   private JPanel subPanelContainerPanel;
   private CardLayout layout;
   
   public SubPanelContainer(Container parentContainer) {
      this();
      this.parentContainer = parentContainer;
      this.parentCardLayout = (CardLayout) parentContainer.getLayout();
   }

   /**
    * Create the panel.
    */
   public SubPanelContainer() {
      setLayout(new BorderLayout(0, 0));
           
      subPanelContainerPanel = new JPanel();
      add(subPanelContainerPanel, BorderLayout.CENTER);
      subPanelContainerPanel.setLayout(new CardLayout(0, 0));
      layout = (CardLayout) subPanelContainerPanel.getLayout();
      
      Box verticalBox = Box.createVerticalBox();
      add(verticalBox, BorderLayout.SOUTH);
      
      Box horizontalBox = Box.createHorizontalBox();
      verticalBox.add(horizontalBox);
      
      Component horizontalStrut = Box.createHorizontalStrut(20);
      horizontalBox.add(horizontalStrut);
      
      ImageIcon welcomePageImageIcon = new ImageIcon(getClass().getResource("/icons/hatchback.png"));
      Image originalWelcomePageImage = welcomePageImageIcon.getImage();
      Image resizedWelcomePageImage = originalWelcomePageImage.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
      welcomePageImageIcon = new ImageIcon(resizedWelcomePageImage);
      JButton btnGoToHomePage = new JButton(welcomePageImageIcon);
      btnGoToHomePage.setPreferredSize(new Dimension(80, 48));
      btnGoToHomePage.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            parentCardLayout.show(parentContainer, "WelcomePanel");
         }
      });
      horizontalBox.add(btnGoToHomePage);
      
      JLabel lblGoToHomePage = new JLabel(" Go back to Home Page");
      lblGoToHomePage.setFont(new Font("Tahoma", Font.PLAIN, 14));
      horizontalBox.add(lblGoToHomePage);
      
      Component horizontalGlue = Box.createHorizontalGlue();
      horizontalBox.add(horizontalGlue);
      
      Component verticalStrut = Box.createVerticalStrut(10);
      verticalBox.add(verticalStrut);
   }
   
   public void addSubPanel(JPanel panel, String name) {
      subPanelContainerPanel.add(panel, name);
   }

   public void showSubPanel(String name) {
      layout.show(subPanelContainerPanel, name);
      parentCardLayout.show(parentContainer, "SubPanelContainer");
   }
}
