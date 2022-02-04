package controller.servlet;

import controller.validator.SignUpValidator;

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
        String password = req.getParameter("password");
        SignUpValidator signUpValidator = new SignUpValidator();
        if (!signUpValidator.validateEmail(email)) {
            //todo: process invalid email
        }
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }
}
