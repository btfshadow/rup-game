<%@include file="_head.jspf" %>
<%
	final QuizBean bean = (QuizBean) request.getAttribute("testBean");
%>
<body>
	<h2>Test</h2>

	<form:form commandName="testBean">
		<ol>
			<% for (java.util.Iterator iter = bean.getQuestions().iterator(); iter.hasNext();) {
				final Question question = (Question) iter.next();
			%>
				<li>
					<%=question.getDescription()%>
					<ul>
					<% for (java.util.Iterator iterAnsw = question.getAnswers().iterator(); iterAnsw.hasNext();) {
						final Answer answer = (Answer) iterAnsw.next();
					%>
						<li>
							<input type="checkbox"/ value=<%=answer.getText()%>> <%=answer.getText()%>
						</li>
					<% } %>
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