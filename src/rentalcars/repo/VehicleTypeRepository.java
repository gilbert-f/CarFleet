package rentalcars.repo;

import rentalcars.model.VehicleType;
import rentalcars.repo.interfaces.IVehicleTypeRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class VehicleTypeRepository implements IVehicleTypeRepository {
	
	private Session session() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	@Override
	public void CreateVehicleType(VehicleType vehicleType) {
		try (Session session = session()) {
			session.beginTransaction();
			session.save(vehicleType);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public VehicleType GetVehicleType(String name) {
		try (Session session = session()) {
			VehicleType vehicleType = session.get(VehicleType.class, name);
			session.close();
			return vehicleType;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void UpdateVehicleType(VehicleType vehicleType) {
		try (Session session = session()) {
			session.beginTransaction();
			session.update(vehicleType);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void DeleteVehicleType(VehicleType vehicleType) {
		try (Session session = session()) {
			session.beginTransaction();
			session.delete(vehicleType);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void DeleteVehicleType(String name) {
		try (Session session = session()) {
			session.beginTransaction();
			VehicleType vehicleType = session.get(VehicleType.class, name);
	        session.delete(vehicleType);
	        session.getTransaction().commit();
	        session.close();
	    } catch (Exception e) {
			System.out.println(e);
		}
	}

   @Override
   public List<VehicleType> GetAllVehicleTypes() {
      List<VehicleType> types = null;
      try (Session session = session()) {
         CriteriaQuery<VehicleType> query = session.getCriteriaBuilder().createQuery(VehicleType.class);
         @SuppressWarnings("unused")
         Root<VehicleType> branchRoot = query.from(VehicleType.class);
         types = session.createQuery(query).list();
      }
      return types;
   }
}