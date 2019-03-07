package rentalcars.repo;

import rentalcars.model.Vehicle;
import rentalcars.repo.interfaces.IVehicleRepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class VehicleRepository implements IVehicleRepository {
	
	private Session session() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	@Override
	public void CreateVehicle(Vehicle vehicle) {
		try (Session session = session()) {
			session.beginTransaction();
			session.save(vehicle);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Vehicle GetVehicle(String licenseNumber) {
		try (Session session = session()) {
			Vehicle vehicle = session.get(Vehicle.class, licenseNumber);
			session.close();
			return vehicle;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void UpdateVehicle(Vehicle vehicle) {
		try (Session session = session()) {
			session.beginTransaction();
			session.update(vehicle);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void DeleteVehicle(Vehicle vehicle) {
		try (Session session = session()) {
			session.beginTransaction();
			session.delete(vehicle);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void DeleteVehicle(String licenseNumber) {
		try (Session session = session()) {
			session.beginTransaction();
			Vehicle vehicle = session.get(Vehicle.class, licenseNumber);
	        session.delete(vehicle);
	        session.getTransaction().commit();
	        session.close();
	    } catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public List<Vehicle> SearchVehicles(Vehicle query) {
      List<Vehicle> hits = null;
      try (Session session = session()) {
         CriteriaBuilder cb = session.getCriteriaBuilder();
         CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
         Root<Vehicle> root = cr.from(Vehicle.class);
         cr.select(root);
         
         List<Predicate> predicates = new ArrayList<Predicate>();
         if (query.license != null && query.license.trim().length() > 0)
            predicates.add(cb.equal(root.get("license"), query.license));
         if (query.make != null && query.make.trim().length() > 0)
            predicates.add(cb.equal(root.get("make"), query.make));
         if (query.model != null && query.model.trim().length() > 0)
            predicates.add(cb.equal(root.get("model"), query.model));
         if (query.seats != 0)
            predicates.add(cb.ge(root.get("seats"), query.seats));
         if (query.type != null)
            predicates.add(cb.equal(root.get("type"), query.type));
         if (query.currentBranch != null)
            predicates.add(cb.equal(root.get("currentBranch"), query.currentBranch));
         
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