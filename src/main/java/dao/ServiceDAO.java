package dao;

import entity.Service;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {

    public List<Service> getAllServices() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String DATABASE_URL = "jdbc:mysql://localhost:3306/beautysalon?user=root&password=rootroot";
        List<Service> allServices = new ArrayList<>();
        String sql = "SELECT * FROM service";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(sql)){
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
