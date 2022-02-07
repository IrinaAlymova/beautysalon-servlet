package controller.servlet;

import controller.security.HashUtil;
import dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
Login Servlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    /**
     * Forwards request to the login page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    /**
     * Processes Log In
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String hashedPassword = HashUtil.generateMD5HashedPassword(password);
        logger.info("Login user with the email: " + email);
        UserDTO userDTO = new UserDTO(email, hashedPassword);
        if (userService.logIn(userDTO)) {
            logger.info("User with email: " + email + " was successfully logged in");
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            logger.info("User with email: " + email + " failed to log in");
            //TODO: process non-registered user
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
