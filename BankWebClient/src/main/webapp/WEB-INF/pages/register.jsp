<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Demo | Form</title>
<link rel="stylesheet" href="/css/form.css" type="text/css" />

</head>
<body>
	<div id="registration-form">
		<form action="/validateRegistrationForm">
				<table>
					<tr>
						<td><input type="text" name="username" required placeholder="Username"></td>
					</tr>
					<tr> 
						<td><input type="password" name="password" required placeholder="Password"></td>
					</tr>
					<tr>
						<td><input type="password" name="confirmPassword" required placeholder="Same as Password"></td>
					</tr>
					<tr>
						<td><div  class="formDivs"><input type="reset" value="Reset" /></div></td>
					</tr>
					<tr>	
						<td><div  class="formDivs"><input type="submit" value="Submit" /></div></td>
					</tr>
				</table>
		</form>
	</div>
</body>
</html>