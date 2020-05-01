<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Files Upload Screen</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/common/styles.css">

</head>
<body>
    <div id="wrapper">

        <h1>Files Upload Screen</h1>

        <t:messagesPanel />

        <form:form action="${pageContext.request.contextPath}/upload/multiple" method="post"
            enctype="multipart/form-data" modelAttribute="filesUploadForm">
            <form:hidden path="employeeId" value="${employeeId}" />
			
            <%-- file 1 --%>
            <form:label path="uploadUploadForms[0].file">Profile Picture</form:label> : 
            <form:input type="file" path="uploadUploadForms[0].file" id="imgInp"/>
            <form:errors path="uploadUploadForms[0].file" />
    		<form:hidden path="uploadUploadForms[0].description" value ="Profile Picture"/>
            <br><br><br>

            <%-- file 2 --%>
            <form:label path="uploadUploadForms[1].file">Upload File</form:label> : 
            <form:input type="file" path="uploadUploadForms[1].file" />
            <form:errors path="uploadUploadForms[1].file" />
            <form:hidden path="uploadUploadForms[1].description" value ="CV"/>
            <br>
            
            <%-- submit button --%>
            <br>
            <form:button>Upload</form:button>
            <br>
        </form:form>
    </div>
</body>
</html>
