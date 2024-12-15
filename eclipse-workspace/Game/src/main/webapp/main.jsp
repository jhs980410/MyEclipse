<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>To-Do List</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 400px;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        ul li {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        ul li.completed {
            text-decoration: line-through;
            color: gray;
        }
        button {
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 12px;
        }
        button.complete {
            background-color: #28a745;
            color: white;
        }
        button.delete {
            background-color: #ff4136;
            color: white;
        }
        button:hover {
            opacity: 0.9;
        }
        .add-task {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 20px;
        }
        .add-task input {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        .add-task button {
            background-color: #007BFF;
            color: white;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>To-Do List</h1>
        <ul id="task-list">
            <!-- 할 일 목록이 여기에 추가됩니다 -->
        </ul>
        <div class="add-task">
            <input type="text" id="new-task" placeholder="Enter task description..." required>
            <input type="date" id="due-date" required>
            <input type="time" id="due-time" required>
            <button onclick="addTask()">Add Task</button>
        </div>
        <div style="text-align: center; margin-top: 20px;">
        <button onclick="viewSavedTasks()">View Saved Tasks</button>
    </div>
    </div>

    <script>
        // 할 일 목록 가져오기
        function fetchTasks() {
            fetch('/tasks')
                .then(response => response.json())
                .then(data => {
                    const taskList = document.getElementById('task-list');
                    taskList.innerHTML = ''; // 기존 항목 초기화
                    data.forEach(task => {
                        const li = document.createElement('li');
                        li.className = task.completed ? 'completed' : '';
                        li.innerHTML = `
                            <span>${task.content} (Due: ${task.due_date || ''} ${task.due_time || ''})</span>
                            <div>
                                <button class="complete" onclick="completeTask(${task.id})">Complete</button>
                                <button class="delete" onclick="deleteTask(${task.id})">Delete</button>
                            </div>
                        `;
                        taskList.appendChild(li);
                    });
                })
                .catch(err => console.error('Failed to fetch tasks:', err));
        }

        // 새로운 할 일 추가
        function addTask() {
            const taskContent = document.getElementById('new-task').value;
            const dueDate = document.getElementById('due-date').value;
            const dueTime = document.getElementById('due-time').value;

            if (!taskContent || !dueDate || !dueTime) {
                return alert('All fields are required.');
            }

            fetch('/tasks', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    content: taskContent,
                    due_date: dueDate,
                    due_time: dueTime
                })
            })
                .then(response => {
                    if (response.ok) {
                        fetchTasks(); // 목록 새로고침
                        document.getElementById('new-task').value = '';
                        document.getElementById('due-date').value = '';
                        document.getElementById('due-time').value = '';
                    } else {
                        throw new Error('Failed to add task');
                    }
                })
                .catch(err => console.error('Error adding task:', err));
        }

        // 할 일 완료 처리
        function completeTask(taskId) {
            fetch(`/tasks/${taskId}/complete`, { method: 'PUT' })
                .then(response => {
                    if (response.ok) {
                        fetchTasks(); // 목록 새로고침
                    } else {
                        throw new Error('Failed to complete task');
                    }
                })
                .catch(err => console.error('Error completing task:', err));
        }

        // 할 일 삭제
        function deleteTask(taskId) {
            fetch(`/tasks/${taskId}`, { method: 'DELETE' })
                .then(response => {
                    if (response.ok) {
                        fetchTasks(); // 목록 새로고침
                    } else {
                        throw new Error('Failed to delete task');
                    }
                })
                .catch(err => console.error('Error deleting task:', err));
        }
        function viewSavedTasks() {
            window.open('/viewTasks', '_blank'); // 새 탭으로 viewTasks 엔드포인트 호출
        }

        // 페이지 로드 시 할 일 목록 가져오기
        fetchTasks();
    </script>
</body>
</html>
