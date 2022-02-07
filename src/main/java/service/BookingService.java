package service;

import dao.BookingDAO;
import dto.UserDTO;
import entity.Booking;
import entity.Service;
import entity.User;

import java.util.List;

public class BookingService {
    private final BookingDAO bookingDAO;
    //TODO: make DAO singletons?

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }
}
