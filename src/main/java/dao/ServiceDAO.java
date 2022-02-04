package dao;

import dao.db.DBManager;
import entity.Service;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.sql.DBConnectionSQL.*;

public class ServiceDAO {

    public List<Service> getAllServices() {
        List<Service> allServices = new ArrayList<>();
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SERVICES)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service();
                service.setId(resultSet.getInt("id"));
                service.setName(resultSet.getString("name"));
                service.setPrice(resultSet.getInt("price"));
                allServices.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allServices;
    }
}
