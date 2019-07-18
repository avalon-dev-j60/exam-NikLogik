<%-- 
    Document   : post-view
    Created on : 08.07.2019, 19:50:15
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<fmt:setBundle basename="resources.labels"/>

<core:layout>
    <jsp:attribute name="title">
        ${post.title}
    </jsp:attribute>
    
    <jsp:body>
        <c:set var="context" value="${pageContext.servletContext.contextPath}"/>
        <div class="row">
            <form name="new-post" method="get" action="${context}/news">
                <button class="red-bg pull-right"><fmt:message key="label.back"/></button>
            </form>
        </div>
            <div class="row align-left padded border-bottom">
                <h2>
                    ${post.title}
                </h2>
                
            </div>
            <div class="padded">
                <p>
                    ${post.content}
                </p>
            </div>
                <c:if test="${user == post.author}">
                    <form name="delete" method="post" action="${context}/news/post">
                        <input type="submit" name="action" value="Delete">
                        <input type="submit" name="action" value="Update">
                        <input type="hidden" name="post" value="${post.id}">
                    </form>
                </c:if>
        <div class="row gap-top">
            <p><fmt:message key="label.post.created"/>: <fmt:formatDate value="${post.created}" pattern="HH:mm dd-MM-yyyy"/></p>
            <p><fmt:message key="label.post.author"/>: ${post.author}</p>
        </div>
    </jsp:body>
</core:layout>
