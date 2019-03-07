package rentalcars.repo.interfaces;

import java.util.List;

import rentalcars.model.Insurance;

public interface IInsuranceRepository {
   void CreateInsurance(Insurance insurance);
   Insurance GetInsurance(String id);
   void UpdateInsurance(Insurance insurance);
   void DeleteInsurance(Insurance insurance);
   void DeleteInsurance(String id);
   List<Insurance> SearchInsurances(Insurance query);
}