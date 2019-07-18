<%-- 
    Document   : layout
    Created on : 15.06.2019, 12:36:08
    Author     : JAVA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>
<%@taglib prefix="item" tagdir="/WEB-INF/tags/items/" %>

<%@attribute name="title" required="true"%>

<!DOCTYPE html>
<html>
    <head>
        <title>
            ${title}
        </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.servletContext.contextPath}/css/gw-setup.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <core:head/>
        <div class="two thirds centered justify padded">
            <header>
                <core:navigation/>
            </header>
            <article class="justify padded gap-bottom gap-top">
                <section class="three fifth right-one padded border-left border-right fadeInRight animated">
                    <jsp:doBody/>
                </section>
                <aside class="one fifth left-three padded flipInY animated">
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <item:user_aside/>
                        </c:when>
                        <c:otherwise>
                            <auth:auth_aside/>
                        </c:otherwise>
                    </c:choose>
                </aside>
                <aside class="one fifth border-left fadeInRight animated">
                    
                </aside>
            </article>
            
        </div>
        <div class="gap-top">
                <core:footer/>
        </div>
    </body>
</html>
