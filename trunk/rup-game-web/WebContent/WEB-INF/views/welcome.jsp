<%@include file="_head.jspf"%>
<body>
	<div>
	<h1>Welcome to RUP Game</h1>
	</div>
	<div>
		<form name="logform" action="#" method="post">
			<fieldset>
				<legend>Please fill in your name.</legend> 
				<label for="name">Name</label>
				<input type="text" name="name"> <br/>
				<label for="surname">Surname</label>
				<input type="text" name="surname"> 
				<input type="submit" value="Submit"> 
			</fieldset>
		</form>
	</div>
	<!--<p>Number of domain objects found: <strong><c:out
		value="${viewBean.objectsCount}" /></strong></p>
	-->
</body>
</html>
