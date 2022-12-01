<%@ page import="democrudservice.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="democrudservice.service.StudentLocalServiceUtil" %>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<%
	String currentURL = PortalUtil.getCurrentURL(request);
	PortletURL portletURL = renderResponse.createRenderURL();
	SearchContainer<Student> studentSearchContainer= new SearchContainer<Student>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 4, portletURL, null, null);
	List<Student> studentList = StudentLocalServiceUtil.getStudents(studentSearchContainer.getStart(), studentSearchContainer.getEnd());
	String cur = Integer.toString(studentSearchContainer.getCur());
	String delta = Integer.toString(studentSearchContainer.getDelta());
	int	totalSize = StudentLocalServiceUtil.getStudentsCount();
%>
<%--<%  List<Student> studentList = (List<Student>)request.getAttribute("studentList"); %>--%>
<portlet:renderURL var="addStudentRenderURL">
	<portlet:param name="mvcPath" value="/add-student.jsp"/>
</portlet:renderURL>

<div class="mb-5">
	<a href="<%= addStudentRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add Student
	</a>
</div>

<%--<liferay-ui:search-container  delta="4">--%>
<%--	<liferay-ui:search-container-results  results="<%= studentList  %>" />--%>
<%--	<liferay-ui:search-container-row className="democrudservice.model.Student" modelVar="employeeObj">--%>
<%--		<liferay-ui:search-container-column-text property="firstName" />--%>
<%--		<liferay-ui:search-container-column-text property="lastName" />--%>

<%--		<!-- For Delete URL  -->--%>
<%--		<portlet:actionURL var="deleteRecord" name="deleteRecord">--%>
<%--			<portlet:param name="backURL" value="<%=currentURL %>" />--%>
<%--			<portlet:param name="studentId" value="${employeeObj.studentId}" />--%>
<%--			<portlet:param name="cur" value="<%=cur %>" />--%>
<%--			<portlet:param name="delta" value="<%=delta %>" />--%>
<%--		</portlet:actionURL>--%>
<%--		<liferay-ui:search-container-column-text name="Delete Record" value="Delete"  href="${deleteRecord}"/>--%>

<%--	</liferay-ui:search-container-row>--%>

<%--	<liferay-ui:search-iterator />--%>
<%--</liferay-ui:search-container>--%>

<table class="table table-striped">
	<tr >
		<th>Enrollment No</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Contact No</th>
		<th>City</th>
		<th colspan="2" style="width: 100px">Action</th>
	</tr>
	<c:forEach items="${studentList}" var="student">

		<portlet:renderURL var="updateStudentRenderURL">
			<portlet:param name="mvcPath" value="/update-student.jsp"/>
			<portlet:param name="enrollmentNo" value="${student.enrollmentNo}"/>
			<portlet:param name="firstName" value="${student.firstName}"/>
			<portlet:param name="lastName" value="${student.lastName}"/>
			<portlet:param name="contactNo" value="${student.contactNo}"/>
			<portlet:param name="city" value="${student.city}"/>
			<portlet:param name="studentId" value="${student.studentId}"/>
		</portlet:renderURL>

		<portlet:actionURL name="deleteStudent" var="deleteStudentActionURL">
			<portlet:param name="studentId" value="${student.getStudentId()}"/>
		</portlet:actionURL>

		<tr>
			<td>${student.getEnrollmentNo()}</td>
			<td>${student.getFirstName()}</td>
			<td>${student.getLastName()}</td>
			<td>${student.getContactNo()}</td>
			<td>${student.getCity()}</td>
			<td class="text-center" style="width: 50px">
				<a href="<%=updateStudentRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
					<i class ="glyphicon glyphicon-edit"></i>edit
				</a>
			</td>
			<td class="text-center" style="width:50px">
				<a href="<%=deleteStudentActionURL%>"
				   class="btn  btn-primary btn-danger btn-sm px-2 py-1"
				   onclick="return confirm('Are you sure you want to delete this item?');">
					<i class ="glyphicon glyphicon-remove"></i>delete
				</a>
			</td>
		</tr>
	</c:forEach>
</table>

