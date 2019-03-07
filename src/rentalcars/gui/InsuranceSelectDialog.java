package rentalcars.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rentalcars.model.Insurance;
import rentalcars.repo.InsuranceRepository;
import rentalcars.repo.interfaces.IInsuranceRepository;

import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class InsuranceSelectDialog extends JDialog {

   private final JPanel contentPanel = new JPanel();

   private Insurance insurance = null;
   private JTextField typeTxt;
   private JList<Insurance> resultsList;
   
   private IInsuranceRepository repo;
   private JTextField insuranceNumberTxt;
   private JButton searchButton;
   private JButton okButton;
   private JButton cancelButton;
   private JLabel lblFindAndSelect;
   private JLabel lblLicense;
   private JLabel lblType;
   private JLabel lblBody;
   private JLabel lblCollision;
   private JLabel lblResults;
   private JScrollPane scrollPane;
   private JPanel buttonPane;
   private JSpinner bodySpinner;
   private JSpinner collisionSpinner;
   private JLabel lblMedical;
   private JLabel lblMedicla;
   private JSpinner medicalSpinner;
   private JSpinner rateSpinner;

   public InsuranceSelectDialog() {
      
      repo = new InsuranceRepository();
      
      setMinimumSize(new Dimension(600, 485));
      setBounds(100, 100, 412, 328);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      GridBagLayout gbl_contentPanel = new GridBagLayout();
      gbl_contentPanel.columnWidths = new int[]{0, 92, 0, 0, 0};
      gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
      gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
      contentPanel.setLayout(gbl_contentPanel);
      {
         lblFindAndSelect = new JLabel("Find and Select an Insurance");
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
         lblLicense = new JLabel("Insurance #");
         GridBagConstraints gbc_lblLicense = new GridBagConstraints();
         gbc_lblLicense.anchor = GridBagConstraints.EAST;
         gbc_lblLicense.insets = new Insets(0, 0, 5, 5);
         gbc_lblLicense.gridx = 1;
         gbc_lblLicense.gridy = 1;
         contentPanel.add(lblLicense, gbc_lblLicense);
      }
      {
         insuranceNumberTxt = new JTextField();
         GridBagConstraints gbc_insuranceNumberTxt = new GridBagConstraints();
         gbc_insuranceNumberTxt.insets = new Insets(0, 0, 5, 5);
         gbc_insuranceNumberTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_insuranceNumberTxt.gridx = 2;
         gbc_insuranceNumberTxt.gridy = 1;
         contentPanel.add(insuranceNumberTxt, gbc_insuranceNumberTxt);
         insuranceNumberTxt.setColumns(10);
      }
      {
         lblType = new JLabel("Type");
         GridBagConstraints gbc_lblType = new GridBagConstraints();
         gbc_lblType.anchor = GridBagConstraints.EAST;
         gbc_lblType.insets = new Insets(0, 0, 5, 5);
         gbc_lblType.gridx = 1;
         gbc_lblType.gridy = 2;
         contentPanel.add(lblType, gbc_lblType);
      }
      {
         typeTxt = new JTextField();
         typeTxt.setColumns(10);
         GridBagConstraints gbc_typeTxt = new GridBagConstraints();
         gbc_typeTxt.insets = new Insets(0, 0, 5, 5);
         gbc_typeTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_typeTxt.gridx = 2;
         gbc_typeTxt.gridy = 2;
         contentPanel.add(typeTxt, gbc_typeTxt);
      }
      {
         lblBody = new JLabel("Body");
         GridBagConstraints gbc_lblBody = new GridBagConstraints();
         gbc_lblBody.anchor = GridBagConstraints.EAST;
         gbc_lblBody.insets = new Insets(0, 0, 5, 5);
         gbc_lblBody.gridx = 1;
         gbc_lblBody.gridy = 3;
         contentPanel.add(lblBody, gbc_lblBody);
      }
      {
         bodySpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 999999.99, 1000.0));
         lblBody.setLabelFor(bodySpinner);
         GridBagConstraints gbc_bodySpinner = new GridBagConstraints();
         gbc_bodySpinner.fill = GridBagConstraints.HORIZONTAL;
         gbc_bodySpinner.insets = new Insets(0, 0, 5, 5);
         gbc_bodySpinner.gridx = 2;
         gbc_bodySpinner.gridy = 3;
         contentPanel.add(bodySpinner, gbc_bodySpinner);
      }
      {
         lblCollision = new JLabel("Collision");
         GridBagConstraints gbc_lblCollision = new GridBagConstraints();
         gbc_lblCollision.anchor = GridBagConstraints.EAST;
         gbc_lblCollision.insets = new Insets(0, 0, 5, 5);
         gbc_lblCollision.gridx = 1;
         gbc_lblCollision.gridy = 4;
         contentPanel.add(lblCollision, gbc_lblCollision);
      }
      {
         searchButton = new JButton("Search");
         searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.out.println("Searching for insurance...");
               Insurance i = new Insurance();
               i.id = insuranceNumberTxt.getText().trim();
               i.type = typeTxt.getText().trim();
               i.body = (double) bodySpinner.getValue();
               i.collision = (double) collisionSpinner.getValue();
               i.medical = (double) medicalSpinner.getValue();
               i.rate = (double) rateSpinner.getValue();
               List<Insurance> hits = repo.SearchInsurances(i);
               if (hits != null) {
                  lblResults.setText("Results (" + hits.size() + ")");
                  DefaultListModel<Insurance> model = new DefaultListModel<Insurance>();
                  for (Insurance insurance : hits)
                     model.addElement(insurance);
                  resultsList.setModel(model);
               }
            }
         });
         {
            collisionSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 999999.99, 1000.0));
            GridBagConstraints gbc_collisionSpinner = new GridBagConstraints();
            gbc_collisionSpinner.fill = GridBagConstraints.HORIZONTAL;
            gbc_collisionSpinner.insets = new Insets(0, 0, 5, 5);
            gbc_collisionSpinner.gridx = 2;
            gbc_collisionSpinner.gridy = 4;
            contentPanel.add(collisionSpinner, gbc_collisionSpinner);
         }
         {
            lblMedical = new JLabel("Medical");
            GridBagConstraints gbc_lblMedical = new GridBagConstraints();
            gbc_lblMedical.anchor = GridBagConstraints.EAST;
            gbc_lblMedical.insets = new Insets(0, 0, 5, 5);
            gbc_lblMedical.gridx = 1;
            gbc_lblMedical.gridy = 5;
            contentPanel.add(lblMedical, gbc_lblMedical);
         }
         {
            medicalSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 999999.99, 1000.0));
            GridBagConstraints gbc_medicalSpinner = new GridBagConstraints();
            gbc_medicalSpinner.fill = GridBagConstraints.HORIZONTAL;
            gbc_medicalSpinner.insets = new Insets(0, 0, 5, 5);
            gbc_medicalSpinner.gridx = 2;
            gbc_medicalSpinner.gridy = 5;
            contentPanel.add(medicalSpinner, gbc_medicalSpinner);
         }
         {
            lblMedicla = new JLabel("Rate");
            GridBagConstraints gbc_lblMedicla = new GridBagConstraints();
            gbc_lblMedicla.anchor = GridBagConstraints.EAST;
            gbc_lblMedicla.insets = new Insets(0, 0, 5, 5);
            gbc_lblMedicla.gridx = 1;
            gbc_lblMedicla.gridy = 6;
            contentPanel.add(lblMedicla, gbc_lblMedicla);
         }
         {
            rateSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 9999.99, 100.0));
            GridBagConstraints gbc_rateSpinner = new GridBagConstraints();
            gbc_rateSpinner.fill = GridBagConstraints.HORIZONTAL;
            gbc_rateSpinner.insets = new Insets(0, 0, 5, 5);
            gbc_rateSpinner.gridx = 2;
            gbc_rateSpinner.gridy = 6;
            contentPanel.add(rateSpinner, gbc_rateSpinner);
         }
         GridBagConstraints gbc_searchButton = new GridBagConstraints();
         gbc_searchButton.fill = GridBagConstraints.HORIZONTAL;
         gbc_searchButton.insets = new Insets(0, 0, 5, 5);
         gbc_searchButton.gridx = 1;
         gbc_searchButton.gridy = 7;
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
         resultsList = new JList<Insurance>();
         resultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         resultsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
               insurance = (Insurance) resultsList.getSelectedValue();
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
                  insurance = null;
                  dispose();
               }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
         }
      }
      setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{insuranceNumberTxt, typeTxt, searchButton, okButton, cancelButton}));
   }

   public Insurance getSelectedInsurance() {
      return insurance;
   }
}
