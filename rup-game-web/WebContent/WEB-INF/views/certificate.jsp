<%@include file="_head.jspf" %>
<%
	final java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm");
%>
<body>

	<div id="certificate_container">
	
		<div class="box">
			<p style="text-align: center;">
				<img src="img/klm.gif" width="320px" border="0" alt="KLM" />
			</p>
			<p style="text-align: center;">
				&copy; by KLM Organizer e-Business and friends
			</p>
		</div>
		
		<div class="box">
			<h2>The RUP Team - July 12, 2008</h2>
			<ul type='disc'>
				<li>Vincent Heijman, Business Executive
				<li>Anthony Ithurbure, Project Manager
				<li>Wim Veninga, Process Engineer and RUP Coach
				<li>Wesly Marlissa, Project Deployer
				<li>Joost Jorna, Software Architect and Requirements Specifier and Tester
				<li>Maciej Krysiuk, Software Developer
				<li>Luis Miranda, Software Developer
				<li>Maarten Franssen, Software Architect
				<li>Sebastiaan Veijgen, System Analyst and Requirements Specifier and Test Manager
				<li>Bayu Slamet, Software Architect and Tester and Gui Specialist
			</ul>
			<hr/>
			<p style="text-align: center;">
				<a href="img/RUP-team.jpg">
					<img src="img/RUP-team.jpg" width="300px" border="0" alt="The Team" />
				</a>
			</p>
		</div>
		
		<div id="certificate">
	
			<h1>Certificate</h1>
			
			<p>
				<table>
					<tr>
						<td class="label">Name</td>
						<td><c:out value="${sessionScope.user}"/></td>
					</tr>
					<tr>
						<td>Subject</td>
						<td><c:out value="${resultBean.subjectName}"/></td>
					</tr>
					<tr>
						<td>Skill level</td>
						<td><c:out value="${resultBean.skillLevelName}"/></td>
					</tr>
					<tr>
						<td>Date</td>
						<td><%=dateFormat.format(new java.util.Date())%></td>
					</tr>
					<tr>
						<td>Time elapsed</td>
						<td><c:out value="${resultBean.durationTime}"/></td>
					</tr>
					<tr>
						<td><strong>Score</strong></td>
						<td><strong><c:out value="${resultBean.result}"/></strong></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
				</table>
			</p>
			
			<hr/>
			<p>
				<input type="button" value="Print Certificate" onClick="window.print();"/>
			</p>

		</div>
	</div>
</body>

</html>