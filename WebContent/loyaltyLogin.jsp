<!DOCTYPE html>

<html>
<body>
	<form method="POST" action="doLogin">


		<div class="container">
			<label><b>Card number</b></label> <input type="text"
				placeholder="Enter card number" name="cardNumber" required>

			<label><b>Card code</b></label> <input type="text"
				placeholder="Enter card code" name="cardCode" required>

			<button type="submit" class="signupbtn">Send</button>
		</div>

	</form>


	<%
	String errorString = (String) request.getAttribute("errorString");
%>
	<div>${errorString}</div>
</body>
</html>