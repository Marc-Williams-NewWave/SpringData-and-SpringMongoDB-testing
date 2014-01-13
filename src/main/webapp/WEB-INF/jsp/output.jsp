<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!-- <link rel="stylesheet" href="css/bootstrap.css"  type="text/css"/> -->
<link
	href="http://bootswatch.com/flatly/bootstrap.min.css"
	rel="stylesheet">
<body>
	<h2>Here is a simple CRUD using Spring MVC and MongoDB</h2>
	<form action="person/save" method="post">
		<input type="hidden" name="id"> 
		
		<label for="firstName">First Name</label> 
		<input type=text id="firstName" name="firstName"> 
		
		<label for="lastName">Last Name</label>
		<input type="text" id="lastName" name="lastName">		
		
		<label for="accountBalance">Account Balance $</label>
		<input type="text" id="accountBalance" name="accountBalance">	
		
		<label for="userBio">User Bio</label>
		<input type="text" id="userBio" name="userBio">	
		
		
		<input type=submit value="Submit">
	</form>

	<table class="table table-striped table-bordered table-hover" style="width: 50% !important;">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Account Balance</th>
				<th>User Bio</th>
				<th>Delete User</th>
			</tr>
		</thead>
		<c:forEach var="person" items="${personList}">
			<tr>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>$${person.accountBalance}</td>
				<td><input type="button" value="View Bio" onclick="window,location='person/profile?id=${person.id}'"></td>
				<td><input type="button" value="delete" onclick="window.location='person/delete?id=${person.id}'" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>