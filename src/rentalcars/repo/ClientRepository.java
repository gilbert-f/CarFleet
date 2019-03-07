package rentalcars.repo;

import rentalcars.model.Client;
import rentalcars.repo.interfaces.IClientRepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class ClientRepository implements IClientRepository {
	
	private Session session() {
		return HibernateUtil.getSessionFactory().openSession();
	}
   
   @Override
   public void CreateClient(Client client) {
	   try (Session session = session()) {
	      session.beginTransaction();
	      session.save(client);
	      session.getTransaction().commit();
	      session.close();
	   } catch (Exception e) {
		   System.out.println(e);
	   }
   }
   
   @Override
   public Client GetClient(String licenseNumber) {
	   try (Session session = session()) {
		   Client client = session.get(Client.class, licenseNumber);
		   session.close();
		   return client;
	   } catch (Exception e) {
		   System.out.println(e);
		   return null;
	   }
   }
   
   @Override
   public void UpdateClient(Client client) {
	   try (Session session = session()) {
		   session.beginTransaction();
		   session.saveOrUpdate(client);
		   session.getTransaction().commit();
		   session.close();
	   } catch (Exception e) {
		   System.out.println(e);
	   }
   }
   
   @Override
   public void DeleteClient(Client client) {
	   try (Session session = session()) {
		   session.beginTransaction();
		   session.delete(client);
		   session.getTransaction().commit();
		   session.close();
	   } catch (Exception e) {
		   System.out.println(e);
	   }
   }
   
   @Override
   public void DeleteClient(String licenseNumber) {
	   try (Session session = session()) {
		   session.beginTransaction();
		   Client client = session.get(Client.class, licenseNumber);
		   session.delete(client);
		   session.getTransaction().commit();
		   session.close();
	   } catch (Exception e) {
		   System.out.println(e);
	   }
   }
   
   /* Search for clients based on licenseNumber, firstname, lastname and/or email.
    * 
    */
   @Override
   public List<Client> SearchClients(Client query) {
      List<Client> hits = null;
      try (Session session = session()) {
         CriteriaBuilder cb = session.getCriteriaBuilder();
         CriteriaQuery<Client> cr = cb.createQuery(Client.class);
         Root<Client> root = cr.from(Client.class);
         cr.select(root);
         
         List<Predicate> predicates = new ArrayList<Predicate>();
         if (query.licenseNumber != null && query.licenseNumber.trim().length() > 0)
            predicates.add(cb.equal(root.get("licenseNumber"), query.licenseNumber));
         if (query.firstName != null && query.firstName.trim().length() > 0)
            predicates.add(cb.equal(root.get("firstName"), query.firstName));
         if (query.lastName != null && query.lastName.trim().length() > 0)
            predicates.add(cb.equal(root.get("lastName"), query.lastName));
         if (query.email != null && query.email.trim().length() > 0)
            predicates.add(cb.equal(root.get("email"), query.email));
         
         if (predicates.size() == 0)
            return null;
         
         Predicate predicate = predicates.remove(0);
         
         while (predicates.size() > 0)
            predicate = cb.and(predicate, predicates.remove(0));
         
         hits = session.createQuery(cr.select(root).where(predicate)).list();
         
         session.close();
      }
      return hits;
   }
}