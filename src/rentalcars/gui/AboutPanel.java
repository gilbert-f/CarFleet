package rentalcars.gui;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;


public class AboutPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public AboutPanel() {
		
		String aboutParagraph = "This is the first database application for our Car Rental Company. "
				+ "Its purpose is to easily and seamlessly manage most, if not all, of the required "
				+ "operational tasks when booking and reserving vehicles. ";
		
		//Car Image resizing.
		ImageIcon aboutHatchbackImage = new ImageIcon(getClass().getResource("/icons/hatchback.png"));
		java.awt.Image originalImage = aboutHatchbackImage.getImage();
		java.awt.Image resizedOriginalImage = originalImage.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		aboutHatchbackImage = new ImageIcon(resizedOriginalImage);
		
		//Member Image resizing
		ImageIcon memberImage = new ImageIcon(getClass().getResource("/icons/membericon.png"));
		java.awt.Image originalMemberImage = memberImage.getImage();
		java.awt.Image resizedOriginalMemberImage = originalMemberImage.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		memberImage = new ImageIcon(resizedOriginalMemberImage);
		
				
				JLabel lblAboutCarRental = DefaultComponentFactory.getInstance().createTitle("About Car Rental Database");
				lblAboutCarRental.setFont(new Font("Lucida Grande", Font.BOLD, 15));
						
						JLabel lblNewLabel = new JLabel(aboutHatchbackImage);
						
						JTextArea textArea = new JTextArea(aboutParagraph);
						textArea.setWrapStyleWord(true);
						textArea.setLineWrap(true);
						textArea.setBackground(SystemColor.window);
						
						JLabel lblMembers = DefaultComponentFactory.getInstance().createLabel("Members");
						
						JLabel lblVersion = DefaultComponentFactory.getInstance().createLabel("Version: 1.0.1");
						lblVersion.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
						
						JLabel memberIcon = new JLabel(memberImage);
						
						JLabel lblDanielDoran = DefaultComponentFactory.getInstance().createLabel("Daniel Doran");
						
						JLabel lblNewLabel_1 = new JLabel(memberImage);
						
						JLabel lblGilbertFebrianto = DefaultComponentFactory.getInstance().createLabel("Gilbert Febrianto");
						
						JLabel lblNewLabel_2 = new JLabel(memberImage);
						
						JLabel lblNewLabel_3 = new JLabel(memberImage);
						
						JLabel lblAndreyCheb = DefaultComponentFactory.getInstance().createLabel("Andrey Cheb");
						
						JLabel lblDionThompson = DefaultComponentFactory.getInstance().createLabel("Dion Thompson");
						
						GroupLayout groupLayout = new GroupLayout(this);
						groupLayout.setHorizontalGroup(
							groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(259)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(6)
													.addComponent(lblNewLabel))
												.addComponent(lblVersion)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(186)
											.addComponent(lblAboutCarRental))
										.addGroup(groupLayout.createSequentialGroup()
											.addContainerGap()
											.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 572, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(268)
											.addComponent(lblMembers))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(51)
													.addComponent(memberIcon, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(40)
													.addComponent(lblDanielDoran)))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(44)
													.addComponent(lblGilbertFebrianto))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(65)
													.addComponent(lblNewLabel_1)))
											.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAndreyCheb)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(6)
													.addComponent(lblNewLabel_2)))
											.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
													.addComponent(lblDionThompson)
													.addGap(37))
												.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_3)
													.addGap(59)))))
									.addContainerGap(11, Short.MAX_VALUE))
						);
						groupLayout.setVerticalGroup(
							groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(17)
									.addComponent(lblAboutCarRental)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblVersion)
									.addGap(3)
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblMembers)
									.addGap(13)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDanielDoran)
										.addComponent(lblGilbertFebrianto)
										.addComponent(lblAndreyCheb)
										.addComponent(lblDionThompson))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(memberIcon, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_3))
									.addGap(194))
						);
						setLayout(groupLayout);
		
			
		
	}
}