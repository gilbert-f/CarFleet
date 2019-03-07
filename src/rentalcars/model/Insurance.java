package rentalcars.model;

import javax.persistence.*;

@Entity
@Table (name = "insurance")
public class Insurance {
   @Id @Column (name = "id", length = 50)
   public String id;
   
   @Column (name = "type", length = 50)
   public String type;
   
   @Column (name = "body", precision = 8, scale = 2)
   public double body;
   
   @Column (name = "collision", precision = 8, scale = 2)
   public double collision;
   
   @Column (name = "medical", precision = 8, scale = 2)
   public double medical;
   
   @Column (name = "rate", precision = 8, scale = 2)
   public double rate;
   
   @Override
   public String toString() {
      return id + " (" + type + ", $" + rate + "): " + body + ", " + collision + ", " + medical;
   }
}