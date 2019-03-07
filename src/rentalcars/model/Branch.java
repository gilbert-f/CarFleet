package rentalcars.model;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "branch")
public class Branch {
   @Id @Column (name = "id")
   public int id;
   
   @Column (name = "phone", length = 32)
   public String phone;
   
   @Column (name = "open_time")
   @Temporal (TemporalType.TIME)
   public Date openTime;
   
   @Column (name = "close_time")
   @Temporal (TemporalType.TIME)
   public Date closeTime;
   
   @Column (name = "wkend_open_time")
   @Temporal (TemporalType.TIME)
   public Date weekendOpenTime;
   
   @Column (name = "wkend_close_time")
   @Temporal (TemporalType.TIME)
   public Date weekendCloseTime;
   
   @Column (name = "after_hour_drop_off")
   public boolean afterHourDropOff;
   
   @Column (name = "street", length = 50)
   public String street;
   
   @Column (name = "city", length = 50)
   public String city;
   
   @Column (name = "state", length = 50)
   public String state;
   
   @Column (name = "zip", length = 50)
   public String zip;
   
   
   // For getting vehicles by branch
   @OneToMany(mappedBy = "currentBranch")
   public Set<Vehicle> vehicles;
   
   // For combo boxes
   @Override
   public String toString() {
      return this.id + " - " + city;
   }
}