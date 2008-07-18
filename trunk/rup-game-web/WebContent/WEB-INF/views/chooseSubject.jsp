<%@include file="_head.jspf"%>
<body>

	<h2>Available subjects</h2>
	
	<div>
		<form name="subjectform" action="#" method="post">
			<fieldset>
				<legend>Choose a subject</legend>
				<ul>
					<c:forEach items="${subjectList}" var="subject">
						<li>
							<span class="subject">
								<c:out value="${subject.name}"/>
							</span>
							<c:forEach items="${skillList}" var="skill">
								[<a href="test.htm?subjectId=<c:out value='${subject.id}'/>&skillId=<c:out value='${skill.level}'/>">
									<c:out value="${skill.name}"/>
								</a>]
							</c:forEach>
						</li>
					</c:forEach>
				</ul>
				<hr/>
			</fieldset>
		</form>
	</div>
</body>
</html>
