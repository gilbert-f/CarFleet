package rentalcars.repo;

import rentalcars.model.Branch;
import rentalcars.repo.interfaces.IBranchRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class BranchRepository implements IBranchRepository {
	
	private Session session() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	@Override
	public void CreateBranch(Branch branch) {
		try (Session session = session()) {
			session.beginTransaction();
			session.save(branch);
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public Branch GetBranch(int id) {
		try (Session session = session()) {
			Branch branch = session.get(Branch.class, id);
			session.close();
			return branch;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void UpdateBranch(Branch branch) {
		try (Session session = session()) {
			session.beginTransaction();
			session.update(branch);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void DeleteBranch(Branch branch) {
		try (Session session = session()) {
			session.beginTransaction();
			session.delete(branch);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void DeleteBranch(int id) {
		try (Session session = session()) {
			session.beginTransaction();
			Branch branch = session.get(Branch.class, id);
	        session.delete(branch);
	        session.getTransaction().commit();
	        session.close();
	    } catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public List<Branch> GetAllBranches() {
	   List<Branch> branches = null;
	   try (Session session = session()) {
	      CriteriaQuery<Branch> query = session.getCriteriaBuilder().createQuery(Branch.class);
	      @SuppressWarnings("unused")
	      Root<Branch> branchRoot = query.from(Branch.class);
	      branches = session.createQuery(query).list();
	   }
	   return branches;
	}
}