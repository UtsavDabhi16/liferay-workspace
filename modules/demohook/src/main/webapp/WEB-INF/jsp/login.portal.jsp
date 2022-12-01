<%--
  Created by IntelliJ IDEA.
  User: root318
  Date: 07/11/22
  Time: 11:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>

<liferay-util:buffer var="html">
    <liferay-util:include page="/html/portal/j.login.jsp" />
</liferay-util:buffer>
<h1> hello </h1>
<%
    html = StringUtil.add(
            "Stuff I'm adding BEFORE the original content",
            html,
            "\n");

    html = StringUtil.add(
            html,
            "Stuff I'm adding AFTER the original content",
            "\n");
%>
<%= html %>

