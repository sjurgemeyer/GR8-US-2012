<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add album</title>
    <meta name="layout" content="main">
</head>
<body>
<div style="margin: 1em;">
    <g:form action="save">
        <f:all bean="album" />
        <g:submitButton name="Save" />
    </g:form>
</div>
</body>
</html>