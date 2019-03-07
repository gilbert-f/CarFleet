package rentalcars.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rentalcars.model.Client;
import rentalcars.repo.ClientRepository;
import rentalcars.repo.interfaces.IClientRepository;
import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

@SuppressWarnings("serial")
public class ClientSelectDialog extends JDialog {

   private final JPanel contentPanel = new JPanel();

   private Client client = null;
   private JTextField firstNameTxt;
   private JTextField lastNameTxt;
   private JTextField emailTxt;
   private JList<Client> resultsList;
   
   private IClientRepository repo;
   private JTextField licenseNumberTxt;
   private JButton searchButton;
   private JButton okButton;
   private JButton cancelButton;
   private JLabel lblFindAndSelect;
   private JLabel lblLicense;
   private JLabel label_1;
   private JLabel label_2;
   private JLabel label_3;
   private JLabel lblResults;
   private JScrollPane scrollPane;
   private JPanel buttonPane;

   public ClientSelectDialog() {
      
      repo = new ClientRepository();
      
      setMinimumSize(new Dimension(600, 485));
      setBounds(100, 100, 412, 328);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      GridBagLayout gbl_contentPanel = new GridBagLayout();
      gbl_contentPanel.columnWidths = new int[]{0, 92, 0, 0, 0};
      gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
      gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
      contentPanel.setLayout(gbl_contentPanel);
      {
         lblFindAndSelect = new JLabel("Find and Select a Client");
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
         lblLicense = new JLabel("License #");
         GridBagConstraints gbc_lblLicense = new GridBagConstraints();
         gbc_lblLicense.anchor = GridBagConstraints.EAST;
         gbc_lblLicense.insets = new Insets(0, 0, 5, 5);
         gbc_lblLicense.gridx = 1;
         gbc_lblLicense.gridy = 1;
         contentPanel.add(lblLicense, gbc_lblLicense);
      }
      {
         licenseNumberTxt = new JTextField();
         GridBagConstraints gbc_licenseNumberTxt = new GridBagConstraints();
         gbc_licenseNumberTxt.insets = new Insets(0, 0, 5, 5);
         gbc_licenseNumberTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_licenseNumberTxt.gridx = 2;
         gbc_licenseNumberTxt.gridy = 1;
         contentPanel.add(licenseNumberTxt, gbc_licenseNumberTxt);
         licenseNumberTxt.setColumns(10);
      }
      {
         label_1 = new JLabel("First Name");
         GridBagConstraints gbc_label_1 = new GridBagConstraints();
         gbc_label_1.anchor = GridBagConstraints.EAST;
         gbc_label_1.insets = new Insets(0, 0, 5, 5);
         gbc_label_1.gridx = 1;
         gbc_label_1.gridy = 2;
         contentPanel.add(label_1, gbc_label_1);
      }
      {
         firstNameTxt = new JTextField();
         firstNameTxt.setColumns(10);
         GridBagConstraints gbc_firstNameTxt = new GridBagConstraints();
         gbc_firstNameTxt.insets = new Insets(0, 0, 5, 5);
         gbc_firstNameTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_firstNameTxt.gridx = 2;
         gbc_firstNameTxt.gridy = 2;
         contentPanel.add(firstNameTxt, gbc_firstNameTxt);
      }
      {
         label_2 = new JLabel("Last Name");
         GridBagConstraints gbc_label_2 = new GridBagConstraints();
         gbc_label_2.anchor = GridBagConstraints.EAST;
         gbc_label_2.insets = new Insets(0, 0, 5, 5);
         gbc_label_2.gridx = 1;
         gbc_label_2.gridy = 3;
         contentPanel.add(label_2, gbc_label_2);
      }
      {
         lastNameTxt = new JTextField();
         lastNameTxt.setColumns(10);
         GridBagConstraints gbc_lastNameTxt = new GridBagConstraints();
         gbc_lastNameTxt.insets = new Insets(0, 0, 5, 5);
         gbc_lastNameTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_lastNameTxt.gridx = 2;
         gbc_lastNameTxt.gridy = 3;
         contentPanel.add(lastNameTxt, gbc_lastNameTxt);
      }
      {
         label_3 = new JLabel("Email");
         GridBagConstraints gbc_label_3 = new GridBagConstraints();
         gbc_label_3.anchor = GridBagConstraints.EAST;
         gbc_label_3.insets = new Insets(0, 0, 5, 5);
         gbc_label_3.gridx = 1;
         gbc_label_3.gridy = 4;
         contentPanel.add(label_3, gbc_label_3);
      }
      {
         emailTxt = new JTextField();
         emailTxt.setColumns(10);
         GridBagConstraints gbc_emailTxt = new GridBagConstraints();
         gbc_emailTxt.insets = new Insets(0, 0, 5, 5);
         gbc_emailTxt.fill = GridBagConstraints.HORIZONTAL;
         gbc_emailTxt.gridx = 2;
         gbc_emailTxt.gridy = 4;
         contentPanel.add(emailTxt, gbc_emailTxt);
      }
      {
         searchButton = new JButton("Search");
         searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Client c = new Client();
               c.licenseNumber = licenseNumberTxt.getText();
               c.firstName = firstNameTxt.getText();
               c.lastName = lastNameTxt.getText();
               c.email = emailTxt.getText();
               List<Client> hits = repo.SearchClients(c);
               if (hits != null) {
                  lblResults.setText("Results (" + hits.size() + ")");
                  DefaultListModel<Client> model = new DefaultListModel<Client>();
                  for (Client client : hits)
                     model.addElement(client);
                  resultsList.setModel(model);
               }
            }
         });
         GridBagConstraints gbc_searchButton = new GridBagConstraints();
         gbc_searchButton.fill = GridBagConstraints.HORIZONTAL;
         gbc_searchButton.insets = new Insets(0, 0, 5, 5);
         gbc_searchButton.gridx = 1;
         gbc_searchButton.gridy = 5;
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
         gbc_lblResults.gridy = 6;
         contentPanel.add(lblResults, gbc_lblResults);
      }
      {
         scrollPane = new JScrollPane();
         GridBagConstraints gbc_scrollPane = new GridBagConstraints();
         gbc_scrollPane.gridwidth = 2;
         gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
         gbc_scrollPane.fill = GridBagConstraints.BOTH;
         gbc_scrollPane.gridx = 1;
         gbc_scrollPane.gridy = 7;
         contentPanel.add(scrollPane, gbc_scrollPane);
         resultsList = new JList<Client>();
         resultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         resultsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
               client = (Client) resultsList.getSelectedValue();
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
                  client = null;
                  dispose();
               }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
         }
      }
      setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{licenseNumberTxt, firstNameTxt, lastNameTxt, emailTxt, searchButton, okButton, cancelButton}));
   }

   public Client getSelectedClient() {
      return client;
   }
}
