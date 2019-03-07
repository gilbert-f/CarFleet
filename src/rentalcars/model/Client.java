package rentalcars.model;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "client")
public class Client {
   @Id @Column (name = "license_number", length = 50)
   public String licenseNumber;
   
   @Column (name = "first_name", length = 50)
   public String firstName;
   
   @Column (name = "last_name", length = 50)
   public String lastName;
   
   @Column (name = "dob")
   @Temporal (TemporalType.DATE)
   public Date dob;
   
   @Column (name = "email", length = 50)
   public String email;
   
   @Column (name = "phone", length = 32)
   public String phone;

   @Column (name = "street", length = 50)
   public String street;

   @Column (name = "city", length = 50)
   public String city;

   @Column (name = "state", length = 50)
   public String state;

   @Column (name = "zip", length = 50)
   public String zip;
   
   
   // For getting bookings by client
   @OneToMany(mappedBy = "client")
   public Set<Booking> bookings;
   
   // For printing out in a JList
   @Override
   public String toString() {
      return String.format("%s - %s, %s - %tF", licenseNumber, lastName, firstName, dob);
   }
}