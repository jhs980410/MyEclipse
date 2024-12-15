package controller;

import model.Task;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewTasks")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 세션에서 사용자 ID 가져오기
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        response.setContentType("text/html; charset=UTF-8");
        StringBuilder taskHtml = new StringBuilder();

        if (userId != null) {
            // 특정 사용자의 할 일 목록 가져오기
            List<Task> tasks = taskService.getTasksByUserId(userId);

            taskHtml.append("<html><head><title>Saved Tasks</title></head><body>");
            taskHtml.append("<h1>Your Saved Tasks</h1>");
            taskHtml.append("<ul>");

            for (Task task : tasks) {
                taskHtml.append("<li>")
                        .append(task.getContent())
                        .append(" (Due: ").append(task.getDueDate() != null ? task.getDueDate() : "No Date")
                        .append(" ").append(task.getDueTime() != null ? task.getDueTime() : "No Time")
                        .append(")").append("</li>");
            }

            taskHtml.append("</ul>");
            taskHtml.append("</body></html>");
        } else {
            // 세션에 사용자 정보가 없을 경우 로그인 페이지로 리다이렉트
            taskHtml.append("<html><head><title>Error</title></head><body>");
            taskHtml.append("<h1>Error: You are not logged in.</h1>");
            taskHtml.append("<a href='login.jsp'>Go to Login</a>");
            taskHtml.append("</body></html>");
        }

        response.getWriter().write(taskHtml.toString());
    }
}
