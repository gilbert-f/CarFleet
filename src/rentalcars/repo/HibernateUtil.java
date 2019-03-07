package rentalcars.repo;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rentalcars.model.Booking;
import rentalcars.model.Branch;
import rentalcars.model.Client;
import rentalcars.model.Insurance;
import rentalcars.model.Vehicle;
import rentalcars.model.VehicleType;

public class HibernateUtil {
   private static SessionFactory sessionFactory = buildSessionFactory();
   
   private static SessionFactory buildSessionFactory() {
      try {
         // DISABLE HIBERNATES VERBOSE LOG OUTPUT
         java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);

         Properties prop = new Properties();
         prop.setProperty("hibernate.connection.url",
               "jdbc:mariadb://rentalcarmaria.citpraowiyb8.us-west-2.rds.amazonaws.com/gaddrental");
         prop.setProperty("hibernate.connection.username", "rentalcarmaria");
         prop.setProperty("hibernate.connection.password", "teamgadd");
         prop.setProperty("dialect", "org.hibernate.dialect.MariaDBDialect");

         return new Configuration().addProperties(prop)
               .addAnnotatedClass(VehicleType.class)
               .addAnnotatedClass(Insurance.class)
               .addAnnotatedClass(Client.class)
               .addAnnotatedClass(Branch.class)
               .addAnnotatedClass(Vehicle.class)
               .addAnnotatedClass(Booking.class)
               .buildSessionFactory();
      } catch (Throwable ex) {
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static SessionFactory getSessionFactory() {
       return sessionFactory;
   }

   public static void shutdown() {
       getSessionFactory().close();
   }
}
