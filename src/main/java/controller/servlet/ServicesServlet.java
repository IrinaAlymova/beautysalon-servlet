package controller.servlet;

import entity.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 Salon Services Servlet
 */
@WebServlet(name = "ServicesServlet", urlPatterns = "/services")
public class ServicesServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(ServicesServlet.class);

    private ServiceService serviceService;

    @Override
    public void init() throws ServletException {
        serviceService = new ServiceService();
    }

    /**
     * Forwards request to services page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> services = serviceService.getAllServices();
        req.setAttribute("allServices", services);
        req.getRequestDispatcher("/jsp/services.jsp").forward(req, resp);
    }
}
