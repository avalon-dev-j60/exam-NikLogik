<%-- 
    Document   : user_profile
    Created on : 05.07.2019, 23:52:03
    Author     : nikitorches
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>

<%@attribute name="title" required="true"%>

<!DOCTYPE html>
<html>
    <head>
        <title>
            ${title}
        </title>
        <link href="${pageContext.servletContext.contextPath}/css/gw-setup.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <core:head/>
        <div class="two thirds centered justify padded">
            <header>
                <core:navigation/>
            </header>
            <article class="justify padded gap-bottom gap-top">
                <section class="four fifth right-one padded border-left border-right fadeInRight animated">
                    <jsp:doBody/>
                </section>
                <aside class="one fifth left-four padded flipInY animated">
                    <img class="round" src="pic/default-icon.jpg" alt="default_icon"></img>
                </aside>
            </article>
        </div>
        <div class="gap-top">
                <core:footer/>
        </div>
    </body>
</html>