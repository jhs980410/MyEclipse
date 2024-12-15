package controller;

import model.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        response.setContentType("application/json");
        try {
            boolean isAdded = userService.addUser(new User(userId, password));

            if (isAdded) {
                response.getWriter().write("{\"success\": true}");
            } else {
                response.getWriter().write("{\"success\": false, \"message\": \"User ID might already exist.\"}");
            }
        } catch (Exception e) {
            // 예외를 처리하고 클라이언트에게 응답
            try {
                response.getWriter().write("{\"success\": false, \"message\": \"" + e.getMessage() + "\"}");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            // 서버 로그에 예외 출력
            e.printStackTrace();
        }
    }
}

