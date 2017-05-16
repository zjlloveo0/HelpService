<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body>
	<form action="reg" method="post">
		name<input type="text" name="name"><br> 
		phone<input type="text" name="phone"><br> 
		password<input type="password" name="password"><br>
		stuNum<input type="text" name="stuNum"><br> 
		Point<input type="text" name="point"><br> 
		collegeId<input type="text" name="collegeId"><br>
		star<input type="text" name="star"><br> 
		isEnable<input type="text" name="isEnable"><br> 
		<input type="submit" value="确认">
	</form>
	<img src="/HelpService/static/errorpage/img/11.jpg">
</body>
</html>