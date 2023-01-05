<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="liferaydemo.caption"/></b>
</p>

<portlet:actionURL var="userCSVDataUploadURL" name="userCSVDataUpload"></portlet:actionURL>

<form action="${userCSVDataUploadURL}" enctype="multipart/form-data" method="post" id="csvDataFileForm">
	<div>
		<label>Upload User Data CSV :</label>
		<input type="file" name='<portlet:namespace/>csvDataFile' id="csvDataFile"></input>
	</div>
	<div>
		<input type="submit"></input>
	</div>
</form>

<br><br>

<portlet:resourceURL var="exportCSVURL">
	<portlet:param name="export" value="exportCSV" />
</portlet:resourceURL>

<h4>Data Export as CSV in Liferay Portlet</h4>
<div>
	<a href="${exportCSVURL}">Export</a>
</div>
