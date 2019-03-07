package rentalcars.repo.interfaces;

import java.util.List;

import rentalcars.model.VehicleType;

public interface IVehicleTypeRepository {
   void CreateVehicleType(VehicleType vehicleType);
   VehicleType GetVehicleType(String name);
   void UpdateVehicleType(VehicleType vehicleType);
   void DeleteVehicleType(VehicleType vehicleType);
   void DeleteVehicleType(String name);
   List<VehicleType> GetAllVehicleTypes();
}