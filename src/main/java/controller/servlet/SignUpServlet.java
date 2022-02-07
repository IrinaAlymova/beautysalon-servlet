package controller.servlet;

import controller.hash.MD5HashUtil;
import controller.validator.SignUpValidator;
import dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Sign-Up Servlet
 */
@WebServlet(name = "SignUpServlet", urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(SignUpServlet.class);

    /**
     * Forwards request to the Sign-Up Page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signup.jsp").forward(req, resp);
    }

    /**
     * Processes Signing-Up
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = MD5HashUtil.generateHashedPassword(req.getParameter("password"));
        logger.info("Saving user with parameters: name: " + name + ", email: " + email + ", password: " + password);
        SignUpValidator signUpValidator = new SignUpValidator();
        if (!signUpValidator.validateEmail(email)) {
            //todo: process invalid email
        }
        UserService userService = new UserService();
        UserDTO userDTO = new UserDTO(name, email, password);
        userService.saveUser(userDTO);
        //TODO: process already existing user
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }
}
