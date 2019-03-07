import rentalcars.repo.*;
import rentalcars.model.*;

import java.util.Date;

@SuppressWarnings("unused")
public class testBooking {
	public static void main(String[] args) {
		BookingRepository bookingRepository = new BookingRepository();
		BranchRepository branchRepository = new BranchRepository();
		ClientRepository clientRepository = new ClientRepository();
		InsuranceRepository insuranceRepository = new InsuranceRepository();
		VehicleRepository vehicleRepository = new VehicleRepository();
		VehicleTypeRepository vehicleTypeRepository = new VehicleTypeRepository();
		
		Booking booking = new Booking();
		//booking.id = 1;
		booking.vehicle = vehicleRepository.GetVehicle("04XG6LH");
		booking.client = clientRepository.GetClient("0J711V68ZL");
		booking.odometerStart = 0;
		booking.odometerEnd = 1;
		booking.tankStart = 1.0;
		booking.tankEnd = 0.0;
		booking.cost = 1.0;
		booking.paymentType = "Card";
		booking.pickupBranch = branchRepository.GetBranch(1);
		booking.pickupDate = new Date();
		booking.dropoffBranch = branchRepository.GetBranch(1);
		booking.dropoffDate = new Date();
		
		System.out.println(booking.id);
		System.out.println(booking.vehicle.license);
		System.out.println(booking.client.licenseNumber);
		System.out.println(booking.odometerStart);
		System.out.println(booking.odometerEnd);
		System.out.println(booking.tankStart);
		System.out.println(booking.tankEnd);
		System.out.println(booking.cost);
		System.out.println(booking.paymentType);
		System.out.println(booking.pickupBranch.id);
		System.out.println(booking.pickupDate);
		System.out.println(booking.dropoffBranch.id);
		System.out.println(booking.dropoffDate);
		
		bookingRepository.CreateBooking(booking);
		System.out.println(booking.id);
		
		/*booking = new Booking();
		booking.id = 9999;
		booking.vehicle = vehicleRepository.GetVehicle("04XG6LH");
		booking.client = clientRepository.GetClient("0J711V68ZL");
		booking.odometerStart = 1;
		booking.odometerEnd = 1;
		booking.tankStart = 1;
		booking.tankEnd = 1;
		booking.cost = 1.0;
		booking.paymentType = "Card";
		booking.pickupBranch = branchRepository.GetBranch(1);
		booking.pickupDate = new Date();
		booking.dropoffBranch = branchRepository.GetBranch(1);
		booking.dropoffDate = new Date();
		bookingRepository.UpdateBooking(booking);
		
		bookingRepository.DeleteBooking(booking);
		System.out.println(bookingRepository.GetBooking(9999).odometerStart);
		
		booking = new Booking();
		booking.id = 9999;
		booking.vehicle = vehicleRepository.GetVehicle("04XG6LH");
		booking.client = clientRepository.GetClient("0J711V68ZL");
		booking.odometerStart = 0;
		booking.odometerEnd = 1;
		booking.tankStart = 1;
		booking.tankEnd = 0;
		booking.cost = 1.0;
		booking.paymentType = "Card";
		booking.pickupBranch = branchRepository.GetBranch(1);
		booking.pickupDate = new Date();
		booking.dropoffBranch = branchRepository.GetBranch(1);
		booking.dropoffDate = new Date();
		
		bookingRepository.CreateBooking(booking);
		bookingRepository.DeleteBooking(9999);
		System.out.println(bookingRepository.GetBooking(9999).odometerStart);*/
	}
}