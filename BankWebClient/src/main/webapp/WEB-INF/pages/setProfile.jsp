<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/form.css" type="text/css" />
</head>
<body>
	<div id="registration-form">
		<div id="formHeader">
			<h5>Set Profile Details</h5>
		</div>
		<form action="/saveDetails">

			<table>
				<tr>
					<th>Login_id</th>
					<td><input type="text" name="login_id" readonly="readonly" value=${login_id} ></td>
				</tr>

				<tr>
					<th>Name</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>HouseNo</th>
					<td><input type="text" name="house_no"></td>
				</tr>
				<tr>
					<th>Street</th>
					<td><input type="text" name="street"></td>
				</tr>
				<tr>
					<th>city</th>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<th>state</th>
					<td><input type="text" name="state"></td>
				</tr>
				<tr>
					<th>Country</th>
					<td><input type="text" name="country"></td>
				</tr>
				<tr>
					<th>NearBy</th>
					<td><input type="text" name="near_by"></td>
				</tr>
				<tr>
					<th>AreaCode</th>
					<td><input type="text" name="area_code"></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>Mobile No</th>
					<td><input type="text" name="phoneno"></td>
				</tr>
				<tr>
					<td><div class="formDivs"><input type="reset" value="Reset"></div></td>
					<td><div class="formDivs"><input type="submit" value="Submit"></div></td>
				</tr>
			</table>
		

		</form>
	</div>
</body>
</html>