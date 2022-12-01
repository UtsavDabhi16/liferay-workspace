<%@page import="com.searchservice.model.Student"%>
<%@page import="com.searchservice.service.StudentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
    String redirect = ParamUtil.getString(request, "backURL");
    int studentId = ParamUtil.getInteger(request, "studentId");
    Student student = StudentLocalServiceUtil.getStudent(studentId);
    request.setAttribute("student", student);
%>

<h1>Student Information</h1>
<h3>Name : ${student.name}  ${student.lastname} </h3>
<h3>Phone :${student.phone}</h3>
<h3>Class :${student.std}</h3>
<h3>Address :${student.address}</h3>
<br><br>
<a href="<%= redirect %>">Back to All</a>