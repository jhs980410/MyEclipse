package model;

import java.sql.Date;
import java.sql.Time;

public class Task {
    private int id;
    private String content;
    private boolean completed;
    private Date dueDate; // 마감일
    private Time dueTime; // 마감 시간
    private int userId;

    public Task(int id, String content, boolean completed, Date dueDate, Time dueTime,int userId) {
        this.id = id;
        this.content = content;
        this.completed = completed;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.userId=userId;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Time getDueTime() {
        return dueTime;
    }

    public void setDueTime(Time dueTime) {
        this.dueTime = dueTime;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

