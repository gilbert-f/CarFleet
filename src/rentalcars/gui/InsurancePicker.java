package rentalcars.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Dimension;
import rentalcars.model.Insurance;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InsurancePicker extends JPanel {
   private JTextField insuranceTxtField;
   private JButton insurancePickerButton;
   
   private Insurance insurance;
   
   public InsurancePicker() {
      setAlignmentY(0.0f);
      setAlignmentX(0.0f);
           
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{126, 0, 0};
      gridBagLayout.rowHeights = new int[]{30, 0};
      gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
      setLayout(gridBagLayout);
      
      insuranceTxtField = new JTextField();
      insuranceTxtField.setEditable(false);
      insuranceTxtField.setAlignmentY(0.0f);
      insuranceTxtField.setAlignmentX(0.0f);
      GridBagConstraints gbc_insuranceTxtField = new GridBagConstraints();
      gbc_insuranceTxtField.fill = GridBagConstraints.HORIZONTAL;
      gbc_insuranceTxtField.insets = new Insets(0, 0, 0, 5);
      gbc_insuranceTxtField.gridx = 0;
      gbc_insuranceTxtField.gridy = 0;
      add(insuranceTxtField, gbc_insuranceTxtField);
      insuranceTxtField.setColumns(10);
      
      insurancePickerButton = new JButton("...");
      insurancePickerButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            InsuranceSelectDialog dialog = new InsuranceSelectDialog();
            dialog.setModal(true);
            dialog.setVisible(true);
            Insurance i = dialog.getSelectedInsurance();
            if (i != null) {
               insurance = i;
               updateInsuranceTxt();
            }
         }
      });
      insurancePickerButton.setPreferredSize(new Dimension(26, 20));
      insurancePickerButton.setMinimumSize(new Dimension(26, 20));
      insurancePickerButton.setMaximumSize(new Dimension(26, 20));
      GridBagConstraints gbc_insurancePickerButton = new GridBagConstraints();
      gbc_insurancePickerButton.gridx = 1;
      gbc_insurancePickerButton.gridy = 0;
      add(insurancePickerButton, gbc_insurancePickerButton);

   }
   
   private void updateInsuranceTxt() {
      if (insurance != null) insuranceTxtField.setText(insurance.toString());
      else insuranceTxtField.setText("");
   }

   public void setInsurance(Insurance i) {
      insurance = i;
      updateInsuranceTxt();
   }
   
   public Insurance getInsurance() {
      return insurance;
   }
}
