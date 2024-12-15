<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9; /* 배경색 */
        }
        form {
            text-align: left;
            display: flex;
            flex-direction: column;
            gap: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            background-color: white;
            width: 320px; /* 폼 너비 */
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            display: flex;
            flex-direction: column;
        }
        .form-group label {
            margin-bottom: 5px;
            font-size: 14px;
            color: #555;
        }
        .form-group input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        button {
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007BFF;
            color: white;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        button.signup {
            background-color: #28a745; /* 녹색 버튼 */
        }
        button:hover {
            opacity: 0.9;
        }

        /* 모달 스타일 */
        .modal {
            display: none; /* 기본적으로 숨김 */
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }
        .modal-content {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            width: 300px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
        }
        .modal-content h2 {
            text-align: center;
        }
        .modal-content .form-group {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <form id="loginForm">
        <h1>Login</h1>
        <div class="form-group">
            <label for="userId">ID:</label>
            <input type="text" id="userId" name="userId" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="button" onclick="login()">Login</button>
        <button type="button" class="signup" onclick="showSignUpModal()">Sign Up</button>
    </form>

    <!-- 회원가입 모달 -->
    <div id="signupModal" class="modal">
        <div class="modal-content">
            <h2>Sign Up</h2>
            <div class="form-group">
                <label for="signupId">ID:</label>
                <input type="text" id="signupId" name="signupId" required>
            </div>
            <div class="form-group">
                <label for="signupPassword">Password:</label>
                <input type="password" id="signupPassword" name="signupPassword" required>
            </div>
            <button type="button" onclick="signUp()">Submit</button>
            <button type="button" onclick="closeSignUpModal()">Cancel</button>
        </div>
    </div>

    <script>
        // 로그인 요청 함수
        function login() {
            const userId = document.getElementById('userId').value;
            const password = document.getElementById('password').value;

            fetch('login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ userId, password }),
            })
                .then((response) => response.json())
                .then((data) => {
                    if (data.success) {
                        alert('Login successful!');
                        window.location.href = 'main.jsp';
                    } else {
                        alert('Invalid ID or Password.');
                    }
                })
                .catch((error) => {
                    console.error('Error:', error);
                    alert('An error occurred during login.');
                });
        }

        // 회원가입 요청 함수
        function signUp() {
            const userId = document.getElementById('signupId').value;
            const password = document.getElementById('signupPassword').value;

            fetch('signup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ userId, password }),
            })
                .then((response) => response.json())
                .then((data) => {
                    if (data.success) {
                        alert('Sign up successful! Please log in.');
                        closeSignUpModal();
                    } else {
                        alert('Sign up failed. ID might already exist.');
                    }
                })
                .catch((error) => {
                    console.error('Error:', error);
                    alert('An error occurred during sign up.');
                });
        }

        // 모달 표시
        function showSignUpModal() {
            document.getElementById('signupModal').style.display = 'flex';
        }

        // 모달 닫기
        function closeSignUpModal() {
            document.getElementById('signupModal').style.display = 'none';
        }
    </script>
</body>
</html>
