import rentalcars.repo.*;
import rentalcars.model.*;

import java.util.Date;

@SuppressWarnings("unused")
public class testClient {
	public static void main(String[] args) {
		BookingRepository bookingRepository = new BookingRepository();
		BranchRepository branchRepository = new BranchRepository();
		ClientRepository clientRepository = new ClientRepository();
		InsuranceRepository insuranceRepository = new InsuranceRepository();
		VehicleRepository vehicleRepository = new VehicleRepository();
		VehicleTypeRepository vehicleTypeRepository = new VehicleTypeRepository();
		
		Client client = new Client();
		client.licenseNumber = "GETKRAZY";
		client.firstName = "Get";
		client.lastName = "Krazy";
		client.dob = new Date();
		client.email = "gk@gk.gk";
		client.phone = "253-253-2533";
		client.street = "1111 Ave";
		client.city = "Seattle";
		client.state = "WA";
		client.zip = "98105";
		
		//clientRepository.DeleteClient("GETKRAZY");
		
		clientRepository.CreateClient(client);
		//System.out.println(bookingRepository.GetBooking(9999));
		
		Client clientQueryModel = new Client();
		clientQueryModel.firstName = "Amelia";
		clientQueryModel.lastName = "Roger";
		
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