package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "2059qweasd";

    // 사용자 추가 메서드
    public boolean addUser(User user) {
        try {
            // 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");

            // SQL 쿼리 작성
            String query = "INSERT INTO users (userId, password) VALUES (?, ?)";
            System.out.println("Executing Query: " + query);

            // 데이터베이스 연결 및 쿼리 실행
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                // User 객체에서 userId와 password 값 가져오기
                stmt.setString(1, user.getUserId());
                stmt.setString(2, user.getPassword());
                stmt.executeUpdate();

                System.out.println("User added successfully!");
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database or executing query!");
            e.printStackTrace();
        }
        return false;
    }

    // 로그인 검증 메서드
    public User validateLogin(String userId, String password) {
        try {
            // 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Validating login for userId: " + userId);

            // 데이터베이스 연결 및 쿼리 실행
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE userId = ? AND password = ?")) {

                stmt.setString(1, userId);
                stmt.setString(2, password);

                System.out.println("Executing Query: SELECT * FROM users WHERE userId = '" + userId + "' AND password = '****'");

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // 유효한 사용자인 경우 User 객체 반환
                        System.out.println("Login successful for userId: " + userId);
                        return new User(
                            rs.getInt("id"),
                            rs.getString("userId"),
                            rs.getString("password")
                        );
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database or executing query!");
            e.printStackTrace();
        }

        // 로그인 실패 로그 추가
        System.out.println("Login failed for userId: " + userId);
        return null;
    }
}
