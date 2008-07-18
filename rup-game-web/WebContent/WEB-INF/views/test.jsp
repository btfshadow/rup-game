<%@include file="_head.jspf" %>
<%
	final QuizBean bean = (QuizBean) request.getAttribute("testBean");
%>
<body>
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
				<c:forEach items="${testBean.questions}" var="q" varStatus="qi">
					<li>
						<div class="question">
							<c:out value="${q.text}"/>
						</div>
						<ul>
						<c:forEach items="${q.answers}" var="answ" varStatus="ai">
							<li>
								<form:checkbox path="questions[${qi.index}].answers[${ai.index}].userinput" value="true"/>
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