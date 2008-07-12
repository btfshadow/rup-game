<%@include file="_head.jspf" %>
<%
	final QuizBean bean = (QuizBean) request.getAttribute("testBean");
	final String user = (String)session.getAttribute("user");
%>
<body>
	Hello <%=user%>
	<h2>Test</h2>
	
	<p>
		<!-- <a href="welcome.htm">Back to subject list</a> -->
	</p>
	
	<% if (bean.getQuestions().size() == 0)  {%>
		<p>
			This subject does not exist or contains no questions.
		</p>
	<% } else { %>
	
		<form:form commandName="testBean">
			<ol>
				<c:forEach items="${testBean.questions}" var="q">
					<li>
						<c:out value="${q.description}"/>
						<ul>
						<c:forEach items="${q.answers}" var="answ">
							<li>
								<form:checkbox path="userAnswer" />
								<c:out value="${answ.text}"/>
							</li>
						</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ol>
		
			<p>
				<input type="submit" value="Show the score"/>
			</p>
		</form:form>
	<% } %>
	
</body>
</html>