<%-- 
    Document   : news-author
    Created on : 09.07.2019, 14:33:10
    Author     : nikitorches
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="items" tagdir="/WEB-INF/tags/items/" %>

<fmt:setBundle basename="resources.labels"/>

<core:layout title="${user}">
    <jsp:body>
        <c:set var="context" value="${pageContext.servletContext.contextPath}"/>
        <c:set var="disabled_button" value="disabled='disabled' aria-disabled='true'"/>
        <div class="row">
            <form name="new-post" method="get" action="${context}/news">
                <button class="red-bg pull-right"><fmt:message key="label.back"/></button>
            </form>
        </div>
        <div>
            <c:choose>
                <c:when test="${empty posts}">
                    <center>
                        <h3>
                            <a href="${context}/new-post"><fmt:message key="label.post.empty"/></a>
                        </h3>
                    </center>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${posts}" var="post">
                        <div class="gapped">
                            <h3 class="black gap-bottom border-bottom white"><a href="${context}/news/post?id=${post.id}">
                                ${post.title}
                                </a>
                            </h3>
                                <p data-truncate="5"
                                    class="blue box truncate">
                                ${post.content}
                            </p>
                            <div class="row">
                                <p><fmt:message key="label.post.created"/>: <fmt:formatDate value="${post.created}" pattern="HH:mm dd-MM-yyyy"/></p>
                                <p><fmt:message key="label.post.author"/>: ${post.author}</p>
                            </div>
                        </div>
                    </c:forEach> 
                </c:otherwise>
            </c:choose>
        </div>
    </jsp:body>
</core:layout>
