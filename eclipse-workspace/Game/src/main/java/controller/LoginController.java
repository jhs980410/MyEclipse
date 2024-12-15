package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        System.out.println("User ID: " + userId + ", Password: " + password);

        System.out.println("Login attempt: userId=" + userId);
        
        User user = userService.validateLogin(userId, password);

        if (user != null) {
            System.out.println("Login successful: userId=" + userId);
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            response.sendRedirect("main.jsp");
        } else {
            System.out.println("Login failed: invalid credentials for userId=" + userId);
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
