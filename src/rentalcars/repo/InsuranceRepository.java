package rentalcars.repo;

import rentalcars.model.Insurance;
import rentalcars.repo.interfaces.IInsuranceRepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class InsuranceRepository implements IInsuranceRepository {
	
	private Session session() {
		return HibernateUtil.getSessionFactory().openSession();
	}
   
   @Override
   public void CreateInsurance(Insurance insurance) {
	   try (Session session = session()) {
	      session.beginTransaction();
	      session.save(insurance);
	      session.getTransaction().commit();
	      session.close();
	   }
   }
   
   @Override
   public Insurance GetInsurance(String id) {
	   try (Session session = session()) {
		   Insurance insurance = session.get(Insurance.class, id);
		   session.close();
		   return insurance;
	   } catch (Exception e) {
		   System.out.println(e);
		   return null;
	   }
   }
   
   @Override
   public void UpdateInsurance(Insurance insurance) {
	   try (Session session = session()) {
       session.beginTransaction();
       session.update(insurance);
       session.getTransaction().commit();
       session.close();
       } catch (Exception e) {
    	   System.out.println(e);
       }
   }
   
   @Override
   public void DeleteInsurance(Insurance insurance) {
	   try (Session session = session()) {
		   session.beginTransaction();
		   session.delete(insurance);
		   session.getTransaction().commit();
		   session.close();
	   } catch (Exception e) {
		   System.out.println(e);
	   }
   }
   
   @Override
   public void DeleteInsurance(String id) {
	   try (Session session = session()) {
		   session.beginTransaction();
		   Insurance insurance = session.get(Insurance.class, id);
		   session.delete(insurance);
		   session.getTransaction().commit();
		   session.close();
	   } catch (Exception e) {
		   System.out.println(e);
	   }
   }

   @Override
   public List<Insurance> SearchInsurances(Insurance query) {
      List<Insurance> hits = null;
      try (Session session = session()) {
         CriteriaBuilder cb = session.getCriteriaBuilder();
         CriteriaQuery<Insurance> cr = cb.createQuery(Insurance.class);
         Root<Insurance> root = cr.from(Insurance.class);
         cr.select(root);
         
         List<Predicate> predicates = new ArrayList<Predicate>();
         if (query.id != null && query.id.trim().length() > 0)
            predicates.add(cb.equal(root.get("id"), query.id));
         if (query.type != null && query.type.trim().length() > 0)
            predicates.add(cb.equal(root.get("type"), query.type));
         if (query.body != 0)
            predicates.add(cb.ge(root.get("body"), query.body));
         if (query.collision != 0)
            predicates.add(cb.ge(root.get("collision"), query.collision));
         if (query.rate != 0)
            predicates.add(cb.ge(root.get("rate"), query.rate));
         if (query.medical != 0)
            predicates.add(cb.ge(root.get("medical"), query.medical));
         
         if (predicates.size() == 0) {
            CriteriaQuery<Insurance> allquery = session.getCriteriaBuilder().createQuery(Insurance.class);
            @SuppressWarnings("unused")
            Root<Insurance> insuranceRoot = allquery.from(Insurance.class);
            return session.createQuery(allquery).list();
         }
            
         Predicate predicate = predicates.remove(0);
         
         while (predicates.size() > 0)
            predicate = cb.and(predicate, predicates.remove(0));
         
         hits = session.createQuery(cr.select(root).where(predicate)).list();
         
         session.close();
      }
      return hits;
   }
}