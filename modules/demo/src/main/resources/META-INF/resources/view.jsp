
<%@ include file="/init.jsp" %>

<portlet:renderURL var="editEntryURL">
	<portlet:param name="mvcRenderCommandName" value="/demo" />
</portlet:renderURL>

<p>
	<b><liferay-ui:message key="demomodule.caption"/></b>

<a href="${editEntryURL}">Click Here</a>

</p>

