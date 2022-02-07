package controller.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 Homepage Servlet
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home", "/"})
public class HomeServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(HomeServlet.class);


    /**
     * Forwards request to the home page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }
}
