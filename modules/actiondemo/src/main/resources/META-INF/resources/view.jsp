<%@ include file="/init.jsp" %>

<portlet:actionURL name="addEntry" var="addEntryURL" />

<aui:form action="<%= addEntryURL %>"  method="POST">

	<aui:fieldset>
		<aui:input name="name"></aui:input>
		<aui:input name="message"></aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" name="" value="Submit"></aui:button>
	</aui:button-row>

</aui:form>

<jsp:useBean id="entries" class="java.util.ArrayList" scope="request"/>

<liferay-ui:search-container>
	<liferay-ui:search-container-results results="<%= entries %>" />

	<liferay-ui:search-container-row
			className="com.actiondemo.model.Entry"
			modelVar="entry"
	>
		<liferay-ui:search-container-column-text property="message" />

		<liferay-ui:search-container-column-text property="name" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

