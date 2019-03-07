package rentalcars.gui;

import javax.swing.JComboBox;
import rentalcars.model.Branch;
import rentalcars.repo.BranchRepository;
import rentalcars.repo.interfaces.IBranchRepository;

@SuppressWarnings("serial")
public class BranchComboBox extends JComboBox<Branch> {
   public BranchComboBox() {
      super();
   }
   
   public Branch get() {
      return (Branch) getSelectedItem();
   }
   
   public void set(Branch b) {
      for (int i = 0; i < getModel().getSize(); i++)
         if (getItemAt(i).id == b.id) {
            setSelectedIndex(i);
            return;
         }
   }
   
   public void populate() {
      IBranchRepository repo = new BranchRepository();
      for (Branch b : repo.GetAllBranches())
         addItem(b);
   }
}
