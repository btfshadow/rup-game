<%@include file="_head.jspf"%>
<body>

	<h2>Welcome to Manage My Skills</h2>

	<div>
		<form:form commandName="userBean">
			<fieldset>
				<legend>
					Please fill in your name.
				</legend> 
	
				<div class="form_row">
					<label for="name">Name</label>
					<form:input path="name"/>
				</div>

				<div class="form_row">
					<label for="surname">Surname</label>
					<form:input path="surname"/> 
				</div>

				<div class="form_row">
					<label>&nbsp;</label>
					<input type="submit" value="Start"/> 
				</div>

				
			</fieldset>
		</form:form>
	</div>
</body>
</html>
