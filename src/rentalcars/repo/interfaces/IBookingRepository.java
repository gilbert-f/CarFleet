package rentalcars.repo.interfaces;

import java.util.List;

import rentalcars.model.Booking;

public interface IBookingRepository {
   void CreateBooking(Booking booking);
   Booking GetBooking(int id);
   void UpdateBooking(Booking booking);
   void DeleteBooking(Booking booking);
   void DeleteBooking(int id);
   List<Booking> SearchBookings(Booking query);
}