package service;

import dao.ServiceDAO;
import entity.Service;

import java.util.List;

public class ServiceService {
    public List<Service> getAllServices() {
        ServiceDAO serviceDAO = new ServiceDAO();
        return serviceDAO.getAllServices();
    }
}
