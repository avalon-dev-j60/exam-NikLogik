<%-- 
    Document   : register
    Created on : 29.06.2019, 1:18:41
    Author     : nikitorches
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<html>
    <head>
        <title>
            ${title}
        </title>
        <link href="${pageContext.servletContext.contextPath}/css/gw-setup.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <core:head/>
        <div class="two thirds centered gap-top">
            <header>
                <div class="row">
                    <core:navigation/>
                </div>
            </header>
            <div class="row">
                <core:error/>
                <auth:registerForm/>
            </div>
        </div>
    </body>
</html>
    
    

