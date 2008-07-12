<%@include file="_head.jspf"%>
<%
	final ViewBean bean = (ViewBean) request.getAttribute("viewBean");
	final String user = (String)session.getAttribute("user");
%>
<body>
	Hello <%=user%>

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
				<!--<input type="submit" value="Submit"> 
			--></fieldset>
		</form>
	</div>
</body>
</html>
