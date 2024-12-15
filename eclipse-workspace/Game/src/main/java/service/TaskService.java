package service;

import model.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "2059qweasd";

    // 모든 할 일 가져오기
    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	tasks.add(new Task(
            		    rs.getInt("id"),
            		    rs.getString("content"),
            		    rs.getBoolean("completed"),
            		    rs.getDate("due_date"),
            		    rs.getTime("due_time"),
            		    rs.getInt("userId") // 추가
            		));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // 특정 사용자의 할 일 가져오기
    public List<Task> getTasksByUserId(int userId) {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks WHERE userId = ?"; // userId로 수정
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	tasks.add(new Task(
            		    rs.getInt("id"),
            		    rs.getString("content"),
            		    rs.getBoolean("completed"),
            		    rs.getDate("due_date"),
            		    rs.getTime("due_time"),
            		    rs.getInt("userId") // 추가
            		));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // 새 할 일 추가
    public void addTask(Task task) {
        String query = "INSERT INTO tasks (content, completed, due_date, due_time, userId) VALUES (?, ?, ?, ?, ?)"; // userId로 수정
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, task.getContent());
            stmt.setBoolean(2, task.isCompleted());
            stmt.setDate(3, task.getDueDate());
            stmt.setTime(4, task.getDueTime());
            stmt.setInt(5, task.getUserId()); // 사용자 ID 추가
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
