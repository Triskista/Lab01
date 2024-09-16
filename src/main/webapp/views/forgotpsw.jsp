<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/lab02/forgotpsw" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<div class="container">
			<label for="email"><b>Email</b></label> <input type="email"
				placeholder="Enter email" name="email" required> <label
				for="newpsw"><b>New Password</b></label> <input type="text"
				placeholder="Enter new password" name="newpsw" required>
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>