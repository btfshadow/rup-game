<%@include file="_head.jspf"%>
<%
	final java.util.List subjectList = (java.util.List) request.getAttribute("subjectList");
	//final String user = (String)session.getAttribute("user");
	System.out.println(subjectList);
%>
<body>

	<h2>Available subjects</h2>
	
	<div>
		<form name="subjectform" action="#" method="post">
			<fieldset>
				<legend>Choose a subject</legend>
				<ul>
				<% for (int i = 0; i < subjectList.size(); i++) {
					final Subject subject = (Subject) subjectList.get(i);
				%>
					<li>
						<a href="test.htm?subjectId=<%=subject.getId()%>">
							<%=subject.getName()%>
						</a>
					</li>
				<% } %>
				</ul>
				<hr/>
			</fieldset>
		</form>
	</div>
</body>
</html>
