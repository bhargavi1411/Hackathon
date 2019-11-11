<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="LoginServlet" method = "GET">

			Please enter your username 		
			<input type="text" name="un"/><br>		
		
			Please enter your password
			<input type="text" name="pw"/>
			
			Please enter your account type to view the transactions
			<input type="text" name="at"/>
			
			<input type="submit" value="submit">			
		
		</form>
</body>
</html>