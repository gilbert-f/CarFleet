package rentalcars.gui;

import javax.swing.JComboBox;
import rentalcars.model.VehicleType;
import rentalcars.repo.VehicleTypeRepository;
import rentalcars.repo.interfaces.IVehicleTypeRepository;

@SuppressWarnings("serial")
public class VehicleTypeComboBox extends JComboBox<VehicleType> {
   public VehicleTypeComboBox() {
      super();
   }
   
   public VehicleType get() {
      return (VehicleType) getSelectedItem();
   }
   
   public void set(VehicleType vt) {
      for (int i = 0; i < getModel().getSize(); i++)
         if (getItemAt(i).name.equals(vt.name)) {
            setSelectedIndex(i);
            return;
         }
   }
   
   public void populate() {
      IVehicleTypeRepository repo = new VehicleTypeRepository();
      for (VehicleType vt : repo.GetAllVehicleTypes())
         addItem(vt);
   }
}
