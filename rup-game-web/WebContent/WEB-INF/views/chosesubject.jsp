<%@include file="_head.jspf"%>
<body>
	<div>
	<h1>Subject</h1>
	</div>
	<div>
		<form name="subjectform" action="#" method="post">
			<fieldset>
				<legend>Choose a subject</legend> 
				<label for="weather">Weather</label>
				<input type="radio" name="weather" value="S">
				<label for="music">Music</label>
				<input type="radio" name="music" value="Music">
				<label for="sports">Sports</label>
				<input type="radio" name="sports" value="Sports">
				<input type="submit" value="Submit"> 
			</fieldset>
		</form>
	</div>
</body>
</html>
