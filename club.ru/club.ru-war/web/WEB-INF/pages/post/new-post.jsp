<%-- 
    Document   : new-post
    Created on : 05.07.2019, 0:22:13
    Author     : nikitorches
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>
<%@taglib prefix="items" tagdir="/WEB-INF/tags/items/" %>
<fmt:setBundle basename="resources.labels"/>

<core:layout>
    <jsp:attribute name="title">
        <fmt:message key="label.post.new_post"/>
    </jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${empty update_post}">
                <items:createPostForm/>
            </c:when>
            <c:otherwise>
                <items:updatePostForm/>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</core:layout>
