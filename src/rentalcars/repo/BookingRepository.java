package rentalcars.repo;

import rentalcars.model.Booking;
import rentalcars.repo.interfaces.IBookingRepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class BookingRepository implements IBookingRepository {
	
	private Session session() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	@Override
	public void CreateBooking(Booking booking) {
		try (Session session = session()) {
			session.beginTransaction();
			session.save(booking);
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public Booking GetBooking(int id) {
		try (Session session = session()) {
			Booking booking = session.get(Booking.class, id);
			session.close();
			return booking;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void UpdateBooking(Booking booking) {
		try (Session session = session()) {
			session.beginTransaction();
			session.update(booking);
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public void DeleteBooking(Booking booking) {
		try (Session session = session()) {
			session.beginTransaction();
			session.delete(booking);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	@Override
	public void DeleteBooking(int id) {
		try (Session session = session()) {
			session.beginTransaction();
			Booking booking = session.get(Booking.class, id);
	        session.delete(booking);
	        session.getTransaction().commit();
	        session.close();
	    } catch (Exception e) {
			System.out.println(e);
		}
	}

   @Override
   public List<Booking> SearchBookings(Booking query) {
      List<Booking> hits = null;
      try (Session session = session()) {
         CriteriaBuilder cb = session.getCriteriaBuilder();
         CriteriaQuery<Booking> cr = cb.createQuery(Booking.class);
         Root<Booking> root = cr.from(Booking.class);
         cr.select(root);
         
         List<Predicate> predicates = new ArrayList<Predicate>();
         if (query.client != null)
            predicates.add(cb.equal(root.get("client"), query.client));
         if (query.vehicle != null)
            predicates.add(cb.equal(root.get("vehicle"), query.vehicle));
         if (query.pickupBranch != null)
            predicates.add(cb.equal(root.get("pickupBranch"), query.pickupBranch));
         if (query.pickupDate != null)
            predicates.add(cb.equal(root.get("pickupDate"), query.pickupDate));
         if (query.dropoffBranch != null)
            predicates.add(cb.equal(root.get("dropoffBranch"), query.dropoffBranch));
         if (query.dropoffDate != null)
            predicates.add(cb.equal(root.get("dropoffBranch"), query.dropoffBranch));
         
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