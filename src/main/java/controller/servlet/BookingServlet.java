package controller.servlet;

import entity.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.BookingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 Booking List Servlet
 */
@WebServlet(name = "BookingServlet", urlPatterns = "/bookings")
public class BookingServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(BookingServlet.class);

    private BookingService bookingService;

    @Override
    public void init() throws ServletException {
        bookingService = new BookingService();
    }

    /**
     * Forwards request to bookings page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Booking> bookings = bookingService.getAllBookings();
        req.setAttribute("allBookings", bookings);
        req.getRequestDispatcher("/jsp/bookings.jsp").forward(req, resp);
    }
}
