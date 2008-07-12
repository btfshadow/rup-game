<%@include file="_head.jspf"%>
<%
	final ViewBean bean = (ViewBean) request.getAttribute("viewBean");
%>
<body>
	<h2>Available subjects</h2>
	
	<div>
		<form name="subjectform" action="#" method="post">
			<fieldset>
				<legend>Choose a subject</legend>
				<ul>
				<% for (int i = 0; i < bean.getSubjectList().size(); i++) {
					final Subject subject = (Subject) bean.getSubjectList().get(i);
				%>
					<li>
						<a href="test.htm?subjectId=<%=subject.getId()%>">
							<%=subject.getName()%>
						</a>
					</li>
				<% } %>
				</ul>
				<hr/>
				<!--<label for="weather">Weather</label>
				<input type="radio" name="weather" value="S">
				<label for="music">Music</label>
				<input type="radio" name="music" value="Music">
				<label for="sports">Sports</label>
				--><a href="test.htm">
					Sports
				</a><br/>
				<a href="test.htm">
					Music
				</a>
				<!--<input type="submit" value="Submit"> 
			--></fieldset>
		</form>
	</div>
</body>
</html>
