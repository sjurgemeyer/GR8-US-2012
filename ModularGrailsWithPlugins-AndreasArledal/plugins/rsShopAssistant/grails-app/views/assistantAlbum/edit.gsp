<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit album</title>
    <meta name="layout" content="main">
</head>
<body>
    <div style="margin: 1em;">
        <g:form action="update" id="${album.id}">
            <f:all bean="album" />
            <g:submitButton name="Save" />
        </g:form>
    </div>
</body>
</html>