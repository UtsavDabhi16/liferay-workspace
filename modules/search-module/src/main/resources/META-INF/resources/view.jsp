<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="searchmodule.caption"/></b>
</p>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.searchservice.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.searchservice.service.StudentLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />
<%
	String currentURL = PortalUtil.getCurrentURL(request);
	List<Student>studentList = StudentLocalServiceUtil.getStudents(0, StudentLocalServiceUtil.getStudentsCount());
%>
<h3>Search Container in Liferay</h3>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:search-container var="searchContainer" delta="5" deltaConfigurable="true" emptyResultsMessage="Sorry. There are no record to display." iteratorURL="<%=iteratorURL %>">

	<liferay-ui:search-container-results results="<%= ListUtil.subList(studentList, searchContainer.getStart(), searchContainer.getEnd()) %>" />

	<%--  OR
           <liferay-ui:search-container-results
    results="<%= StudentLocalServiceUtil.getStudents(searchContainer.getStart(), searchContainer.getEnd()) %>"
    total="<%= StudentLocalServiceUtil.getStudentsCount() %>"
/> --%>

	<liferay-ui:search-container-row className="com.searchservice.model.Student" modelVar="student" keyProperty="studentId" >

		<portlet:renderURL var="rowURL">
			<portlet:param name="backURL" value="<%=currentURL %>" />
			<portlet:param name="studentId" value="${student.studentId}" />
			<portlet:param name="mvcPath" value="/student_detail.jsp"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="name" name="Student Name" href="${rowURL}"/>
		<liferay-ui:search-container-column-text  name="Sir Name">Mr. ${student.lastname}</liferay-ui:search-container-column-text>
<%--		<liferay-ui:search-container-column-text property="phone" name="<%=LanguageUtil.get(pageContext, \"phone\") %>"/>--%>

		<c:choose>
			<c:when test="${student.studentId <= '4'}">
				<liferay-ui:search-container-column-text cssClass="blue" property="std" name = "Class" />
			</c:when>
			<c:otherwise>
				<liferay-ui:search-container-column-text cssClass="green" property="std" name = "Class" />
			</c:otherwise>
		</c:choose>

		<liferay-ui:search-container-column-text name="Gender" value='<%=(student.getGender().equalsIgnoreCase("M"))?"Male":"Female"%>'/>
		<liferay-ui:search-container-column-jsp name="Address" align="left" path="/address.jsp"/>
		<liferay-ui:search-container-column-text href="${rowURL}" name="Detail" value="Click Here For Detail"/>

		<!-- For Delete URL  -->
		<portlet:actionURL var="deleteStudent" name="deleteStudent">
			<portlet:param name="backURL" value="<%=currentURL %>" />
			<portlet:param name="studentId" value="${student.studentId}" />
		</portlet:actionURL>
		<liferay-ui:search-container-column-text name="Delete Student" value="Delete"  href="${deleteStudent}"/>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
