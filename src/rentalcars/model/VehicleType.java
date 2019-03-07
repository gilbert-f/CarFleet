package rentalcars.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table (name = "vehicle_type")
public class VehicleType {
   @Id @Column (name = "name", length = 50)
   public String name;
   
   @Column (name = "rate", precision = 8, scale = 2)
   public double rate;
   
   
   // For getting vehicles by vehicle type
   @OneToMany(mappedBy = "type")
   public Set<Vehicle> vehicles;
   
   @Override
   public String toString() {
      return name + " $" + rate;
   }
}