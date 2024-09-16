<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/lab02/register" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>


		<div class="container">
			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" id="username" required>
			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" id="password" required> 
			<label for="email"><b>Email</b></label> <input type="email"
				placeholder="Enter Email" name="email" id="email" required>
			<label for="fullname"><b>Fullname</b></label> <input type="text"
				placeholder="Enter Fullname" name="fullname" id="fullname" required>
			<label for="phone"><b>Phone</b></label> <input type="text"
				placeholder="Enter Phone" name="phone" id="phone" required>

			<button type="submit">Register</button>
			
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
		</div>
	</form>
</body>
</html>