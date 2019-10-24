
<!DOCTYPE html>
<html>
<head>
<title>JavaScript Loan Calculator</title>
</head>
<link rel="stylesheet" href="/css/form.css" type="text/css" />
<body bgcolor="gray">
	<div id="registration-form">
		<div id="formHeader">
			<h5>Mortgage Calculator</h5>
		</div>
		<form name="loandata">
			<table>
				<tr>
					<td colspan="3"><b>Enter Loan Information:</b></td>
				</tr>
				<tr>
					<td>1)</td>
					<td>Amount of the loan (any currency):</td>
					<td><input type="text" name="principal" size="12"
						onchange="calculate();"></td>
				</tr>
				<tr>
					<td>2)</td>
					<td>Annual percentage rate of interest:</td>
					<td><input type="text" name="interest" size="12"
						onchange="calculate();"></td>
				</tr>
				<tr>
					<td>3)</td>
					<td>Repayment period in years:</td>
					<td><input type="text" name="years" size="12"
						onchange="calculate();"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" value="Compute"
						onclick="calculate();"></td>
				</tr>
				<tr>
					<td colspan="3"><b>Payment Information:</b></td>
				</tr>
				<tr>
					<td>4)</td>
					<td>Your monthly payment will be:</td>
					<td><input type="text" name="payment" size="12"></td>
				</tr>
				<tr>
					<td>5)</td>
					<td>Your total payment will be:</td>
					<td><input type="text" name="total" size="12"></td>
				</tr>
				<tr>
					<td>6)</td>
					<td>Your total interest payments will be:</td>
					<td><input type="text" name="totalinterest" size="12"></td>
				</tr>
			</table>
		</form>
	</div>
	<script language="JavaScript">
function calculate() {
   
    var principal = document.loandata.principal.value;
    var interest = document.loandata.interest.value / 100 / 12;
    var payments = document.loandata.years.value * 12;

    var x = Math.pow(1 + interest, payments);
    var monthly = (principal*x*interest)/(x-1);

    if (!isNaN(monthly) &&
        (monthly != Number.POSITIVE_INFINITY) &&
        (monthly != Number.NEGATIVE_INFINITY)) {

        document.loandata.payment.value = round(monthly);
        document.loandata.total.value = round(monthly * payments);
        document.loandata.totalinterest.value =
            round((monthly * payments) - principal);
    }
   
    else {
        document.loandata.payment.value = "";
        document.loandata.total.value = "";
        document.loandata.totalinterest.value = "";
    }
}

function round(x) {
  return Math.round(x*100)/100;
}
</script>
	<a href="/home">Home</a>
</body>
</html>
