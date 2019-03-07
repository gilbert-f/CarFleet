package rentalcars.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table (name = "vehicle")
public class Vehicle {
   @Id @Column (name = "license", length = 7)
   public String license;
   
   @Column (name = "make", length = 50)
   public String make;
   
   @Column (name = "model", length = 50)
   public String model;
   
   @Column (name = "color", length = 20)
   public String color;
   
   @ManyToOne
   @JoinColumn (name = "type_name")
   public VehicleType type;
   
   @Column (name = "seats")
   public int seats;
   
   @Column (name = "availability")
   public boolean available;
   
   @ManyToOne (fetch = FetchType.EAGER)
   @JoinColumn (name = "insurance_id")
   public Insurance insurance;
   
   @ManyToOne (fetch = FetchType.EAGER)
   @JoinColumn (name = "current_branch")
   public Branch currentBranch;
   
   @Column (name = "odometer")
   public int odometer;
   
   
   // For getting bookings of this vehicle
   @OneToMany (mappedBy = "vehicle")
   public Set<Booking> bookings;
   
   // For printing in lists/etc
   @Override
   public String toString() {
      return license + " " + make + " " + model + " (" + seats + ")";
   }
}