<%@include file="_head.jspf" %>
<%
	final QuizBean bean = (QuizBean) request.getAttribute("testBean");
	final String user = (String)session.getAttribute("user");
%>

<body>

<div class="box">
	<img src="klm.gif" width="100%" border="0" alt="The Team" />
	<p>&copy; by KLM Organizer e-Business and friends</p>
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
	<img src="RUP-Team-20080712.jpg" width="100%" border="0" alt="The Team" />
</div>

<p class="strong ">Certificate</p>

<p>
	<b>Your Manage My Skills Score</b>
</p>

<p>
	<p>Dynamic content starts here, to be filled in by server-side code</p>
	<p>Subject Selected for Testing</p>
	<p>Skill Level Selected for Testing</p>
	<p>Name: <%=user%></p>
	<p>Picture (=nice to have)</p>
	<p>Date, Time</p>
	<p>Duration (= nice to have)</p>
	<p class="strong">Your Score: 4</p>
	<p>1 to 5, 5 only when ALL answers correct, linear relation, except 1 is the minium!)</p>
	<p>Size the number of the relative to the score value</p>
</p>

<p>
	<form target="#" method="get"><input type="button" value="Print Certificate" onClick="window.print(); "/></form>
</p>

</body>

</html>