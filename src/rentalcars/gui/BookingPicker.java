package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import rentalcars.model.Booking;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BookingPicker extends JPanel {
   private JTextField textField;
   private Booking booking;
   private BookingSelectDialog bookingSelectDialog;

   public BookingPicker() {
      
      bookingSelectDialog = new BookingSelectDialog();
      bookingSelectDialog.setModal(true);
      
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{285, 0, 0};
      gridBagLayout.rowHeights = new int[]{20, 0};
      gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
      setLayout(gridBagLayout);
      
      textField = new JTextField();
      GridBagConstraints gbc_textField = new GridBagConstraints();
      gbc_textField.insets = new Insets(0, 0, 0, 5);
      gbc_textField.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField.gridx = 0;
      gbc_textField.gridy = 0;
      add(textField, gbc_textField);
      textField.setColumns(10);
      
      JButton button = new JButton("...");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            bookingSelectDialog.setVisible(true);
            if (bookingSelectDialog.get() != null) {
               booking = bookingSelectDialog.get();
               textField.setText(booking.toString());
            }
         }
      });
      button.setPreferredSize(new Dimension(26, 20));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.gridx = 1;
      gbc_button.gridy = 0;
      add(button, gbc_button);

   }

   public Booking get() {
      return booking;
   }
   
   public void set(Booking b) {
      booking = b;
      textField.setText(b.toString());
   }
}
