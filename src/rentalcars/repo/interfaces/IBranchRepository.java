package rentalcars.repo.interfaces;

import java.util.List;

import rentalcars.model.Branch;

public interface IBranchRepository {
   void CreateBranch(Branch branch);
   Branch GetBranch(int id);
   void UpdateBranch(Branch branch);
   void DeleteBranch(Branch branch);
   void DeleteBranch(int id);
   List<Branch> GetAllBranches();
}