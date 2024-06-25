<%@page import="javax.swing.JCheckBox"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, com.Libray.manager.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>


<link  href ="MyLayouts.css" rel="stylesheet" type="text/css" >
</head>

<body>


	<div id="wrapper">
		<div id="header"><h1>My Library Center</h1></div>
		<div id="stripe"></div>
			
		<table>
			<tr>
			
				<th>Reg Number</th>
				<th>First Name</th>
				<th>Other Names</th>
				<th>Level</th>
				<th>Class</th>
				<th>Stream</th>
				<th>Sex</th>
				<th>Book Title</th>
				<th>Issued Out </th>
				<th>Issued In</th>
				<th>Status</th>	
				<th>check</th>
				<th>Action</th>
				
			</tr>
			<c:forEach var="theStudent" items="${MyStudentList}">
			<tr>
			<c:url var="servletLink" value="Student_ManagerController">
				<c:param name="command" value="LOAD"></c:param>
				<c:param name="regNumber" value="${theStudent.regNumber}"></c:param>
			
			</c:url>
	
				
				<td>${theStudent.regNumber} </td>
				<td>${theStudent.firstName} </td>
				<td>${theStudent.otherNames} </td>
				<td>${theStudent.level} </td>
				<td>${theStudent.studyClass} </td>
				<td>${theStudent.stream} </td>
				<td>${theStudent.gender} </td>
				<td>${theStudent.bookTitle} </td>
				<td>${theStudent.issueOut} </td>
				<td>${theStudent.issueIn} </td>
				<td>${theStudent.status} </td>
				
				<td> <input  type="checkbox" id="myCheckBox" ></td>
				<td><a href="${servletLink}">Update</a></td>
			</tr>
			
			
			</c:forEach>
		</table>
		<input type="button"  value="ADD STUDENT" onclick="window.location.href='Add_Student_Form.jsp'; return false;"/>
	</div>






<script type="text/javascript">

		function handleEvent(){
			var checkBox = document.getElementById("myCheckBox");
			var isChecked = checkBox.checked;
			var row = checkBox.closest('tr');
			var regNumber = row.dataSet.regNumber;
			
			let XHRequest = new XMLHttpRequest();
			XHRequest.open("POST", "Student_ManagerController");
			XHRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); // error right here
			XHRequest.onload = function(){
				if(XHRequest.status === 200){ 
					console.log("Data Succesfulley updated")
				}else{ 
					console.log("Error Occured!")
					}
			}	
			XHRequest.send("isChecked=" + isChecked+ "&regNumber="+ regNumber);
		}
		document.getElementById("myCheckBox").addEventListener("click", handleEvent);
</script>
</body>
</html>