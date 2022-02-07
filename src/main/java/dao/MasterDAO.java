package dao;

import dao.db.HikariCPDataSource;
import entity.Master;
import entity.Service;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.sql.DBConnectionSQL.GET_MASTER_BY_ID;
import static dao.sql.DBConnectionSQL.GET_USER_BY_ID;

public class MasterDAO {

    private final Logger logger = LoggerFactory.getLogger(MasterDAO.class);

    /**
     * @return list consisting of one Master object corresponding to the id passed as a parameter,
     * or an empty List if no such master found
     */
    public List<Master> getMasterById(long id) {
        List<Master> masterList = new ArrayList<>();
        try (Connection connection = HikariCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_MASTER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Master master = new Master();
                master.setId(resultSet.getLong("master_id"));
                master.setName(resultSet.getString("master_name"));
                master.setService(new Service(resultSet.getLong("service_id"),
                        resultSet.getString("service_name"),
                        resultSet.getInt("price")));
                masterList.add(master);
            } else {
                logger.info("There's no master with the id: " + id + " in database");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return masterList;
    }

}
