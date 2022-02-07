package service;

import dao.ServiceDAO;
import entity.Service;

import java.util.List;

public class ServiceService {

    private final ServiceDAO serviceDAO;

    public ServiceService() {
        this.serviceDAO = new ServiceDAO();
    }

    public List<Service> getAllServices() {
        return serviceDAO.getAllServices();
    }
}
