<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>Login page</h1>
	
		<p>ID</p>
		<input type='text' id = 'userId' placeholder='Please Write Your ID'>
		
		<p>PW</p>
		<input type='password' id = 'userPw' placeholder='****'>
		
		<input type = 'button' value='login' id = 'login' onclick='loginSend()'>
		<input type = 'button' value='SignUp' id = 'SignUp' onclick='signUpSend()'>
		
<script>
function loginSend() {
    var userId = $('#userId').val();
    var userPw = $('#userPw').val();

    // 사용자 ID와 비밀번호가 비어 있지 않으면 서버에 요청을 보냄
    if (userId && userPw) {
        $.ajax({
            url: '/test/memberController',  // 서버의 로그인 엔드포인트
            type: 'POST',
            dataType: 'json',
            data: {
                id: userId,
                password: userPw,
                action: 'login'
            },
            success: function(response) {
                if (response.success) {
                    alert('Login successful !');
                } else {
                    alert('Login failed' +  response.message);
                }
            },
            error: function(xhr, status, error) {
                console.log('errorCode: ', error);
                alert('login error.');
            }
        });
    } else {
        alert('id and pw insert.');
    }
}
function signUpSend() {
    var userId = $('#userId').val();
    var userPw = $('#userPw').val();

    if (userId && userPw) {
        $.ajax({
            url: '/test/memberController',  // 서버의 회원가입 엔드포인트
            type: 'POST',
            dataType: 'json',
            data: {
                id: userId,
                password: userPw,
                action: 'signup'
            },
            success: function(response) {
                if (response.success) {
                    alert('sign up success !');
                } else {
                    alert('Failed to join !');
                }
            },
            error: function(xhr, status, error) {
                console.log('errorCode: ', error);
                console.log('responseText: ', xhr.responseText);
                alert('error qkftod');
            }
        });
    } else {
        alert('id,pw Enter it ');
    }
}

</script>
</body>
</html>

