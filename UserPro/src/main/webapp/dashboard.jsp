
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<style type="text/css">
	
	body {
		padding: 25px;
	}

</style>




</head>
<body>


<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Student Entry</h3>
  </div>
  <div class="panel-body">

	<form:form action="processUser.html" method="post" modelAttribute="formData">
		<form:hidden path="id" id="id"/>
	
	  <div class="form-group">
	    <label for="name">Name</label>
	   
	    
	    <form:input path="name" id="name" cssClass="form-control"/>
	    
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Phone No</label>
	    <form:input path="phoneNo" id="phoneNo" cssClass="form-control"/>
	    
	    
	</div>
	   <div class="form-group">
	    <label for="dob">DOB</label>
	    <form:input path="dob" id="dob" cssClass="form-control"/>
	  </div>
	  <div class="form-group">
	    <label for="username">Username</label>
	  	<form:input path="username" id="username" cssClass="form-control"/>
	  </div>
	   <div class="form-group">
	    <label for="password">Password</label>
	  	<form:input path="password" id="password" cssClass="form-control"/>
	  </div>

	  <button type="submit" class="btn btn-default">Submit</button>
	
	</form:form>



	
  </div>
  
</div> 




<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">User List</h3>
  </div>
  <div class="panel-body">
  
  
  	<table class="table">
  		<thead>
  			<tr>
  				<th>ID</th>
  				<th>Name</th>
  				<th>Phone No</th>
  				<th>DOB</th>
  				<th>Edit</th>
  				<th>Delete</th>
  			</tr>
  		</thead>
  		<tbody>
  				<c:forEach items="${userList}" var="user">
  				<tr>
  					<td> <c:out value="${user.id}"></c:out> </td>
  					<td> ${user.name} </td>
  					<td> ${user.phoneNo} </td>
  					<td> ${user.dob} </td>
  					<td> <a href="editUser?id=${user.id}">Edit</a> </td>
  					<td> <a href="deleteUser?id=${user.id}">Delete</a> </td>
  				</tr>
  				</c:forEach>
  			
  			
  			
  			
  		
  		
  		</tbody>
  	</table>
  
  </div>
</div>


</body>
</html>