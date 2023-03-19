<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Реєстрація</title>
    <style>
        h1 {
            text-align: center;
        }
        form {
            alignment: center;
            width: 400px;
            margin: 0 auto;
        }
        label, input {
            display: block;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #3e8e41;
        }
    </style>
</head>
<body>
<h1>Реєстрація</h1>
<form action="register" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Password</label>
    <input type="password" id="password" name="password" required>

    <label for="confirm-password">Confirm Password</label>
    <input type="password" id="confirm-password" name="confirm-password" required>

    <label for="email">E-mail</label>
    <input type="email" id="email" name="email" required>

    <input type="submit" value="Sign Up">
</form>
</body>
</html>
