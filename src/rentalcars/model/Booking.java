package rentalcars.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table (name = "booking")
public class Booking {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column (name = "id")
   public int id;
   
   @ManyToOne (fetch = FetchType.EAGER)
   @JoinColumn(name = "vehicle_license")
   public Vehicle vehicle;
   
   @ManyToOne (fetch = FetchType.EAGER)
   @JoinColumn(name = "client_license_number")
   public Client client;
   
   @Column (name = "start_odometer")
   public Integer odometerStart;
   
   @Column (name = "end_odometer")
   public Integer odometerEnd;
   
   @Column (name = "start_tank", precision = 4, scale = 2)
   public Double tankStart;
   
   @Column (name = "end_tank", precision = 4, scale = 2, nullable = true)
   public Double tankEnd;
   
   @Column (name = "cost", precision = 8, scale = 2)
   public double cost;
   
   @Column (name = "payment_type", length = 50)
   public String paymentType;
   
   @ManyToOne (fetch = FetchType.EAGER)
   @JoinColumn(name = "pickup_branch_id")
   public Branch pickupBranch;
   
   @Column (name = "pickup_date")
   @Temporal (TemporalType.TIMESTAMP)
   public Date pickupDate;
   
   @ManyToOne (fetch = FetchType.EAGER)
   @JoinColumn(name = "dropoff_branch_id")
   public Branch dropoffBranch;
   
   @Column (name = "dropoff_date")
   @Temporal (TemporalType.TIMESTAMP)
   public Date dropoffDate;
   
   @Override
   public String toString() {
      return String.format("%06d%12s%12s%12s%12s %tF -> %tF", id, client.lastName, vehicle.license, vehicle.make, vehicle.model, pickupDate, dropoffDate);
   }
}