<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>
<body>
<g:if test="${flash.message}">
    <div style="margin: 1em; border: 1px solid red; padding: 1em">
        <p>${flash.message}</p>
    </div>
</g:if>
<div style="margin: 1em; position: relative; clear: both;">
    <g:form action="search" style="position: absolute; right: 0;">
        <input type="text" name="searchString" value="${params?.searchString}">
        <g:submitButton name="Search" />
    </g:form><br style="clear: both;" />
</div>
<div style="margin: 1em; clear: both;">
    <g:each in="${albums}" var="album">
        <g:render template="/shared/albumEntryTemplate" model="${[editable: false, album: album]}" />
    </g:each>
</div>
</body>
</html>
