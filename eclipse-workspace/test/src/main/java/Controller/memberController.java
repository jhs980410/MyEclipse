package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberController")
public class memberController extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=UTC";  // 데이터베이스 URL
    private static final String USERNAME = "root";  // MySQL 사용자명
    private static final String PASSWORD = "2059qweasd";  // MySQL 비밀번호

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        String userId = request.getParameter("id");
        String userPw = request.getParameter("password");
        String action = request.getParameter("action");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // 데이터베이스 연결 및 쿼리 준비
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            // 디버깅: userId와 userPw 값 출력
            System.out.println("Received userId: " + userId);
            System.out.println("Received userPw: " + userPw);
            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // 데이터베이스 연결

            if ("login".equals(action)) {
                if (userId == null || userId.isEmpty() || userPw == null || userPw.isEmpty()) {
                    out.print("{\"success\": false, \"message\": \"아이디와 비밀번호를 입력해 주세요.\"}");
                    return;
                }

                // 로그인 처리
                String sql = "SELECT userId FROM mydb2.mydb3 WHERE userId = ? AND userPw = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, userId);
                statement.setString(2, userPw);
                	
                System.out.println("Login SQL: " + sql);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // 로그인 성공
                    out.print("{\"success\": true}");
                } else {
                    // 로그인 실패
                    out.print("{\"success\": false, \"message\": \"로그인 실패. 아이디 또는 비밀번호가 일치하지 않습니다.\"}");
                }
            } else if ("signup".equals(action)) {
                if (userId == null || userId.isEmpty() || userPw == null || userPw.isEmpty()) {
                    out.print("{\"success\": false, \"message\": \"아이디와 비밀번호를 입력해 주세요.\"}");
                    return;
                }

                // 아이디 중복 체크
                String checkSql = "SELECT userId FROM mydb2.mydb3 WHERE userId = ?";
                statement = connection.prepareStatement(checkSql);
                statement.setString(1, userId);
                resultSet = statement.executeQuery();
                System.out.println("Check SQL: " + checkSql);  // 쿼리 출력
                if (resultSet.next()) {
                    // 아이디가 이미 존재하면
                    out.print("{\"success\": false, \"message\": \"이미 존재하는 아이디입니다.\"}");
                } else {
                    // 아이디가 없으면 새로운 사용자 추가
                    String insertSql = "INSERT INTO mydb2.mydb3 (userId, userPw) VALUES (?, ?)";
                    statement = connection.prepareStatement(insertSql);
                    statement.setString(1, userId);
                    statement.setString(2, userPw);
                    System.out.println("Insert SQL: " + insertSql);  // 쿼리 출력
                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0) {
                        out.print("{\"success\": true}");
                    } else {
                        out.print("{\"success\": false, \"message\": \"회원가입 실패. 다시 시도해 주세요.\"}");
                    }
                }
            } else {
                out.print("{\"success\": false, \"message\": \"유효하지 않은 요청입니다.\"}");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"DB 오류\"}");
        } catch (ClassNotFoundException e) { // 예외 처리 추가
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"MySQL 드라이버를 로드할 수 없습니다.\"}");}
            finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
}

    
