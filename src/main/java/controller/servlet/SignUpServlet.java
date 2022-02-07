package controller.servlet;

import controller.security.HashUtil;
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

    private SignUpValidator signUpValidator;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        signUpValidator = new SignUpValidator();
        userService = new UserService();
    }

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
        String password = HashUtil.generateMD5HashedPassword(req.getParameter("password"));
        logger.info("Saving user with parameters: name: " + name + ", email: " + email);
        if (!signUpValidator.validateEmail(email)) {
            //todo: process invalid email
            logger.info("User has invalid parameters: name: " + name + ", email: " + email + " saving failed");
        }
        //TODO: process already existing user
        UserDTO userDTO = new UserDTO(name, email, password);
        if (userService.saveUser(userDTO)) {
            logger.info("User with parameters: name: " + name + ", email: " + email + " was successfully saved");
        } else {
            logger.info("User with parameters: name: " + name + ", email: " + email + " saving failed");
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
