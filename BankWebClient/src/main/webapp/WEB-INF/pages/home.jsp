<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
}
</style>
</head>
<body>
	<h1>Hello</h1> 
	<a href="/loan">Check For Loan</a><br><br>
	<a href="/existingLoan?cust_id=${cust_id}">Existing Loan</a><br><br>
	<a href="/martgageCalc">Mortgage Calculator</a><br><br>
</body>
</html>