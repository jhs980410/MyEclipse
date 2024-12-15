package model;

public class User {
    private int id; // 추가된 필드
    private String userId;
    private String password;

    // 기존 생성자
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // 새로운 생성자 추가
    public User(int id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

