<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Page</title>
</head>
<body>
		
		<div id="header"><h1>Update Student</h1></div>
		<div id="stripe"></div>
	<form action="Student_ManagerController" method="GET">
		
		<input type="hidden" name="command" value="UPDATE"/>
		<table>
			<tr>
			<td><label>Registration Number:</label></td>
			<td><input type="text" name="regNumber" value="${THESTUDENT.regNumber}" /></td>
			</tr>
			<tr>
			<td><label>First Name:</label></td>
			<td><input type="text" name="firstName" value="${THESTUDENT.firstName}" /></td>
			</tr>
			<tr>
			<td><label>Other Names:</label></td>
			<td><input type="text" name="OtherNames" value="${THESTUDENT.otherNames}" /></td>
			</tr>
			<tr>
			<td><label>Level:</label></td>
				<td>
					<select id="theLevel" name="level" >
						<option value="advanced">A</option>
						<option value="ordinary">O</option>
					</select>
				</td>
			</tr>
			<tr>
			<td><label>Class:</label></td>
				<td>
					<select id="theClass" ></select>
				</td>
			</tr>
			<tr>
			<td><label>Stream:</label></td>
			<td><input type="text" name="stream" value="${THESTUDENT.stream}" /></td>
			</tr>
			<tr>
			<td><label>Sex:</label></td>
			<td>
				<select id="theGender">
						<option value="${THESTUDENT.gender}">F</option>
						<option value="${THESTUDENT.gender}">M</option>
					</select>
			</td>
			</tr>
			<tr>
			<td><label>Book Title:</label></td>
			<td><input type="text" name=bookTitle value="${THESTUDENT.bookTitle}" /></td>
			</tr>
			<tr>
			<td><label>Issued Out:</label></td>
			<td><input type="date" name="issueOut" value="${THESTUDENT.issueOut}" /></td>
			</tr>
			
			<tr>
			<td><input type="submit"  value="save"></td>
			</tr>
			
		</table>
		<a href="Student_ManagerController">Back to List</a>
	</form>
	
	<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function(){
		const theLevelElement = document.getElementById("theLevel");
		const myClassDropDown = document.getElementById("theClass");
		
		function updateElement(){
			const theLevelValue = theLevelElement.value;
			myClassDropDown.innerHTML ="";
			if(theLevelValue==="advanced"){
				
				const optionA = document.createElement("option");
				optionA.value= "classFive";
				optionA.text= "S.5"
				myClassDropDown.appendChild(optionA);
				
				const optionB = document.createElement("option");
				optionB.value= "classSix";
				optionB.text= "S.6"
				myClassDropDown.appendChild(optionB);
								
			}else{
				
				const option1 = document.createElement("option");
				option1.value= "classOne";
				option1.text= "S.1"
				myClassDropDown.appendChild(option1);
				
				const option2 = document.createElement("option");
				option2.value= "classTwo";
				option2.text= "S.2"
				myClassDropDown.appendChild(option2);
				
				const option3 = document.createElement("option");
				option3.value= "classThree";
				option3.text= "S.3"
				myClassDropDown.appendChild(option3);
				
				const option4 = document.createElement("option");
				option4.value= "classFour";
				option4.text= "S.4"
				myClassDropDown.appendChild(option4);
				
				}
			}
			updateElement();
			theLevelElement.addEventListener("change", updateElement)
		});
</script>
</body>
</html>