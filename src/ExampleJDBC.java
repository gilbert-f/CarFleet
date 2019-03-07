import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import rentalcars.model.*;

public class ExampleJDBC {
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			// DISABLE HIBERNATES VERBOSE LOG OUTPUT
			java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);
			
			Properties prop = new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mariadb://rentalcarmaria.citpraowiyb8.us-west-2.rds.amazonaws.com/gaddrental");
			prop.setProperty("hibernate.connection.username", "rentalcarmaria");
			prop.setProperty("hibernate.connection.password", "teamgadd");
			prop.setProperty("dialect", "org.hibernate.dialect.MariaDBDialect");
         
			sessionFactory = new Configuration()
					.addProperties(prop)
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
	
	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
      
		session.beginTransaction();
		
		Branch branch4 = (Branch) session.get(Branch.class, 4);
	    System.out.println(" --- Branch 4 ---");
	    System.out.println(branch4.id + " " + branch4.city);
      
	    CriteriaQuery<Branch> query = session.getCriteriaBuilder().createQuery(Branch.class);
	    
	    @SuppressWarnings("unused")
	    Root<Branch> branchRoot = query.from(Branch.class);
	    
	    List<Branch> branches = session.createQuery(query).list();
      
	    System.out.println(" --- All branches ---");
	    for (Branch b : branches)
	    	System.out.println(b.id + " " + b.city);
      
	    // Get all cars at branch 2
	    System.out.println(" --- All vehicles at branch 2 ---");
	    Branch b2 = (Branch) session.get(Branch.class,  2);
	    for (Vehicle v : b2.vehicles) {
	    	System.out.println(v.license + " " + v.make + " " + v.model + " " + v.color);
	    }
	    
	    // Query for clients w/ certain attributes
	    Client clientQueryModel = new Client();
	    clientQueryModel.firstName = "Cary";
	    
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Client> cq = cb.createQuery(Client.class);
	    Root<Client> rootClient = cq.from(Client.class);
	    cq.select(rootClient).where(cb.equal(rootClient.get("firstName"), clientQueryModel.firstName)); // get all clients w/ firstname "Cary"
	    List<Client> clients = session.createQuery(cq).list();
	    
	    for (Client c : clients)
	       System.out.println(c.licenseNumber + " " + c.firstName + " " + c.lastName + " " + c.dob);
	    
	    session.close();
	}
}