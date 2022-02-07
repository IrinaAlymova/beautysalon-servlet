package dao;

import dao.db.HikariCPDataSource;
import entity.Booking;
import entity.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.sql.DBConnectionSQL.*;

public class BookingDAO {
    private UserDAO userDAO;
    private MasterDAO masterDAO;

    public BookingDAO() {
        this.userDAO = new UserDAO();
    }

    public List<Booking> getAllBookings() {
        List<Booking> allBookings = new ArrayList<>();
        try (Connection connection = HikariCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOKINGS)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                long user_id = resultSet.getLong("user_id");
                long master_id = resultSet.getLong("master_id");
                booking.setUser(userDAO.getUserById(user_id).get(0));
                booking.setMaster(masterDAO.getMasterById(master_id).get(0));
                //TODO: map user and master
                allBookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBookings;
    }
}
