package rentalcars.repo.interfaces;

import java.util.List;

import rentalcars.model.Vehicle;

public interface IVehicleRepository {
   void CreateVehicle(Vehicle vehicle);
   Vehicle GetVehicle(String license);
   void UpdateVehicle(Vehicle vehicle);
   void DeleteVehicle(Vehicle vehicle);
   void DeleteVehicle(String license);
   List<Vehicle> SearchVehicles(Vehicle query);
}