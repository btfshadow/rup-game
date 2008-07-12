<%@include file="_head.jspf" %>
<%
	final String[] questionList = new String[10];
	request.setAttribute("questionList", questionList);
%>
<body>
	<h2>Test</h2>

	<form:form commandName="testBean">
		<ol>
			<% for (int i = 0; i < questionList.length; i++) { %>
				<li>
					What do you think the weather will be like tomorrow?
					<ul>
						<li>
							<input type="checkbox"/> Rainy
						</li>
						<li>
							<input type="checkbox"/> Sun
						</li>
						<li>
							<input type="checkbox"/> Snow
						</li>
					</ul>
				</li>
			<% } %>
		</ol>
	
		<p>
			<input type="submit" value="Show the score"/>
		</p>
	</form:form>
	
</body>
</html>